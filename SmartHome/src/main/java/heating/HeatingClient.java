package heating;

import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class HeatingClient {
	private static  Logger logger = Logger.getLogger(HeatingClient.class.getName());

	private static HeatingServiceGrpc.HeatingServiceBlockingStub blockingStub;
	private static HeatingServiceGrpc.HeatingServiceStub asyncStub;
	private static HeatingServiceGrpc.HeatingServiceFutureStub futureStub;

	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();

		//stubs -- generate from proto
		blockingStub = HeatingServiceGrpc.newBlockingStub(channel);
		asyncStub = HeatingServiceGrpc.newStub(channel);
		futureStub =  HeatingServiceGrpc.newFutureStub(channel);
		
		changePower();
		changeTemperature();
	}
	
	public static void changePower() {

		PowerRequest state = PowerRequest.newBuilder().setState(false).build();

		PowerResponse response = blockingStub.changePower(state);

		System.out.println(response.getState());
	}
	
	public static void changeTemperature() {
		TemperatureRequest request = TemperatureRequest.newBuilder().setTemp(6).build();
		
		StreamObserver<TemperatureResponse> responseObserver = new StreamObserver<TemperatureResponse>() {
			
			@Override
			public void onNext(TemperatureResponse value) {
				System.out.println("receiving " + value);
			}
			
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
			@Override
			public void onCompleted() {
				System.out.println("on completed ");
			}
		};
		
		asyncStub.changeTemperature(request, responseObserver);
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
