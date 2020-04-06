import grpc
from concurrent import futures
import time

import coffee_pb2
import coffee_pb2_grpc

class CoffeeServicer(coffee_pb2_grpc.CoffeeServicer):

    def ChangeCommand(self, request, context):
        print("Request to change input to " + request.input)

        response = coffee_pb2.Command()
        response.command = ("The command has been altered to " + request.command)
        return response

server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))

coffee_pb2_grpc.add_CoffeeServicer_to_server(
        CoffeeServicer(), server)

print('Starting server. Listening on port 50054.')
server.add_insecure_port('[::]:50054')
server.start()

try:
    while True:
        time.sleep(86400)
except KeyboardInterrupt:
    server.stop(0)