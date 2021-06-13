package codeanalyzer;

import codeanalyzer.SourceCodeAnalyzer;

public class SourceCodeAnalyzerFactory {
    
    public SourceCodeAnalyzer createSourceCodeAnalyzer(String sourceCodeAnalyzerType, String sourceFileLocation) {
        SourceCodeAnalyzer analyzer;
        if (sourceCodeAnalyzerType.equals("regex")) {
            
            if (sourceFileLocation.equals("local")) {
                analyzer = new RegexAnalyzer(new LocalFileReader());
            } else if (sourceFileLocation.equals("web")) {
                analyzer = new RegexAnalyzer(new WebFileReader());
            } else {
                throw new IllegalArgumentException("Unknown file location : " + sourceFileLocation);
            }

        } else if (sourceCodeAnalyzerType.equals("strcomp")) {
            
            if (sourceFileLocation.equals("local")) {
                analyzer = new StrCompAnalyzer(new LocalFileReader());
            } else if (sourceFileLocation.equals("web")) {
                analyzer = new StrCompAnalyzer(new WebFileReader());
            } else {
                throw new IllegalArgumentException("Unknown file location : " + sourceFileLocation);
            }
            
        } else {
            throw new IllegalArgumentException("Unknown analyzer type : " + sourceCodeAnalyzerType);
        }
        return analyzer;
    }
}
