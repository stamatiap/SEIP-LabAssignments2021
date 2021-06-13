package metricsexporter;

public class MetricsExporterFactory {
    
    public MetricsExporter createMetricsExporter(String outputType) {
        MetricsExporter exporter;
        if (outputType.equals("csv")) {
            exporter = new CsvExporter();
        } else if (outputType.equals("json")) {
            exporter = new JsonExporter();
        } else {
            throw new IllegalArgumentException("Unknown type : " + outputType);
        }
        return exporter;
    }
}