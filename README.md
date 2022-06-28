# Calculator

The API REST is handler by Swagger UI v3.0.0:

```
http://localhost:8080/api/v1/swagger-ui/index.html
```

##### Supported methods

* binaryOperationExecute:

```
GET, http://localhost:8080/api/v1/calculator/binary-operation?operation={String}&operand1={BigDecimal}&operand2={BigDecimal}

operations:
* binaries
- addition
- subtraction
```
```
Examples:

http://localhost:8080/api/v1/calculator/binary-operation?operation=addition&operand1=3.0&operand2=9.5
Response:
12.5

http://localhost:8080/api/v1/calculator/binary-operation?operation=subtraction&operand1=3.0&operand2=9.5
Response:
-6.5

http://localhost:8080/api/v1/calculator/binary-operation?operation=mod&operand1=3.0&operand2=9.5
Response:
Binary operation not allowed! : [ mod ]
```