package cc.example.rookie

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import springfox.documentation.oas.annotations.EnableOpenApi

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["cc.example.rookie.repository"])
@EntityScan(basePackages = ["cc.example.rookie.entity"])
class RookieApplication{
	companion object{

		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<RookieApplication>(*args)
		}
		
	}

	
}

