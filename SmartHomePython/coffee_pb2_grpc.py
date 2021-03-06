# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
import grpc

import coffee_pb2 as coffee__pb2


class CoffeeStub(object):
  # missing associated documentation comment in .proto file
  pass

  def __init__(self, channel):
    """Constructor.

    Args:
      channel: A grpc.Channel.
    """
    self.ChangeCommand = channel.unary_unary(
        '/Coffee/ChangeCommand',
        request_serializer=coffee__pb2.Command.SerializeToString,
        response_deserializer=coffee__pb2.Command.FromString,
        )


class CoffeeServicer(object):
  # missing associated documentation comment in .proto file
  pass

  def ChangeCommand(self, request, context):
    # missing associated documentation comment in .proto file
    pass
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')


def add_CoffeeServicer_to_server(servicer, server):
  rpc_method_handlers = {
      'ChangeCommand': grpc.unary_unary_rpc_method_handler(
          servicer.ChangeCommand,
          request_deserializer=coffee__pb2.Command.FromString,
          response_serializer=coffee__pb2.Command.SerializeToString,
      ),
  }
  generic_handler = grpc.method_handlers_generic_handler(
      'Coffee', rpc_method_handlers)
  server.add_generic_rpc_handlers((generic_handler,))
