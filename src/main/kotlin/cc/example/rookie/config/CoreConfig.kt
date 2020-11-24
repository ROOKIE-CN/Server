package cc.example.rookie.config

import cc.example.rookie.entity.Brand
import cc.example.rookie.entity.Classify
import cc.example.rookie.entity.Model
import cc.example.rookie.filter.TestFilter
import com.fasterxml.jackson.databind.module.SimpleModule
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import javax.servlet.FilterRegistration

@Configuration
@EnableWebMvc
class CoreConfig : WebMvcConfigurer {

    override fun addCorsMappings(corsRegistry: CorsRegistry) {
        corsRegistry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("*")
                .maxAge(3600)
    }

}