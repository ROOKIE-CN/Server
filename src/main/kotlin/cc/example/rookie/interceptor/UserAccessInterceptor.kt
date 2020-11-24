package cc.example.rookie.interceptor

import cc.example.rookie.annotation.UserAccess
import cc.example.rookie.common.Result
import cc.example.rookie.common.ResultData
import cc.example.rookie.common.ResultEnum
import cc.example.rookie.entity.User
import cc.example.rookie.service.UserService
import cc.example.rookie.util.HttpUtils
import cc.example.rookie.util.JwtUtil
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import java.lang.reflect.Method
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class UserAccessInterceptor : HandlerInterceptor {

    companion object {
        val localUser : ThreadLocal<User> = ThreadLocal()
    }

    @Resource
    lateinit var userService : UserService


    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {

        if (handler is HandlerMethod){
            val annotationPresent = handler.hasMethodAnnotation(UserAccess::class.javaObjectType)
            if (annotationPresent) {
                val userAccess = handler.getMethodAnnotation(UserAccess::class.java)!!

                val token = request.getHeader("token")

                if (token != null){

                    val claims = JwtUtil.check(token)
                    val account = claims["account"]
                    val password = claims["password"]
                    val optl = userService.login(account.toString(), password.toString())
                    if (optl == null){
                        HttpUtils.returnResult(response,Result(ResultEnum.TOKEN_PERMISSION_NO_ENOUGH))
                        return false
                    }else {
                        if (userAccess.isAdmin && !optl.admin){
                            HttpUtils.returnResult(response,Result(ResultEnum.TOKEN_PERMISSION_NO_ENOUGH,"错误的token令牌"))
                            return false
                        }
                        localUser.set(optl)
                    }
                } else {
                    HttpUtils.returnResult(response,Result(ResultEnum.TOKEN_NOT_FOUND,"未找到 token 字符串"))
                    return false
                }
            }
        }

        return true
    }



}