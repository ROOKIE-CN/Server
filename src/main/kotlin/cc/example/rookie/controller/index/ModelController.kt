package cc.example.rookie.controller.index

import cc.example.rookie.annotation.UserAccess
import cc.example.rookie.common.Result
import cc.example.rookie.common.ResultData
import cc.example.rookie.common.ResultEnum
import cc.example.rookie.entity.Brand
import cc.example.rookie.entity.Model
import cc.example.rookie.interceptor.UserAccessInterceptor
import cc.example.rookie.service.*
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource


@RestController
@RequestMapping("api/model")
@Api(tags = ["Model | 型号模型操作接口"])
class ModelController {

    @Resource
    lateinit var modelService: ModelService

    @Resource
    lateinit var brandService: BrandService

    @Resource
    lateinit var parameterService: ParameterService

    @Resource
    lateinit var malfunctionService: MalfunctionService

    @ApiOperation(notes = "获取型号列表", value = "获取型号列表")
    @GetMapping("search")
    fun search(@ApiParam(value = "品牌id") brandId: Int,
               @ApiParam("型号名称") modelName: String?,
               @ApiParam(value = "页码 选填 默认全部") page: Int?,
               @ApiParam(value = "页长 默认20") size: Int?): Result {

        return ResultEnum.SUCCESS.install()
                .addData("list", modelService.findByClassifyAndBrandAndModelName(brandId, modelName ?: "*", page, size))

    }

    @ApiOperation(notes = "获取型号", value = "获取型号")
    @GetMapping("findAll")
    fun findAll(@ApiParam("通过品牌ID查询型号，可选 默认-1 -1为不指定&全部") brandId: Int?): Result {
        return ResultEnum.SUCCESS.install().addData("list", if (brandId != null) modelService.findAllByBrandId(brandId) else modelService.findAll())

    }

    @ApiOperation(notes = "返回商品详情", value = "获取商品详情")
    @GetMapping("detail")
    fun detail(@ApiParam(value = "商品ID") id: Int): Result {
        return ResultEnum.SUCCESS.install().addData("obj", modelService.findById(id))
    }

    @ApiOperation(notes = "新增型号", value = "新增型号")
    @UserAccess(true)
    @PostMapping("create")
    fun create(@ApiParam(value = "品牌ID") brandId: Int, @ApiParam("型号名称") modelName: String,
               @ApiParam("价格") exchangePrice: Double, @ApiParam("最高价格") topPrice: Double,
               @ApiParam("头像") faceImg: String, @ApiParam("内容图片") contentImg: String,
               @ApiParam("介绍") description: String, @ApiParam("创建人账号") userAccount: String): Result {
        val user = UserAccessInterceptor.localUser.get()
        return if (brandService.existsById(brandId)) {
            modelService.save(Model(modelName, brandId, exchangePrice, topPrice, faceImg, contentImg, description, false, user.id))
            ResultEnum.SUCCESS.install()
        } else {
            ResultEnum.FAIL.install("品牌不存在")
        }
    }

    @ApiOperation(notes = "获取参数", value = "获取参数")
    @GetMapping("/parameter/findAll")
    fun findAllIsParameter(): Result = ResultEnum.SUCCESS.install().addData("list", parameterService.findAll())

    @ApiOperation(notes = "获取参数选项", value = "获取参数选项")
    @GetMapping("/parameter/option/findAll")
    fun findAllIsParameterOptions(@ApiParam("参数组ID") parentId: Int): Result = ResultEnum.SUCCESS.install().addData("list", parameterService.findOptionByParentId(parentId))

    @ApiOperation(notes = "删除参数选项", value = "删除参数选项")
    @GetMapping("/parameter/option/delete")
    @UserAccess(true)
    fun deleteIsParameterOption(@ApiParam("参数id") id: Int): Result {
        return ResultEnum.SUCCESS.install()
    }

    @ApiOperation(notes = "新增参数", value = "新增参数")
    @PostMapping("/parameter/insert")
    @UserAccess(true)
    fun insertParameter(title: String): Result {
        parameterService.save(title)
        return ResultEnum.SUCCESS.install()
    }

    @ApiOperation(notes = "新增参数选项", value = "新增参数选项")
    @PostMapping("/parameter/option/insert")
    @UserAccess(true)
    fun insertParameterOption(parentId: Int, content: String): Result = parameterService.addOption(parentId, content)

    @ApiOperation(notes = "获取全部故障", value = "获取全部故障")
    @GetMapping("/malfunction/findAll")
    fun findAllIsMalfunctions(): Result = ResultEnum.SUCCESS.install().addData("list", malfunctionService.findAll())

    @ApiOperation(notes = "新增故障", value = "新增故障")
    @PostMapping("/malfunction/insert")
    @UserAccess(true)
    fun insertMalfunction(@ApiParam("故障信息") content: String, @ApiParam("故障对估价的所占累加比 价格+(价格*比)") eval: Double? = 0.0): Result {
        return if (eval != null) {
            malfunctionService.save(content, eval)
            ResultEnum.SUCCESS.install()
        } else {
            ResultEnum.FAIL.install("eval can not be 0 or null")
        }
    }


}