package cc.example.rookie.controller.index

import cc.example.rookie.annotation.UserAccess
import cc.example.rookie.common.Result
import cc.example.rookie.common.ResultEnum
import cc.example.rookie.service.UserService
import cc.example.rookie.util.Captcha
import cc.example.rookie.util.JwtUtil
import cc.example.rookie.util.Utils
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@RestController
@RequestMapping("api/user")
@Api(tags = ["User | 用户操作接口"])
class UserController {

    @Resource
    lateinit var userService: UserService

    @PostMapping("login")
    @ApiOperation(notes = "用于用户的登录,服务器将会返回一个 user_token 识别码", value = "用户登录")
    fun login(@ApiParam(value = "账户&手机号") account: String, @ApiParam(value = "验证码") captcha: Long? = -1): Result =
            if (!Utils.verificationAccount(account)) ResultEnum.USER_REGISTER_ACCOUNT_INVALID.install()
            else if (!userService.existsByAccount(account)) ResultEnum.USER_REGISTER_ACCOUNT_NOT_REGISTERED.install()
            else {
                val userCaptcha = Captcha.queryCaptcha(account)
                if (userCaptcha != null && userCaptcha.code == captcha) {
                    ResultEnum.SUCCESS.install().addData("token", JwtUtil.generator(userService.login(account).get())!!)
                } else {
                    ResultEnum.CAPTCHA_INVALID.install()
                }
            }

    @GetMapping("sendCaptcha")
    @ApiOperation(notes = "发送验证码，后台将会模拟一条数据返回给客户端", value = "模拟手机验证码发送")
    fun sendCaptcha(@ApiParam(value = "手机号")account: String): Result = if (Utils.verificationAccount(account)){
        Captcha.sendCaptcha(account)
    }else {
        ResultEnum.USER_REGISTER_ACCOUNT_INVALID.install()
    }

    @PostMapping("register")
    @ApiOperation(notes = "用于用户的注册，服务器将会返回一个 user_token 识别码", value = "用户注册")
    fun register(@ApiParam(value = "账户&手机号") account: String,
                 @ApiParam(value = "验证码") captcha: Long?,
                 @ApiParam(value = "密码 (选填 默认同步手机号)") password : String?): Result {
        return userService.register(account,password?:account,captcha?: -1)
    }

    @GetMapping("/regAdmin")
    @UserAccess(true)
    @ApiOperation(notes = "将用户设置为管理员 需要管理员权限",value = "设置为管理员")
    fun regAdmin(@ApiParam("用户id")id : Int) : Result{
        return toggleAdmin(id,true);
    }

    @GetMapping("/unRegAdmin")
    @UserAccess(true)
    @ApiOperation(notes = "取消用户的管理员权限 需要管理员权限",value = "取消管理员")
    fun unRegAdmin(@ApiParam("用户id")id : Int) : Result{
        return toggleAdmin(id,false);
    }




    private fun toggleAdmin(id : Int,bool : Boolean) : Result{
        val optional = userService.findById(id);

        if (optional.isPresent){
            val user = optional.get()

            if (user.admin != bool){
                user.admin = bool
            }
            userService.update(user);
            return ResultEnum.SUCCESS.install();
        }else{
            return ResultEnum.DATA_NULL.install("用户不存在");
        }
    }




    @GetMapping("test")
    @UserAccess(true)
    @ApiOperation(notes = "测试Token握手登录", value = "Token test")
    fun test(): Result {
        return Result(ResultEnum.SUCCESS, "token_method")
    }

}