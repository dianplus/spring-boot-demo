package cn.dianplus.autoconfigure.metrics;

import cn.dianplus.Application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.mweirauch.micrometer.jvm.extras.ProcessMemoryMetrics;
import io.github.mweirauch.micrometer.jvm.extras.ProcessThreadMetrics;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;

@Configuration
@AutoConfigureBefore(Application.class)
public class ExtraMetricsAutoConfiguration {

	// Add an extra tag 'application'
    @Bean
    public MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${info.app.artifactId}") String applicationName) {
        return (registry) -> registry.config().commonTags("application", applicationName);
    }

	@Bean
	public MeterBinder processMemoryMetrics() {
		return new ProcessMemoryMetrics();
	}

	@Bean
	public MeterBinder processThreadMetrics() {
		return new ProcessThreadMetrics();
	}
}
