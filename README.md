# Bkash_Backend
Features 

-Application events and listeners

-Admin features

-Externalized Configuration

-Properties Files

-YAML Support

-Type-safe Configuration(beta)


-Logging

-Security(Beta) 


###############################################

Database-Postgresql
Server-Heroku


Allowed HTTPs requests:

PUT     : To create resource /Update

POST    : Update resource

GET     : Get a resource or list of resources

DELETE  : To delete resource



Description Of Usual Server Responses:

200 OK - the request was successful (some API calls may return 201 instead).

201 Created - the request was successful and a resource was created.

204 No Content - the request was successful but there is no representation to return (i.e. the response is empty).

400 Bad Request - the request could not be understood or was missing required parameters.

401 Unauthorized - authentication failed or user doesn't have permissions for requested operation.

403 Forbidden - access denied.404 Not Found - resource was not found.405 Method Not Allowed - requested method is not supported for resource.


Table sample

{

    "customerID": 1,
    
    "customerName": "",
    
    "customerAddresss": "",
    
    "customerCode": "",
    
    "balance": ,
    
    "pin": ,
    
    "email": "",
    
    "phone": 0,
    
    "nid": 0
    
  },
  
 API Sample
 
 https://sanzar.herokuapp.com/customers
 
 Result
 
 [
  {
    "customerID": 1,
    "customerName": "NZAR",
    "customerAddresss": "eedn",
    "customerCode": "6868",
    "balance": 100000,
    "pin": 866,
    "email": "",
    "phone": 0,
    "nid": 0
  },
  
  {
    "customerID": 4,
    "customerName": "ddNZAR",
    "customerAddresss": "ddeedn",
    "customerCode": "6868",
    "balance": 100000,
    "pin": 866,
    "email": "ddd",
    "phone": 33,
    "nid": 654
  },
  
  {
    "customerID": 5,
    "customerName": "ddffrNZAR",
    "customerAddresss": "frfrddeedn",
    "customerCode": "632868",
    "balance": 100000,
    "pin": 58566,
    "email": "sanzar",
    "phone": 555533,
    "nid": 65555
  }
  
]
 
  
  
