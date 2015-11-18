package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
@PropertySource("classpath:config.properties")
public class SwaggerConfig {
    @Bean
    public Docket swagger2(final ApiInfo apiInfo) {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build();
    }

    @Bean
    public ApiInfo apiInfo(@Value("${info.build.name:Default title}")
                           final String title,
                           @Value("${info.build.description:Default description.}")
                           final String description,
                           @Value("${info.build.termsOfServiceUrl:}")
                           final String termsOfServiceUrl,
                           @Value("${info.build.contact:}")
                           final String contact,
                           @Value("${info.build.license:}")
                           final String license,
                           @Value("${info.build.licenseUrl:}")
                           final String licenseUrl,
                           @Value("${info.build.apiVersion:}")
                           final String apiVersion) {
        return new ApiInfoBuilder()
            .title(title)
            .description(description)
            .termsOfServiceUrl(termsOfServiceUrl)
            .contact(contact)
            .license(license)
            .licenseUrl(licenseUrl)
            .version(apiVersion)
            .build();
    }
}
