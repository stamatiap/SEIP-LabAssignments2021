package demo;

import metricsexporter.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import codeanalyzer.SourceCodeAnalyzer;
import codeanalyzer.SourceCodeAnalyzerFactory;

public class DemoClient {
    public static void main(String[] args) throws IOException {
		String filepath = "src/main/resources/TestClass.java";
		String sourceCodeAnalyzerType = "regex";
		String sourceFileLocation = "local";
		String outputFilePath = "output_metrics";
		String outputFileType = "csv";
		
		if(args.length == 5) {
			filepath = args[0];
			sourceCodeAnalyzerType = args[1];
			sourceFileLocation = args[2];
			outputFilePath = args[3];
			outputFileType = args[4];
		} else if (args.length != 0) {
			System.out.println("Incorrect number of arguments.");
			System.exit(1);
		}

        SourceCodeAnalyzerFactory anFactory = new SourceCodeAnalyzerFactory();
        SourceCodeAnalyzer codeAnalyzer = anFactory.createSourceCodeAnalyzer(sourceCodeAnalyzerType, sourceFileLocation);
        int loc = codeAnalyzer.calculateLOC(filepath);
        int nom = codeAnalyzer.calculateNOM(filepath);
        int noc = codeAnalyzer.calculateNOC(filepath);

        Map<String, Integer> metrics = new HashMap<>();
        metrics.put("loc",loc);
		metrics.put("nom",nom);
		metrics.put("noc",noc);
        
        MetricsExporterFactory mexpFactory = new MetricsExporterFactory();
        MetricsExporter metricsExporter = mexpFactory.createMetricsExporter(outputFileType);
        metricsExporter.writeFile(metrics, outputFilePath);
    }
}
