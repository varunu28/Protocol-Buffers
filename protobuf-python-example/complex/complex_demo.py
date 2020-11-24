import complex.complex_pb2 as complex_pb2

complex_message = complex_pb2.ComplexMessage()
complex_message.one_dummy.id = 123
complex_message.one_dummy.name = "one dummy message"

first_multiple_dummy = complex_message.multiple_dummy.add()
first_multiple_dummy.id = 345
first_multiple_dummy.name = "second dummy message"

second_multiple_dummy = complex_message.multiple_dummy.add()
second_multiple_dummy.id = 567
second_multiple_dummy.name = "third dummy message"

print(complex_message)
