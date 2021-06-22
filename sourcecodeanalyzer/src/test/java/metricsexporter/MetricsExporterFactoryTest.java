package metricsexporter;

import codeanalyzer.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import org.junit.Assert;

public class MetricsExporterFactoryTest {
    private final static String output_type = "fake-type";
    private final static String csv_type = "csv";
    private final static String json_type = "json";
    private MetricsExporterFactory meFactory = new MetricsExporterFactory();

    @Rule
	public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCreateMetricsExporterTypeException() {
        thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Unknown type : fake-type");
        meFactory.createMetricsExporter(output_type);
    }
    
    @Test
    public void testCreateMetricsExporterCsv() {
    	MetricsExporter mExporter = meFactory.createMetricsExporter(csv_type);
    	Assert.assertTrue(mExporter instanceof CsvExporter);
    }
    
    @Test
    public void testCreateMetricsExporterJson() {
    	MetricsExporter mExporter = meFactory.createMetricsExporter(json_type);
    	Assert.assertTrue(mExporter instanceof JsonExporter);
    }
}