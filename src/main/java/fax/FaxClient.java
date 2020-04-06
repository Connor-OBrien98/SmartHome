package fax;

import java.util.Random;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class FaxClient {
	
	
	private static FaxServiceGrpc.FaxServiceBlockingStub blockingStub;
	private static FaxServiceGrpc.FaxServiceStub asyncStub;
	
	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
		blockingStub = FaxServiceGrpc.newBlockingStub(channel);
		asyncStub = FaxServiceGrpc.newStub(channel);
		switchPower();
		sendFax();

	}
	
	public static void switchPower() {
		PowerRequest request = PowerRequest.newBuilder().setState(true).build();
		PowerResponse response = blockingStub.switchPower(request);
		
		System.out.println(response.getState());
	}
	
	public static void sendFax(){

		StreamObserver<FaxResponse> responseObserver = new StreamObserver<FaxResponse>() {

			@Override
			public void onNext(FaxResponse value) {
				System.out.println("receiving statement to print -> " + value.getText());
			}

			@Override
			public void onError(Throwable t) {

			}

			@Override
			public void onCompleted() {

			}

		};

		StreamObserver<FaxRequest> requestObserver = asyncStub.sendFax(responseObserver);
		try {

			requestObserver.onNext(FaxRequest.newBuilder().setText("1").build());
			requestObserver.onNext(FaxRequest.newBuilder().setText("2").build());
			requestObserver.onNext(FaxRequest.newBuilder().setText("3").build());
			requestObserver.onNext(FaxRequest.newBuilder().setText("4").build());
			requestObserver.onNext(FaxRequest.newBuilder().setText("5").build());
			
			Thread.sleep(new Random().nextInt(1000) + 500);

		} catch (RuntimeException e) {
            requestObserver.onError(e);
            throw e;
            } catch (InterruptedException e) {

                e.printStackTrace();
        }

		requestObserver.onCompleted();
	}
}
