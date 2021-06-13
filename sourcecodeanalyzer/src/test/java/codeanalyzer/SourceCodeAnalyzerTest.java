package codeanalyzer;

import codeanalyzer.*;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class SourceCodeAnalyzerTest {
    private final static String web_test_class = "https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
    private final static String local_test_class = "src/test/resources/TestClass.java";
    RegexAnalyzer ral = new RegexAnalyzer(new LocalFileReader());
    StrCompAnalyzer sal = new StrCompAnalyzer(new LocalFileReader());
    RegexAnalyzer raw = new RegexAnalyzer(new WebFileReader());
    StrCompAnalyzer saw = new StrCompAnalyzer(new WebFileReader());

    @Test
    public void testCalculateRegexLOCLocal() throws IOException {
        assertEquals(21, ral.calculateLOC(local_test_class));
    }

    @Test
    public void testCalculateStrCompLOCLocal() throws IOException {
        assertEquals(7, sal.calculateLOC(local_test_class));
    }

    @Test
	public void testCalculateRegexNOMLocal() throws IOException {
		assertEquals(3, ral.calculateNOM(local_test_class));
	}
	
	@Test
	public void testCalculateStrCompNOMLocal() throws IOException {
		assertEquals(3, sal.calculateNOM(local_test_class));
	}
	
	@Test
	public void testCalculateRegexNOCLocal() throws IOException {
		assertEquals(3, ral.calculateNOC(local_test_class));
	}
	
	@Test
	public void testCalculateStrCompNOCLocal() throws IOException {
		assertEquals(3, sal.calculateNOC(local_test_class));
	}

    @Test
    public void testCalculateRegexLOCWeb() throws IOException {
        assertEquals(21, raw.calculateLOC(web_test_class));
    }

    @Test
    public void testCalculateStrCompLOCWeb() throws IOException {
        assertEquals(7, saw.calculateLOC(web_test_class));
    }

    @Test
	public void testCalculateRegexNOMWeb() throws IOException {
		assertEquals(3, raw.calculateNOM(web_test_class));
	}
	
	@Test
	public void testCalculateStrCompNOMWeb() throws IOException {
		assertEquals(3, saw.calculateNOM(web_test_class));
	}
	
	@Test
	public void testCalculateRegexNOCWeb() throws IOException {
		assertEquals(3, raw.calculateNOC(web_test_class));
	}
	
	@Test
	public void testCalculateStrCompNOCWeb() throws IOException {
		assertEquals(3, saw.calculateNOC(web_test_class));
	}
}
