# mongo-project

As a part of assignment, I have developed a rest-api for Employee Management. I have used Spring boot framework for development and mongoDb for Database.
CRUD operations on mongoDb is performed.

I have the following endpoints : 

1 : 	@GetMapping("/api/getallemployeedetails")
This endpoint is to fetch all the Employees present in the database. 

2 :    @GetMapping("/api/getemployeedetailsbyids/{employeeIds}")
This endpoint is to fetch Employee details by passing a single or a list of Employee Id
Input : This endpoint will take list of employeeid as input (eg : /api/getemployeedetailsbyids/1,2).

3 :    @PostMapping(value = "/api/addemployeedetails")
This endpoint is used to add Employee in the database. The parameter is List of Employees so we can save a single or multiple employees through this endpoint.
Input : It takes Employee object as input
eg : 
[{
"employee_id" : "2",
"first_name" : "Debasish Das",
"dob" : "1992-06-22",
"designation" : "Software Engineer",
"address" :
[
{
"address_type" : "permanent",
"addressLine1" : "Issapurhati",
"city" : "Barpeta",
"pin" : "781301",
"state" : "Assam",
"country" : "India"
},
{
"address_type" : "temporary",
"addressLine1" : "Bellandur",
"city" : "bangalore",
"state" : "Karnataka",
"country" : "India"
},
{
"address_type" : "office",
"addressLine1" : "Mahadevpura",
"city" : "Bangalore",
"pin" : "560114",
"state" : "Karntaka",
"country" : "India"
}
] 
}
]

4 : @PatchMapping(value = "/api/updateemployeeDetails")
This endpoint is to update an/mnultiple existing Employee(s)' entry. We can update any fields of Employee Object with this endpoint(eg : Designation, State,country, employeeId)
Input : It takes Employee Object as input. 
eg : can refer the abobe Employee Object
	 
5 : @DeleteMapping(value = "/api/deleteemployeeDetails/{employeeIds}")
This endpoint is to delete an/mnultiple existing Employee(s)' entry
Input : This endpoint takes an employeeId as input. eg(/api/deleteemployeeDetails/2)

6 : @GetMapping(value = "/api/getStatesByCountry/{country}")
This endpoint is to fetch the states of a particular Country
Input : It takes country name ( Country name should stat with Capital letter followed by small letter). 
eg : /api/getStatesByCountry/India
