package cc.example.rookie.common

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel
class Result constructor(enum: ResultEnum, @ApiModelProperty(value = "后端提示")var option: String? = "", @ApiModelProperty("数据结构体")var data : ResultData? = ResultData()) {

    @ApiModelProperty(value = "请求状态码")
    var code = enum.code
    @ApiModelProperty(value = "信息提示")
    var message = enum.message

    override fun toString(): String {
        return "Result(option=$option, data=$data, code=$code, message='$message')"
    }

    fun data(data: ResultData) : Result {
        this.data = data
        return this;
    }

    fun addData(key : String,value : Any) : Result {
        this.data?.push(key,value)
        return this;
    }


}