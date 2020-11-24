package cc.example.rookie.service

import cc.example.rookie.common.Result
import cc.example.rookie.entity.User
import org.springframework.stereotype.Service
import java.util.*

interface UserService {


    /**
     * 登录
     * 账户名称规定11长度
     */
    fun login(account: String, password: String): User?

    fun login(account: String) : Optional<User>

    fun register(account : String) : Result

    fun register(account : String,password: String) : Result

    fun register(user: User) : Result

    fun register(account : String,password: String,captcha : Long) : Result

    fun findByAccount(account: String) : Optional<User>

    fun existsByAccount(account : String) : Boolean

    fun findById(id: Int) : Optional<User>

    fun update(user: User)

    fun toggleAdmin(user : User)

}