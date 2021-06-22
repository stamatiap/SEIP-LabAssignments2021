package demo;

import codeanalyzer.*;
import metricsexporter.*;
import java.io.IOException;
import java.io.File;
import org.junit.Test;
import org.junit.Rule;
import org.junit.Assert;

public class DemoClientTest {
	private final static String filepath = "src/test/resources/TestClass.java";
	private final static String type_regex = "regex";
    private final static String type_strcomp = "strcomp";
    private final static String local = "local";
    private final static String web = "web";
    private final static String output_file_path = "src/test/resources/output_metrics";
    private final static String csv_type = "csv";
    private final static String json_type = "json";
	DemoClient dc = new DemoClient();
	
	
	@Test
	public void testMain() throws IOException {
		dc.main(new String[] {filepath, type_regex, local, output_file_path, csv_type});
		
		File outputFile = new File(output_file_path + ".csv");
		Assert.assertTrue(outputFile.exists());
		outputFile.delete();
	}
}