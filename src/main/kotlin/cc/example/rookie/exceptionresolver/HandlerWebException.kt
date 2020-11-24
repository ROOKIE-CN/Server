package cc.example.rookie.exceptionresolver

import cc.example.rookie.common.Result
import cc.example.rookie.common.ResultEnum
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class HandlerWebException {

    @ExceptionHandler
    @ResponseBody
    fun handed500Exception(request: HttpServletRequest, exception: Exception): Result {
        if (exception is IllegalArgumentException || exception is NumberFormatException || exception is MethodArgumentTypeMismatchException) {
            return ResultEnum.FAIL.install("接口参数传输异常. error=${exception.message}")
        } else if (exception is HttpRequestMethodNotSupportedException) {
            return ResultEnum.FAIL.install("请求类型错误,不应该是 ${request.method}")
        } else if (exception is IllegalStateException) {
          return ResultEnum.FAIL.install("无效的参数值,${exception.message}")
        } else {
            exception.printStackTrace()
        }
        return ResultEnum.AIR.install()
    }

}