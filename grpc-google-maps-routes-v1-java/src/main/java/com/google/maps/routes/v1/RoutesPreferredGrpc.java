package com.google.maps.routes.v1;

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
 * <pre>
 * The Routes Preferred API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/maps/routes/v1/route_service.proto")
public final class RoutesPreferredGrpc {

  private RoutesPreferredGrpc() {}

  public static final String SERVICE_NAME = "google.maps.routes.v1.RoutesPreferred";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.maps.routes.v1.ComputeRoutesRequest,
      com.google.maps.routes.v1.ComputeRoutesResponse> getComputeRoutesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ComputeRoutes",
      requestType = com.google.maps.routes.v1.ComputeRoutesRequest.class,
      responseType = com.google.maps.routes.v1.ComputeRoutesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.maps.routes.v1.ComputeRoutesRequest,
      com.google.maps.routes.v1.ComputeRoutesResponse> getComputeRoutesMethod() {
    io.grpc.MethodDescriptor<com.google.maps.routes.v1.ComputeRoutesRequest, com.google.maps.routes.v1.ComputeRoutesResponse> getComputeRoutesMethod;
    if ((getComputeRoutesMethod = RoutesPreferredGrpc.getComputeRoutesMethod) == null) {
      synchronized (RoutesPreferredGrpc.class) {
        if ((getComputeRoutesMethod = RoutesPreferredGrpc.getComputeRoutesMethod) == null) {
          RoutesPreferredGrpc.getComputeRoutesMethod = getComputeRoutesMethod =
              io.grpc.MethodDescriptor.<com.google.maps.routes.v1.ComputeRoutesRequest, com.google.maps.routes.v1.ComputeRoutesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ComputeRoutes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.maps.routes.v1.ComputeRoutesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.maps.routes.v1.ComputeRoutesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RoutesPreferredMethodDescriptorSupplier("ComputeRoutes"))
              .build();
        }
      }
    }
    return getComputeRoutesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RoutesPreferredStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoutesPreferredStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RoutesPreferredStub>() {
        @java.lang.Override
        public RoutesPreferredStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoutesPreferredStub(channel, callOptions);
        }
      };
    return RoutesPreferredStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RoutesPreferredBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoutesPreferredBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RoutesPreferredBlockingStub>() {
        @java.lang.Override
        public RoutesPreferredBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoutesPreferredBlockingStub(channel, callOptions);
        }
      };
    return RoutesPreferredBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RoutesPreferredFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoutesPreferredFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RoutesPreferredFutureStub>() {
        @java.lang.Override
        public RoutesPreferredFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoutesPreferredFutureStub(channel, callOptions);
        }
      };
    return RoutesPreferredFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The Routes Preferred API.
   * </pre>
   */
  public static abstract class RoutesPreferredImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Returns the primary route along with optional alternate routes, given a set
     * of terminal and intermediate waypoints.
     * **NOTE:** This method requires that you specify a response field mask in
     * the input. You can provide the response field mask by using URL parameter
     * `$fields` or `fields`, or by using an HTTP/gRPC header `X-Goog-FieldMask`
     * (see the [available URL parameters and
     * headers](https://cloud.google.com/apis/docs/system-parameters). The value
     * is a comma separated list of field paths. See detailed documentation about
     * [how to construct the field
     * paths](https://github.com/protocolbuffers/protobuf/blob/master/src/google/protobuf/field_mask.proto).
     * For example, in this method:
     * * Field mask of all available fields (for manual inspection):
     *   `X-Goog-FieldMask: *`
     * * Field mask of Route-level duration, distance, and polyline (an example
     * production setup):
     *   `X-Goog-FieldMask:
     *   routes.duration,routes.distanceMeters,routes.polyline.encodedPolyline`
     * Google discourage the use of the wildcard (`*`) response field mask, or
     * specifying the field mask at the top level (`routes`), because:
     * * Selecting only the fields that you need helps our server save computation
     * cycles, allowing us to return the result to you with a lower latency.
     * * Selecting only the fields that you need
     * in your production job ensures stable latency performance. We might add
     * more response fields in the future, and those new fields might require
     * extra computation time. If you select all fields, or if you select all
     * fields at the top level, then you might experience performance degradation
     * because any new field we add will be automatically included in the
     * response.
     * * Selecting only the fields that you need results in a smaller response
     * size, and thus higher network throughput.
     * </pre>
     */
    public void computeRoutes(com.google.maps.routes.v1.ComputeRoutesRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.routes.v1.ComputeRoutesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getComputeRoutesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getComputeRoutesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.maps.routes.v1.ComputeRoutesRequest,
                com.google.maps.routes.v1.ComputeRoutesResponse>(
                  this, METHODID_COMPUTE_ROUTES)))
          .build();
    }
  }

  /**
   * <pre>
   * The Routes Preferred API.
   * </pre>
   */
  public static final class RoutesPreferredStub extends io.grpc.stub.AbstractAsyncStub<RoutesPreferredStub> {
    private RoutesPreferredStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoutesPreferredStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoutesPreferredStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the primary route along with optional alternate routes, given a set
     * of terminal and intermediate waypoints.
     * **NOTE:** This method requires that you specify a response field mask in
     * the input. You can provide the response field mask by using URL parameter
     * `$fields` or `fields`, or by using an HTTP/gRPC header `X-Goog-FieldMask`
     * (see the [available URL parameters and
     * headers](https://cloud.google.com/apis/docs/system-parameters). The value
     * is a comma separated list of field paths. See detailed documentation about
     * [how to construct the field
     * paths](https://github.com/protocolbuffers/protobuf/blob/master/src/google/protobuf/field_mask.proto).
     * For example, in this method:
     * * Field mask of all available fields (for manual inspection):
     *   `X-Goog-FieldMask: *`
     * * Field mask of Route-level duration, distance, and polyline (an example
     * production setup):
     *   `X-Goog-FieldMask:
     *   routes.duration,routes.distanceMeters,routes.polyline.encodedPolyline`
     * Google discourage the use of the wildcard (`*`) response field mask, or
     * specifying the field mask at the top level (`routes`), because:
     * * Selecting only the fields that you need helps our server save computation
     * cycles, allowing us to return the result to you with a lower latency.
     * * Selecting only the fields that you need
     * in your production job ensures stable latency performance. We might add
     * more response fields in the future, and those new fields might require
     * extra computation time. If you select all fields, or if you select all
     * fields at the top level, then you might experience performance degradation
     * because any new field we add will be automatically included in the
     * response.
     * * Selecting only the fields that you need results in a smaller response
     * size, and thus higher network throughput.
     * </pre>
     */
    public void computeRoutes(com.google.maps.routes.v1.ComputeRoutesRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.routes.v1.ComputeRoutesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getComputeRoutesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The Routes Preferred API.
   * </pre>
   */
  public static final class RoutesPreferredBlockingStub extends io.grpc.stub.AbstractBlockingStub<RoutesPreferredBlockingStub> {
    private RoutesPreferredBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoutesPreferredBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoutesPreferredBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the primary route along with optional alternate routes, given a set
     * of terminal and intermediate waypoints.
     * **NOTE:** This method requires that you specify a response field mask in
     * the input. You can provide the response field mask by using URL parameter
     * `$fields` or `fields`, or by using an HTTP/gRPC header `X-Goog-FieldMask`
     * (see the [available URL parameters and
     * headers](https://cloud.google.com/apis/docs/system-parameters). The value
     * is a comma separated list of field paths. See detailed documentation about
     * [how to construct the field
     * paths](https://github.com/protocolbuffers/protobuf/blob/master/src/google/protobuf/field_mask.proto).
     * For example, in this method:
     * * Field mask of all available fields (for manual inspection):
     *   `X-Goog-FieldMask: *`
     * * Field mask of Route-level duration, distance, and polyline (an example
     * production setup):
     *   `X-Goog-FieldMask:
     *   routes.duration,routes.distanceMeters,routes.polyline.encodedPolyline`
     * Google discourage the use of the wildcard (`*`) response field mask, or
     * specifying the field mask at the top level (`routes`), because:
     * * Selecting only the fields that you need helps our server save computation
     * cycles, allowing us to return the result to you with a lower latency.
     * * Selecting only the fields that you need
     * in your production job ensures stable latency performance. We might add
     * more response fields in the future, and those new fields might require
     * extra computation time. If you select all fields, or if you select all
     * fields at the top level, then you might experience performance degradation
     * because any new field we add will be automatically included in the
     * response.
     * * Selecting only the fields that you need results in a smaller response
     * size, and thus higher network throughput.
     * </pre>
     */
    public com.google.maps.routes.v1.ComputeRoutesResponse computeRoutes(com.google.maps.routes.v1.ComputeRoutesRequest request) {
      return blockingUnaryCall(
          getChannel(), getComputeRoutesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The Routes Preferred API.
   * </pre>
   */
  public static final class RoutesPreferredFutureStub extends io.grpc.stub.AbstractFutureStub<RoutesPreferredFutureStub> {
    private RoutesPreferredFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoutesPreferredFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoutesPreferredFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the primary route along with optional alternate routes, given a set
     * of terminal and intermediate waypoints.
     * **NOTE:** This method requires that you specify a response field mask in
     * the input. You can provide the response field mask by using URL parameter
     * `$fields` or `fields`, or by using an HTTP/gRPC header `X-Goog-FieldMask`
     * (see the [available URL parameters and
     * headers](https://cloud.google.com/apis/docs/system-parameters). The value
     * is a comma separated list of field paths. See detailed documentation about
     * [how to construct the field
     * paths](https://github.com/protocolbuffers/protobuf/blob/master/src/google/protobuf/field_mask.proto).
     * For example, in this method:
     * * Field mask of all available fields (for manual inspection):
     *   `X-Goog-FieldMask: *`
     * * Field mask of Route-level duration, distance, and polyline (an example
     * production setup):
     *   `X-Goog-FieldMask:
     *   routes.duration,routes.distanceMeters,routes.polyline.encodedPolyline`
     * Google discourage the use of the wildcard (`*`) response field mask, or
     * specifying the field mask at the top level (`routes`), because:
     * * Selecting only the fields that you need helps our server save computation
     * cycles, allowing us to return the result to you with a lower latency.
     * * Selecting only the fields that you need
     * in your production job ensures stable latency performance. We might add
     * more response fields in the future, and those new fields might require
     * extra computation time. If you select all fields, or if you select all
     * fields at the top level, then you might experience performance degradation
     * because any new field we add will be automatically included in the
     * response.
     * * Selecting only the fields that you need results in a smaller response
     * size, and thus higher network throughput.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.maps.routes.v1.ComputeRoutesResponse> computeRoutes(
        com.google.maps.routes.v1.ComputeRoutesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getComputeRoutesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COMPUTE_ROUTES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RoutesPreferredImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RoutesPreferredImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COMPUTE_ROUTES:
          serviceImpl.computeRoutes((com.google.maps.routes.v1.ComputeRoutesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.routes.v1.ComputeRoutesResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RoutesPreferredBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RoutesPreferredBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.maps.routes.v1.RoutesServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RoutesPreferred");
    }
  }

  private static final class RoutesPreferredFileDescriptorSupplier
      extends RoutesPreferredBaseDescriptorSupplier {
    RoutesPreferredFileDescriptorSupplier() {}
  }

  private static final class RoutesPreferredMethodDescriptorSupplier
      extends RoutesPreferredBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RoutesPreferredMethodDescriptorSupplier(String methodName) {
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
      synchronized (RoutesPreferredGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RoutesPreferredFileDescriptorSupplier())
              .addMethod(getComputeRoutesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
