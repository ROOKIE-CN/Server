package cc.example.rookie.config

import io.swagger.annotations.ApiOperation
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.oas.annotations.EnableOpenApi
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket


@Configuration
@EnableOpenApi
class Swagger3Config {

    @Bean
    fun createRestAPI() : Docket{
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation::class.java))
                .paths(PathSelectors.any())
                .build()
    }

    @Bean
    fun apiInfo() : ApiInfo {
        return ApiInfoBuilder()
                .title("ROOKIE & RABBIT team project admin module.")
                .description("后台数据管理")
                .version("1.0.0-Beta")
                .build()
    }

}