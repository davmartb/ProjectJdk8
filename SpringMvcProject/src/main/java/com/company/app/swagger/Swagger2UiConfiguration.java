/**
 * 
 */
package com.company.app.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.company.app.web.controller.CustomerRestController;

/**
 * @author david
 *
 */
//@Configuration
//@EnableSwagger2
//@ComponentScan(basePackageClasses = { CustomerRestController.class })
public class Swagger2UiConfiguration{

	 /**
     * Documentation.
     *
     * @return the docket
     */
    @Bean
    public static Docket documentation()
    {
        final Docket d = new Docket(DocumentationType.SWAGGER_2).apiInfo(metadata());
        d.pathMapping("");
        // .select()
        // .apis(RequestHandlerSelectors.any())
        // .paths(PathSelectors.regex("/rest/*"))
        // .build()
        // .pathMapping("/rest/")
        // .apiInfo(metadata());
        return d;
    }

    /**
     * Metadata.
     *
     * @return the api info
     */
    private static ApiInfo metadata()
    {
        return new ApiInfoBuilder().title("Save Cart API").description("API que gestiona el carrito de la compra de los usuarios").version("1.0.0").build();
    }
	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry)
//
//	{
//
//		// enabling swagger-ui part for visual documentation
//
//		registry.addResourceHandler("swagger-ui.html").addResourceLocations(
//				"classpath:/META-INF/resources/");
//
//		registry.addResourceHandler("/webjars/**").addResourceLocations(
//				"classpath:/META-INF/resources/webjars/");
//
//	}
}
