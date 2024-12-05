package org.example.api.config;

import com.linecorp.armeria.server.logging.AccessLogWriter;
import com.linecorp.armeria.server.logging.LoggingService;
import com.linecorp.armeria.spring.ArmeriaServerConfigurator;
import org.example.api.StudentController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : wangqijia create at:  2024/12/5  4:30 PM
 */
@Configuration
public class ServerConfiguration {

    @Bean
    public ArmeriaServerConfigurator armeriaServerConfigurator(StudentController service) {
        return builder -> {
            // Log every message which the server receives and responds.
            builder.decorator(LoggingService.newDecorator());

            // Write access log after completing a request.
            builder.accessLogWriter(AccessLogWriter.combined(), false);

            // Add an Armeria annotated HTTP service.
            builder.annotatedService(service);

        };
    }
}
