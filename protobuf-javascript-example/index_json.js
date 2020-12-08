const fs = require("fs")
const employees = []

employees.push({
    "name": "Tom",
    "Salary": 1000,
    "id": 1001
})

const jason = {
    "name": "Jason",
    "Salary": 9000,
    "id": 1002
}

employees.push(jason)

employees.push({
    "name": "Rick",
    "Salary": 4000,
    "id": 1003
})

console.log(JSON.stringify(employees));
fs.writeFileSync("jsondata.json", JSON.stringify(employees));