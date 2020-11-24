import simple.simple_pb2 as simple_pb2

simple_message = simple_pb2.SimpleMessage()
simple_message.id = 123
simple_message.is_simple = True
simple_message.name = "This is a simple message"
sample_list = simple_message.sample_list
sample_list.append(3)
sample_list.append(4)
sample_list.append(5)

print(simple_message)

with open("simple.bin", "wb") as f:
    print("Write to file")
    bytes_as_string = simple_message.SerializeToString()
    f.write(bytes_as_string)

with open("simple.bin", "rb") as f:
    print("Read values")
    simple_message_read = simple_pb2.SimpleMessage().FromString(f.read())

print(simple_message_read)

print("Is Simple? " + str(simple_message_read.is_simple))
