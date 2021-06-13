# Source Code Analyzer
This project was created in order to get familiar with design principles by refactoring code and applying design patterns on a given code base.
Functionality: reads a Java source code file that is stored locally or on the web, calculates the Lines of Code (LOC), Number of Classes (NOC) and Number of Methods (NOM) metrics, and finally, exports these metrics to an output file.

## Tools used for testing
- [JUnit 4](https://junit.org/junit4/)
- [Mockito](https://site.mockito.org/)

## Design Patterns applied
- Strategy - this pattern was used in these classes:
	- SourceFileReader: used in order to separate and isolate SourceFileReader's functions into separate classes for each File Reader (LocalFileReader and WebFileReader)
	interface : SourceFileReader
	strategies : LocalFileReader, WebFileReader

	- MetricsExporter: used in order to separate and isolate MetricsExporter's functions into separate classes for each Metric Exporter (CsvExporter and JsonExporter)
	interface : MetricsExporter
	strategies : CsvExporter, JsonExporter

	Trade-offs of this pattern:
	- Open/Closed Principle - We can introduce new strategies without having to change the context
	- Easier extensibility

- Factory - this pattern was used on the Strategy pattern in these classes:
	- SourceCodeAnalyzer: used in order to create SourceCodeAnalyzer Objects in the Client, without being tightly coupled with the class
	factory: SourceCodeAnalyzerFactory

	- MetricsExporter: used in order to create MetricsExporter Objects in the Client, without being tightly coupled with the class
	factory: MetricsExporterFactory

	Trade-offs of this pattern:
	- Flexibility: We can extend SourceCodeAnalyzer or MetricsExporter without affecting the Client

- Bridge - this pattern was used in the classes:
	- SourceCodeAnalyzer and SourceFileReader: used in order to better control the dimensions of the SourceCodeAnalyzer Objects
	Abstraction: SourceCodeAnalyzer
	Implementation: SourceFileReader

	Trade-offs of this pattern:
	- Single Responsibility Principle

## Build and run
You can build and execute the system in your local repository with the following commands:
```
mvn install
java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4
```
where,  
arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)  
arg1 = “sourceCodeAnalyzerType” [regex|strcomp]  
arg2 = “SourceCodeLocationType” [local|web]  
arg3 = “OutputFilePath” (e.g., ../output_metrics_file)  
arg4 = “OutputFileType” [csv|json]  

