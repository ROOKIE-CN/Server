package cc.example.rookie.service.impl

import cc.example.rookie.common.Result
import cc.example.rookie.common.ResultEnum
import cc.example.rookie.entity.Parameter
import cc.example.rookie.entity.ParameterOption
import cc.example.rookie.repository.ParameterOptionRepository
import cc.example.rookie.repository.ParameterRepository
import cc.example.rookie.service.ParameterService
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.Resource

@Service
class ParameterServiceImpl : ParameterService {

    @Resource
    lateinit var parameterRepository: ParameterRepository

    @Resource
    lateinit var parameterOptionRepository: ParameterOptionRepository

    override fun findAll(): List<Parameter> = parameterRepository.findAll()

    override fun save(parameter: Parameter): Parameter = parameterRepository.save(parameter)

    override fun save(title: String) : Parameter = save(Parameter(title))

    override fun findById(id: Int): Optional<Parameter> = parameterRepository.findById(id)

    override fun existsById(id: Int): Boolean = parameterRepository.existsById(id)

    override fun addOption(parentId: Int, content: String): Result = addOption(ParameterOption(parentId,content))

    override fun addOption(parameterOption: ParameterOption): Result =
            if (parameterRepository.existsById(parameterOption.parent)){
                parameterOptionRepository.save(parameterOption)
                ResultEnum.SUCCESS.install()
            }else{
                ResultEnum.DATA_NULL.install();
            }

    override fun findOptionByParentId(id: Int): List<ParameterOption> = parameterOptionRepository.findAllByParent(id)
}