package cc.example.rookie.config

import cc.example.rookie.interceptor.UserAccessInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration

class InterceptorConfigurer : WebMvcConfigurer {


    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(UserAccessInterceptor())
                .addPathPatterns("/**")
    }


}