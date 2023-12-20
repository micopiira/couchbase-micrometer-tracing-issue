package io.github.micopiira.couchbasemicrometertracingissue;

import com.couchbase.client.java.env.ClusterEnvironment;
import com.couchbase.client.tracing.observation.ObservationRequestTracer;
import io.micrometer.observation.ObservationRegistry;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.couchbase.ClusterEnvironmentBuilderCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CouchbaseMicrometerTracingIssueApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouchbaseMicrometerTracingIssueApplication.class, args);
	}

	@Bean
	public OtlpGrpcSpanExporter otlpHttpSpanExporter(@Value("${tracing.url}") String url) {
		return OtlpGrpcSpanExporter.builder().setEndpoint(url).build();
	}

	@Bean
	ClusterEnvironmentBuilderCustomizer clusterEnvironmentBuilderCustomizer(ObservationRegistry observationRegistry) {
		return builder -> builder.requestTracer(ObservationRequestTracer.wrap(observationRegistry));
	}

}
