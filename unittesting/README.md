# Unit Testing
This project was created in order to practise and get familiar with unit testing and continuous integration tools.

## Tools used
- [JUnit 4](https://junit.org/junit4/)
- [Mockito](https://site.mockito.org/)
- [JaCoCo](https://www.eclemma.org/jacoco/)
- [Travis CI](https://travis-ci.com/)

## Run tests
To run the unit tests, simply execute the Maven command: 
```
mvn test
```

## Generate Test Coverage report
To run the tests and generate the test coverage report, execute the Maven command:
```
mvn test jacoco:report
```
