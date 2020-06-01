# Getting Started

### How to run
To run the application follow the following steps:
1. Go to project main directory
2. Execute mvn clean install(make sure you have Docker running with exposed port 2375)
3. Execute docker-compose up -d
### How to use
Go to url http://localhost:8080/prime-number/check/number to check if number is prime where:
* number(Integer) - number to be checked for prime up to integer's max size.

Example: http://localhost:8080/prime-number/check/5

Go to url http://localhost:8080/prime-number/next/number where:
* number(Integer) - number to be used as a base to find next prime. if the inputed number is prime it will be returned.

Example: http://localhost:8080/prime-number/next/5

### Implementation notes
For this example the application supports only int numbers. 
For bigger numbers other more optimized probabilistic algorithms must be used, 
like enough rounds of Miller-Rabbin or Baillie-PSW for which no one has found false positives for n < 2^64.
I have used an optimized solution for checking if number is prime which takes advantage of the fact that all primes are in the form of 6k ± 1, with the exception of 2 and 3. It's running time is O(sqrt(N)) and space complexity is O(1).Also for all int's(java type) it is a better solution, than using Miller-Rabbin or Baillie-PSW, because it is more accurate and is not probabilistic.It's performance compared to them is good also.
I was planning to use this solution for 32 bit numbers and Baillie-PSW for bigger ones, but didn't have the time to implement Baillie-PSW.
ThreadSafety is marked via @ThreadSafe annotation. 
The spring beans of the controller and the service are singleton scopes and are not thread safe themselfs but the code in them is.
The Solution consumes very little memory.
### Test Cases
1. Base cases input 0, 1, 2, 3 should be handled.
2. Max Size int should be handled.
3. Negative numbers are wrong input and should not be excepted.
