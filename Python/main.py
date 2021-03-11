from zeep import Client

client = Client("http://www.learnwebservices.com/services/hello?WSDL")

request = {"Name": "Naressi"}

result = client.service.SayHello(request)
print(result)
