package cc.example.rookie.controller.index

import cc.example.rookie.annotation.UserAccess
import cc.example.rookie.common.Result
import cc.example.rookie.common.ResultEnum
import cc.example.rookie.entity.Brand
import cc.example.rookie.entity.Classify
import cc.example.rookie.interceptor.UserAccessInterceptor
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
@RequestMapping("api/classify")
@Api(tags = ["Classify | 分类信息操作接口"])
class ClassifyController {

    @Resource
    lateinit var classifyService: ClassifyService

    @Resource
    lateinit var userService : UserService

    @GetMapping("/findAll")
    @ApiOperation(notes = "获取全部分类信息",value = "获取分类信息")
    fun findAll() : Result {
        return ResultEnum.SUCCESS.install().addData("list",classifyService.findAll())
    }

    @PostMapping("/create")
    @UserAccess
    @ApiOperation(notes = "新增类型",value = "新增类型")
    fun create(@ApiParam(value = "名称")classifyName : String,@ApiParam(value = "图标")icon : String,
               @ApiParam(value = "大图标")bigIcon : String,@ApiParam(value = "说明")description : String,
               @ApiParam(value = "用户账户")userAccount : String) : Result{
        val user = UserAccessInterceptor.localUser.get()
        val classify = Classify(classifyName, icon, bigIcon, description, true, user.id, user.id, Date(), Date(), false)
        return ResultEnum.SUCCESS.install().addData("obj",classifyService.saveClassify(classify))
    }

//    @PostMapping("update")
//    @UserAccess
//    @ApiOperation(notes = "修改类型",value = "修改类型")
//    fun update(classify: Classify) : Result {
//        classifyService.saveClassify(classify)
//        return ResultEnum.SUCCESS.install()
//    }

    @PostMapping("/remove")
    @ApiOperation(notes = "删除类型",value = "删除类型")
    @UserAccess
    fun remove(id : Int) : Result {
        val classify = classifyService.findById(id)
        if (classify == null){
            return ResultEnum.FAIL.install("无效的分类信息")
        }else{
            classifyService.removeClassifyById(id)
            return ResultEnum.SUCCESS.install()
        }

    }


}