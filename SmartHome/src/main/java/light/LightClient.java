package light;

import java.util.Random;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;


public class LightClient {

	private static LightServiceGrpc.LightServiceBlockingStub blockingStub;
	private static LightServiceGrpc.LightServiceStub asyncStub;

	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

		blockingStub = LightServiceGrpc.newBlockingStub(channel);
		asyncStub = LightServiceGrpc.newStub(channel);

		changePower();
		setBrightness();

	}
	
	public static void changePower() {

		PowerRequest request = PowerRequest.newBuilder().setState(true).build();

		PowerResponse response = blockingStub.changePower(request);
		
		if (response.getState()) {
			System.out.println("Light turned on");
		}
		else {
			System.out.println("Light turned off");
		}
		
    }
	
	public static void setBrightness() {
		StreamObserver<BrightnessResponse> responseObserver = new StreamObserver<BrightnessResponse>() {
			@Override
			public void onNext(BrightnessResponse value) {				
				System.out.println("Brightness has been set to level " + value.getBright());
			}

			@Override
			public void onError(Throwable t) {

			}

			@Override
			public void onCompleted() {

			}			
		};
		
		StreamObserver<BrightnessRequest> requestObserver = asyncStub.setBrightness(responseObserver);
		try {

			requestObserver.onNext(BrightnessRequest.newBuilder().setBright(1).build());
			requestObserver.onNext(BrightnessRequest.newBuilder().setBright(2).build());
			requestObserver.onNext(BrightnessRequest.newBuilder().setBright(3).build());
			requestObserver.onNext(BrightnessRequest.newBuilder().setBright(4).build());
			requestObserver.onNext(BrightnessRequest.newBuilder().setBright(5).build());
			
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
