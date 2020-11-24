package cc.example.rookie.service

import cc.example.rookie.entity.Classify

interface ClassifyService {

    fun findAll() : List<Classify>

    fun findById(id : Int) : Classify?

    fun saveClassify(classify: Classify):Classify

    fun removeClassifyById(id : Int)

    fun existsById(classifyId: Int): Boolean
}