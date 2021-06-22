package codeanalyzer;

import codeanalyzer.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import org.junit.Assert;

public class SourceCodeAnalyzerFactoryTest {
    private final static String type_regex = "regex";
    private final static String type_strcomp = "strcomp";
    private final static String local = "local";
    private final static String web = "web";
    private final static String location = "fake-location";
    private final static String analyzer_type = "fake-type";
    private SourceCodeAnalyzerFactory scaFactory = new SourceCodeAnalyzerFactory();

    @Rule
	public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testRegexCreateSourceCodeAnalyzerLocationException() {
        thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Unknown file location : fake-location");
        scaFactory.createSourceCodeAnalyzer(type_regex, location);
    }
    
    @Test
    public void testStrCompCreateSourceCodeAnalyzerLocationException() {
        thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Unknown file location : fake-location");
        scaFactory.createSourceCodeAnalyzer(type_strcomp, location);
    }
    
    @Test
    public void testCreateSourceCodeAnalyzerTypeException() {
        thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Unknown analyzer type : fake-type");
        scaFactory.createSourceCodeAnalyzer(analyzer_type, local);
    }
    
    @Test
    public void testCreateSourceCodeAnalyzerRegexLocal() {
    	SourceCodeAnalyzer sca = scaFactory.createSourceCodeAnalyzer(type_regex, local);
    	Assert.assertTrue(sca instanceof RegexAnalyzer);
    }
    
    @Test
    public void testCreateSourceCodeAnalyzerStrCompLocal() {
    	SourceCodeAnalyzer sca = scaFactory.createSourceCodeAnalyzer(type_strcomp, local);
    	Assert.assertTrue(sca instanceof StrCompAnalyzer);
    }
    
    @Test
    public void testCreateSourceCodeAnalyzerRegexWeb() {
    	SourceCodeAnalyzer sca = scaFactory.createSourceCodeAnalyzer(type_regex, web);
    	Assert.assertTrue(sca instanceof RegexAnalyzer);
    }
    
    @Test
    public void testCreateSourceCodeAnalyzerStrCompWeb() {
    	SourceCodeAnalyzer sca = scaFactory.createSourceCodeAnalyzer(type_strcomp, web);
    	Assert.assertTrue(sca instanceof StrCompAnalyzer);
    }
}