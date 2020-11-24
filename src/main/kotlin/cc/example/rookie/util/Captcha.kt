package cc.example.rookie.util

import cc.example.rookie.common.Result
import cc.example.rookie.common.ResultEnum
import java.util.*
import kotlin.collections.HashMap

class Captcha {



    companion object{

        const val timeout = 60 * 2 * 1000
        val map : HashMap<String,UserCaptcha> = HashMap()


        fun sendCaptcha(account : String) : Result{
            if (inspect(account)){
                return ResultEnum.CAPTCHA_NOT_REPEAT_CODE.install().addData("captcha",queryCaptcha(account)!!)
            }
            val createCaptcha = createCaptcha()
            map[account] = createCaptcha
            return ResultEnum.SUCCESS.install().addData("captcha", createCaptcha)
        }

        fun createCaptcha() : UserCaptcha = UserCaptcha(randomCode())

        fun randomCode() : Long {
            return ((100001..999999).random()).toLong()
        }

        fun queryCaptcha(account : String) : UserCaptcha? {
            return map[account]
        }

        fun inspect(account : String) : Boolean {
            if (map.keys.contains(account)) {
                val captcha = queryCaptcha(account)!!
                //如果已超时
                if ((captcha.date!!.time + timeout > System.currentTimeMillis())) {
                    return true
                }
            }
            return false
        }
    }

    class UserCaptcha(val code : Long , val date : Date? = Date()){
        override fun toString(): String {
            return "UserCaptcha(code=$code, date=$date)"
        }


    }

}