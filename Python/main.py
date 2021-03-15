import sys

from zeep import Client
import logging

logging.basicConfig(stream=sys.stdout, level=logging.DEBUG)

if __name__ == '__main__':
    client = Client("http://www.learnwebservices.com/services/hello?WSDL")

    request = {"Name": "Naressi"}
    logging.info(f"Request body: {request}")
    result = client.service.SayHello(request)
    logging.info(f"Result: {result}")
    print(result)
    print("WITORIA TCHOP")
