package cc.example.rookie.service.impl

import cc.example.rookie.entity.Classify
import cc.example.rookie.repository.ClassifyRepository
import cc.example.rookie.service.ClassifyService
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class ClassifyServiceImpl : ClassifyService {

    @Resource
    lateinit var classifyRepository: ClassifyRepository

    override fun findAll(): List<Classify> = classifyRepository.findAll()

    override fun findById(id: Int): Classify {

        return classifyRepository.findById(id).get()
    }

    override fun saveClassify(classify: Classify) :Classify = classifyRepository.save(classify)


    override fun removeClassifyById(id : Int) {
        classifyRepository.deleteById(id)
    }

    override fun existsById(classifyId: Int): Boolean {
        return classifyRepository.existsById(classifyId)
    }
}