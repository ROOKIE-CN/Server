package cc.example.rookie.controller.test

import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("test")
@Api(tags = ["Test | 测试接口"])
class TestController {
    
    @GetMapping("index")
    fun index() : String {
        return "test controller index"
    }
    
}