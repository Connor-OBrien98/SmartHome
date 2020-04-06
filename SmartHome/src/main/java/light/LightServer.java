package light;

import java.io.IOException;
import java.util.logging.Logger;

import light.LightServer;
import light.LightServiceGrpc.LightServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import light.PowerRequest;
import light.PowerResponse;
import io.grpc.stub.StreamObserver;

public class LightServer extends LightServiceImplBase {
	private static final Logger logger = Logger.getLogger(LightServer.class.getName());
	
	public static void main(String[] args) throws IOException, InterruptedException {
		 LightServer lightserver = new LightServer();
		   
		    int port = 50051;
		    Server server = ServerBuilder.forPort(port)
		        .addService(lightserver)
		        .build()
		        .start();
		    
		    logger.info("Server started, listening on " + port);
		    		    
		    server.awaitTermination();
	 }
	
	public void changePower(PowerRequest request, StreamObserver<PowerResponse> responseObserver) {
		 System.out.println("Receiving power request");
		 
		 Boolean power = request.getState();
		 
		 if(power) {
			 System.out.println("Changing lights to on");
		 } 
		 else {
			 System.out.println("Changing lights to off");
		 }
		 
		 PowerResponse response = PowerResponse.newBuilder().setState(power).build();
		 		
		 responseObserver.onNext(response); 
		 responseObserver.onCompleted();
	}
	
	public StreamObserver<BrightnessRequest> setBrightness(final StreamObserver<BrightnessResponse> responseObserver) {
		
		return new StreamObserver<BrightnessRequest>() {
			
			int brightness = 0;
			
			public void onNext(BrightnessRequest value) {
				
				brightness = value.getBright();
				System.out.println("Request to turn brightness to -> " + brightness);
				
			}
			
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			public void onCompleted() {
				BrightnessResponse response = BrightnessResponse.newBuilder().setBright(brightness).build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
			}
		};
	}
}
