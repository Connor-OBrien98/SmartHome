package heating;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import heating.HeatingServiceGrpc.HeatingServiceImplBase;
import io.grpc.stub.StreamObserver;

public class HeatingServer extends HeatingServiceImplBase {
	private static final Logger logger = Logger.getLogger(HeatingServer.class.getName());

	
	 public static void main(String[] args) throws IOException, InterruptedException {
		 HeatingServer heatingserver = new HeatingServer();
		   
		    int port = 50051;
		    Server server = ServerBuilder.forPort(port)
		        .addService(heatingserver)
		        .build()
		        .start();
		    
		    logger.info("Server started, listening on " + port);
		    		    
		    server.awaitTermination();
	 }
	 
	 public void changePower(PowerRequest request, StreamObserver<PowerResponse> responseObserver) {
		 System.out.println("receiving power request");
		 
		 Boolean state = request.getState();
		 System.out.println(state);
		 
		 responseObserver.onNext(PowerResponse.newBuilder().setState(true).build());
		 
		 responseObserver.onCompleted();
	}
	
	 public void changeTemperature(TemperatureRequest request, StreamObserver<TemperatureResponse> responseObserver) {
		 System.out.println("receiving temp request");
		 
		 int temp = request.getTemp();
		 System.out.println(temp);
		 responseObserver.onNext(TemperatureResponse.newBuilder().setTemp(5).build());
		 responseObserver.onCompleted();
	 }
}
