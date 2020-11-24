package cc.example.rookie.service

import cc.example.rookie.entity.Brand

interface BrandService {

    fun save(brand : Brand) : Brand

    fun findById(id : Int) : Brand?

    fun existsById(id : Int) : Boolean

    fun findAllByClassifyId(classifyId : Int) : List<Brand>

    fun findAll() : List<Brand>
}