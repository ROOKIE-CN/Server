package cc.example.rookie.filter

import java.io.BufferedReader
import java.io.IOException
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest


class TestFilter : Filter {

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain) {
        chain.doFilter(request,response)

    }

    private fun getPostData(request: HttpServletRequest): String? {
        val data = StringBuffer()
        var line: String?
        var reader: BufferedReader?
        try {
            reader = request.reader
            while (null != reader.readLine().also { line = it }) data.append(line)
        } catch (e: IOException) {
        } finally {
        }
        return data.toString()
    }
}