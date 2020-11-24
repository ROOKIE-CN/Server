package cc.example.rookie.common

enum class ResultEnum(var message: String, var code: Int) {

    DATA_NULL("数据不存在",-2),
    AIR("未知的操作",-1),
    FAIL("操作失败",0),
    SUCCESS("操作成功",1),
    TOKEN_NOT_FOUND("用户未登录或已失效的 user_token",900),
    TOKEN_PERMISSION_NO_ENOUGH("用户权限不足",901),


    USER_REGISTER_ACCOUNT_INVALID("无效的手机号",101),
    USER_REGISTER_ACCOUNT_REGISTERED("该账号已注册",102),
    USER_REGISTER_ACCOUNT_NOT_REGISTERED("该账号未注册",103),
    CAPTCHA_NOT_REPEAT_CODE("请勿重复发送",120),
    CAPTCHA_INVALID("无效的验证码",121);

    fun install(msg : String? = "") : Result {
        return Result(this,msg)
    }



}