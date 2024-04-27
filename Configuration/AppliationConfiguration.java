package Book_Library_Application.Configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
@EnableSwagger2
public class AppliationConfiguration {

	@Bean
	public Docket getDocket() {
		Contact contact = new Contact("Cult-Fit", "www.BookLibrary.com", "Booksatyou@email.com");
		List<VendorExtension> vendorExtension = new ArrayList<>();

		ApiInfo apiInfo = new ApiInfo("Books", "Book Library application for offline", "1.01", "www.BooksLibrary.com", contact,
				"start with 6 months free membership", "www.BookLibrary.com", vendorExtension);
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("Book_Library_Application")).build()
				.apiInfo(apiInfo).useDefaultResponseMessages(false);
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
		
	}
}