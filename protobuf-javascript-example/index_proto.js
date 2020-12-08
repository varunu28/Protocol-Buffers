const fs = require("fs")
const Schema = require("./employees_pb")

const tom = new Schema.Employee();
tom.setId(1001);
tom.setName("Tom");
tom.setSalary(1000);

console.log("My name is " + tom.getName());

const jason = new Schema.Employee();
jason.setId(1002);
jason.setName("Jason");
jason.setSalary(9000);

console.log("My name is " + jason.getName());

const rick = new Schema.Employee();
rick.setId(1002);
rick.setName("Rick");
rick.setSalary(5000);

console.log("My name is " + rick.getName());

const employees = new Schema.Employees();
employees.addEmployees(tom);
employees.addEmployees(jason);
employees.addEmployees(rick);

const bytes = employees.serializeBinary();
console.log("binary: " + bytes);
fs.writeFileSync("binarydata", bytes)

// Deserialize
const deserialized_employees = Schema.Employees.deserializeBinary(bytes)
console.log("Deserialized: " + JSON.stringify(deserialized_employees))