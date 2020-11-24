package cc.example.rookie.service

import cc.example.rookie.common.Result
import cc.example.rookie.entity.Parameter
import cc.example.rookie.entity.ParameterOption
import java.util.*

interface ParameterService {

    fun findAll() : List<Parameter>

    fun save(parameter: Parameter) : Parameter

    fun save(title : String): Parameter

    fun findById(id : Int) : Optional<Parameter>

    fun existsById(id : Int) : Boolean

    fun addOption(parentId : Int,content : String) : Result

    fun addOption(parameterOption: ParameterOption) : Result

    fun findOptionByParentId(id : Int) : List<ParameterOption>


}