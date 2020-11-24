package cc.example.rookie.util

import cc.example.rookie.common.Result
import com.fasterxml.jackson.databind.ObjectMapper
import javax.servlet.http.HttpServletResponse

class HttpUtils {
    companion object{

        private val objectMapper = ObjectMapper()

        fun returnResult(response : HttpServletResponse,result : Result){
            response.characterEncoding = "UTF-8"
            response.contentType = "application/json; charset=utf-8"
            val printWriter = response.writer
            printWriter.print(objectMapper.writeValueAsString(result))
        }

    }

}