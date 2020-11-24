package cc.example.rookie.controller.index

import cc.example.rookie.annotation.UserAccess
import cc.example.rookie.common.Result
import cc.example.rookie.common.ResultEnum
import cc.example.rookie.entity.Brand
import cc.example.rookie.entity.Classify
import cc.example.rookie.interceptor.UserAccessInterceptor
import cc.example.rookie.service.BrandService
import cc.example.rookie.service.ClassifyService
import cc.example.rookie.service.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.annotation.Resource

@RestController
@RequestMapping("/api/brand")
@Api(tags = ["Brand | 品牌数据接口"])
class BrandController {

    @Resource
    lateinit var brandService : BrandService

    @Resource
    lateinit var classifyService: ClassifyService

    @GetMapping("findAll")
    @ApiOperation(notes = "获取品牌",value = "获取品牌")
    fun findAll(@ApiParam(value = "类型id -1胃不指定，默认-1")classifyId : Int? = -1) : Result {

        return if (classifyId != null){
            ResultEnum.SUCCESS.install().addData("list",brandService.findAllByClassifyId(classifyId!!))
        } else {
            ResultEnum.SUCCESS.install().addData("list", brandService.findAll())
        }
    }

    @PostMapping("create")
    @UserAccess
    @ApiOperation(notes = "新增品牌 需要token",value = "新增品牌")
    fun create(@ApiParam("类型Id")classifyId : Int,@ApiParam("品牌名称")brandName : String,
               @ApiParam("logo")logo : String,@ApiParam("说明")description : String) : Result {
        return if (classifyService.existsById(classifyId)){
            val brand = Brand(brandName, logo, classifyId, description, false, UserAccessInterceptor.localUser.get().id, false)
            brandService.save(brand)
            return ResultEnum.SUCCESS.install();
        }else{
            ResultEnum.FAIL.install("类型不存在")
        }
    }

}