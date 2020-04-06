package fax;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.processing.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: fax.proto")
public final class FaxServiceGrpc {

  private FaxServiceGrpc() {}

  public static final String SERVICE_NAME = "Fax.FaxService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<fax.PowerRequest,
      fax.PowerResponse> getSwitchPowerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "switchPower",
      requestType = fax.PowerRequest.class,
      responseType = fax.PowerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<fax.PowerRequest,
      fax.PowerResponse> getSwitchPowerMethod() {
    io.grpc.MethodDescriptor<fax.PowerRequest, fax.PowerResponse> getSwitchPowerMethod;
    if ((getSwitchPowerMethod = FaxServiceGrpc.getSwitchPowerMethod) == null) {
      synchronized (FaxServiceGrpc.class) {
        if ((getSwitchPowerMethod = FaxServiceGrpc.getSwitchPowerMethod) == null) {
          FaxServiceGrpc.getSwitchPowerMethod = getSwitchPowerMethod = 
              io.grpc.MethodDescriptor.<fax.PowerRequest, fax.PowerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Fax.FaxService", "switchPower"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  fax.PowerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  fax.PowerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FaxServiceMethodDescriptorSupplier("switchPower"))
                  .build();
          }
        }
     }
     return getSwitchPowerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<fax.FaxRequest,
      fax.FaxResponse> getSendFaxMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendFax",
      requestType = fax.FaxRequest.class,
      responseType = fax.FaxResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<fax.FaxRequest,
      fax.FaxResponse> getSendFaxMethod() {
    io.grpc.MethodDescriptor<fax.FaxRequest, fax.FaxResponse> getSendFaxMethod;
    if ((getSendFaxMethod = FaxServiceGrpc.getSendFaxMethod) == null) {
      synchronized (FaxServiceGrpc.class) {
        if ((getSendFaxMethod = FaxServiceGrpc.getSendFaxMethod) == null) {
          FaxServiceGrpc.getSendFaxMethod = getSendFaxMethod = 
              io.grpc.MethodDescriptor.<fax.FaxRequest, fax.FaxResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Fax.FaxService", "sendFax"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  fax.FaxRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  fax.FaxResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FaxServiceMethodDescriptorSupplier("sendFax"))
                  .build();
          }
        }
     }
     return getSendFaxMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FaxServiceStub newStub(io.grpc.Channel channel) {
    return new FaxServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FaxServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FaxServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FaxServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FaxServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FaxServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void switchPower(fax.PowerRequest request,
        io.grpc.stub.StreamObserver<fax.PowerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSwitchPowerMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<fax.FaxRequest> sendFax(
        io.grpc.stub.StreamObserver<fax.FaxResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendFaxMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSwitchPowerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                fax.PowerRequest,
                fax.PowerResponse>(
                  this, METHODID_SWITCH_POWER)))
          .addMethod(
            getSendFaxMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                fax.FaxRequest,
                fax.FaxResponse>(
                  this, METHODID_SEND_FAX)))
          .build();
    }
  }

  /**
   */
  public static final class FaxServiceStub extends io.grpc.stub.AbstractStub<FaxServiceStub> {
    private FaxServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FaxServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FaxServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FaxServiceStub(channel, callOptions);
    }

    /**
     */
    public void switchPower(fax.PowerRequest request,
        io.grpc.stub.StreamObserver<fax.PowerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSwitchPowerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<fax.FaxRequest> sendFax(
        io.grpc.stub.StreamObserver<fax.FaxResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSendFaxMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class FaxServiceBlockingStub extends io.grpc.stub.AbstractStub<FaxServiceBlockingStub> {
    private FaxServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FaxServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FaxServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FaxServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public fax.PowerResponse switchPower(fax.PowerRequest request) {
      return blockingUnaryCall(
          getChannel(), getSwitchPowerMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FaxServiceFutureStub extends io.grpc.stub.AbstractStub<FaxServiceFutureStub> {
    private FaxServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FaxServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FaxServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FaxServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<fax.PowerResponse> switchPower(
        fax.PowerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSwitchPowerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SWITCH_POWER = 0;
  private static final int METHODID_SEND_FAX = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FaxServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FaxServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SWITCH_POWER:
          serviceImpl.switchPower((fax.PowerRequest) request,
              (io.grpc.stub.StreamObserver<fax.PowerResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_FAX:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendFax(
              (io.grpc.stub.StreamObserver<fax.FaxResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FaxServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FaxServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return fax.FaxServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FaxService");
    }
  }

  private static final class FaxServiceFileDescriptorSupplier
      extends FaxServiceBaseDescriptorSupplier {
    FaxServiceFileDescriptorSupplier() {}
  }

  private static final class FaxServiceMethodDescriptorSupplier
      extends FaxServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FaxServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FaxServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FaxServiceFileDescriptorSupplier())
              .addMethod(getSwitchPowerMethod())
              .addMethod(getSendFaxMethod())
              .build();
        }
      }
    }
    return result;
  }
}
