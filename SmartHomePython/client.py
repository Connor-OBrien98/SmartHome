import grpc
import genericpath

import coffee_pb2
import coffee_pb2_grpc

channel = grpc.insecure_channel('localhost:50054')

stub = coffee_pb2_grpc.CoffeeStub(channel)

command = coffee_pb2.Command(command="brew coffee")

response = stub.ChangeCommand(command)

print(response.command)