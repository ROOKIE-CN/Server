package cc.example.rookie.service.impl

import cc.example.rookie.entity.Model
import cc.example.rookie.repository.ModelRepository
import cc.example.rookie.service.ModelService
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class ModelServiceImpl : ModelService {

    @Resource
    lateinit var modelRepository: ModelRepository

    override fun findByClassifyAndBrandAndModelName(brandId: Int, modelName: String?, page: Int?, size: Int?): List<Model> {

        var pageRequest : PageRequest? = null

        if (page != null) {
            pageRequest = PageRequest.of(page - 1, size ?: 20)
        }
        return if (modelName == null || modelName == "*")
            if (pageRequest == null)  modelRepository.findByClassifyAndBrandAndModelName(brandId)
            else modelRepository.findByClassifyAndBrandAndModelName(brandId, pageRequest)
        else
            if (pageRequest == null) modelRepository.findByClassifyAndBrandAndModelName(brandId, modelName)
            else modelRepository.findByClassifyAndBrandAndModelName(brandId, modelName, pageRequest)

    }


    override fun findById(id: Int): Model {
        return modelRepository.findById(id).get()
    }

    override fun save(model: Model) {
        modelRepository.save(model)
    }

    override fun findAllByBrandId(brandId: Int): List<Model> = modelRepository.findAllByBrand(brandId)

    override fun findAll(): List<Model> = modelRepository.findAll()


}