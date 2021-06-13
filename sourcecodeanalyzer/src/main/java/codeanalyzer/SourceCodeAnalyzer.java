package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class SourceCodeAnalyzer {
    protected SourceFileReader fileType;

    public SourceCodeAnalyzer(SourceFileReader _fileType) {
        this.fileType = _fileType;
    }

    public abstract int calculateLOC(String filepath) throws IOException;
    public abstract int calculateNOM(String filepath) throws IOException;
    public abstract int calculateNOC(String filepath) throws IOException;
}

class RegexAnalyzer extends SourceCodeAnalyzer {
    public RegexAnalyzer(SourceFileReader _fileType) {
        super(_fileType);
    }

    @Override
    public int calculateLOC(String filepath) throws IOException {
    	String sourceCode = this.fileType.readFileIntoString(filepath);
        Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
	    Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);

	    int nonCodeLinesCounter = 0;
        while (nonCodeLinesMatcher.find()) {
	    	nonCodeLinesCounter++;
        }
			
	    int sourceFileLength = sourceCode.split("\n").length;
        int loc =  sourceFileLength - nonCodeLinesCounter;
	        
		return loc;
    }

    @Override
    public int calculateNOM(String filepath) throws IOException {
    	String sourceCode = this.fileType.readFileIntoString(filepath);
        Pattern pattern = Pattern.compile(".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*"); 
	    Matcher methodSignatures = pattern.matcher(sourceCode);

	    int methodCounter = 0;
        while (methodSignatures.find()) {
	    	methodCounter++;
        }
		return methodCounter;
    }

    @Override
    public int calculateNOC(String filepath) throws IOException {
    	String sourceCode = this.fileType.readFileIntoString(filepath);
        Pattern pattern = Pattern.compile(".*\\s*class\\s+.*"); 
	    Matcher classSignatures = pattern.matcher(sourceCode);

	    int classCounter = 0;
	    while (classSignatures.find()) {
        	classCounter++;
	    }
		return classCounter;
    }
}

class StrCompAnalyzer extends SourceCodeAnalyzer {
    public StrCompAnalyzer(SourceFileReader _fileType) {
        super(_fileType);
    }

    @Override
    public int calculateLOC(String filepath) throws IOException {
    	List<String> sourceCodeList = this.fileType.readFileIntoList(filepath);
        int nonCodeLinesCounter = 0;
		for (String line : sourceCodeList) {
			line = line.stripLeading().stripTrailing(); //clear all leading and trailing white spaces
			if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}") || line.equals(""))
				nonCodeLinesCounter++;
		}
		int loc = sourceCodeList.size() - nonCodeLinesCounter;
		return loc;
    }

    @Override
    public int calculateNOM(String filepath) throws IOException {
    	List<String> sourceCodeList = this.fileType.readFileIntoList(filepath);
        int methodCounter = 0;
		for (String line : sourceCodeList) {
			line = line.stripLeading().stripTrailing(); //clear all leading and trailing white spaces
			if ( ((line.contains("public") || line.contains("private") || line.contains("protected"))
					|| line.contains("void") || line.contains("int") || line.contains("String"))
				&& line.contains("(") && line.contains(")") && line.contains("{") )
				methodCounter++;
		}
		return methodCounter;
    }

    @Override
    public int calculateNOC(String filepath) throws IOException {
    	List<String> sourceCodeList = this.fileType.readFileIntoList(filepath);
        int classCounter = 0;
		for (String line : sourceCodeList) {
			line = line.strip(); //remove leading and trailing white spaces
		if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
				classCounter++;
			}
		}
		return classCounter;
    }
}