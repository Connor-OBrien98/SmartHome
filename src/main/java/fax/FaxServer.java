package fax;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import fax.FaxServiceGrpc.FaxServiceImplBase;

public class FaxServer extends FaxServiceImplBase{
	
	private static final Logger logger = Logger.getLogger(FaxServer.class.getName());
	
	public static void main(String[] args) throws IOException, InterruptedException {
		FaxServer printerserver = new FaxServer();
	   
		int port = 50053;
	    Server server = ServerBuilder.forPort(port)
	        .addService(printerserver)
	        .build()
	        .start();
	    
	    logger.info("Server started, listening on " + port);
	    		    
	    server.awaitTermination();
	}
	
	public void switchPower(PowerRequest request, StreamObserver<PowerResponse> responseObserver) {
        System.out.println("Receiving request...");

        System.out.println("Light power");

        Boolean power = request.getState(); 
        
        PowerResponse response = PowerResponse.newBuilder().setState(power).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

	}
	
	public StreamObserver<FaxRequest> faxStatement(final StreamObserver<FaxResponse> responseObserver) {
      return new StreamObserver<FaxRequest>() {
        public void onNext(FaxRequest request) {
            StringBuilder statement = new StringBuilder(); 
  
            statement.append(request.getText());
            System.out.println(statement);
        
            FaxResponse reply = FaxResponse.newBuilder().setText(statement.toString()).build();
      
            responseObserver.onNext(reply);
          }

        public void onError(Throwable t) {
          System.out.println("Error, service stopped");
        }
        public void onCompleted() {
          responseObserver.onCompleted();
        }
      };
    }
}