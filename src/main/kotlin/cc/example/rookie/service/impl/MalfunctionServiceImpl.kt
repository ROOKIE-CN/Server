package cc.example.rookie.service.impl

import cc.example.rookie.common.Result
import cc.example.rookie.common.ResultEnum
import cc.example.rookie.entity.Malfunction
import cc.example.rookie.repository.MalfunctionRepository
import cc.example.rookie.service.MalfunctionService
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.Resource

@Service
class MalfunctionServiceImpl : MalfunctionService {

    @Resource
    lateinit var malfunctionRepository: MalfunctionRepository

    override fun findAll(): List<Malfunction> = malfunctionRepository.findAll()

    override fun save(malfunction: Malfunction): Malfunction = malfunctionRepository.save(malfunction)

    override fun save(content: String,eval : Double): Result {
        save(Malfunction(content,eval))
        return ResultEnum.SUCCESS.install()
    }

    override fun findById(id: Int): Optional<Malfunction> = malfunctionRepository.findById(id)

    override fun existsById(id: Int) : Boolean = malfunctionRepository.existsById(id)



}