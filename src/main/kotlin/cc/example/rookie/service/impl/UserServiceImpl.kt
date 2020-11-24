package cc.example.rookie.service.impl

import cc.example.rookie.common.Result
import cc.example.rookie.common.ResultEnum
import cc.example.rookie.entity.User
import cc.example.rookie.repository.UserRepository
import cc.example.rookie.service.UserService
import cc.example.rookie.util.Captcha
import cc.example.rookie.util.JwtUtil
import cc.example.rookie.util.Utils
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.Resource

@Service("userService")
class UserServiceImpl : UserService {

    @Resource
    lateinit var userRepository: UserRepository

    override fun login(account: String, password: String): User? = try {
        userRepository.login(account, password)
    } catch (e: EmptyResultDataAccessException) {
        null
    }


    override fun login(account: String): Optional<User> {
        return findByAccount(account)
    }


    override fun findByAccount(account: String): Optional<User> {
        return userRepository.findByAccount(account)
    }

    override fun register(account: String): Result {
        return register(account,account)
    }

    override fun existsByAccount(account: String): Boolean = userRepository.findByAccount(account).isPresent

    override fun findById(id: Int): Optional<User> = userRepository.findById(id)

    override fun update(user: User) {
        userRepository.save(user)
    }

    override fun toggleAdmin(user: User) {
        user.admin = !user.admin;
        userRepository.save(user)
    }

    override fun register(account: String, password: String): Result = if (account.length != 11){
        ResultEnum.USER_REGISTER_ACCOUNT_INVALID.install()
    }else {
        if (existsByAccount(account)) {
            ResultEnum.USER_REGISTER_ACCOUNT_REGISTERED.install()
        } else {
            val user = User(account, password)
            register(user)
        }
    }

    override fun register(user: User): Result {
        return JwtUtil.generator(user)?.let { userRepository.save(user).run { ResultEnum.SUCCESS.install() }.addData("token", it) } !!
    }

    override fun register(account: String, password: String, captcha: Long) : Result {
        if (!Utils.verificationAccount(account)) return ResultEnum.USER_REGISTER_ACCOUNT_INVALID.install()
        return if (existsByAccount(account)) {
            ResultEnum.USER_REGISTER_ACCOUNT_REGISTERED.install()
        } else {
            val userCaptcha = Captcha.queryCaptcha(account)
            if (userCaptcha != null && userCaptcha.code == captcha){
                register(account,password)
            } else {
                ResultEnum.CAPTCHA_INVALID.install()
            }
        }
    }
}