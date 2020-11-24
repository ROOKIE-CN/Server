package cc.example.rookie.service

import cc.example.rookie.entity.Model
import org.springframework.data.domain.Pageable

interface ModelService {

    fun findByClassifyAndBrandAndModelName(brandId : Int,modelName : String?, page : Int?,size : Int?) : List<Model>

    fun findById(id : Int) : Model

    fun save(model: Model)

    fun findAllByBrandId(brandId: Int) : List<Model>

    fun findAll() : List<Model>

}