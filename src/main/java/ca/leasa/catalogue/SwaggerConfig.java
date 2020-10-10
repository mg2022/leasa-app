package ca.leasa.catalogue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(regex("/*/*.*")).build();
			
		/*
		return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Settings")
                .select()
                .apis(RequestHandlerSelectors.basePackage("ca.leasa"))
                .paths(regex("/*"))
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Settings API").build());
                //.globalOperationParameters(operationParameters());
                 */
	}

	private Predicate<String> postPaths() {
		return or(regex("/*/*.*"), regex("/*/*.*"));
		//return or(regex("/api/*"), regex("/*"));
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("JavaInUse API")
				.description("JavaInUse API reference for developers")
				.termsOfServiceUrl("http://javainuse.com")
				.licenseUrl("javainuse@gmail.com").version("1.0").build();
	}

}