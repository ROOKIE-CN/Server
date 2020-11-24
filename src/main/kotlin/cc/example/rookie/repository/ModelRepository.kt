package cc.example.rookie.repository

import cc.example.rookie.entity.Model
import org.apache.ibatis.annotations.Select
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ModelRepository : JpaRepository<Model,Int> {

    @Query("select m from Model m where m.brand=?1 and m.modelName like %?2%")
    fun findByClassifyAndBrandAndModelName(brandId : Int,modelName : String?, pageable: Pageable? = null) : List<Model>

    @Query("select m from Model m where m.brand=?1")
    fun findByClassifyAndBrandAndModelName(brandId : Int, pageable: Pageable? = null) : List<Model>

    @Query("select m from Model m where m.brand=?1 and m.modelName like %?2%")
    fun findByClassifyAndBrandAndModelName(brandId : Int,modelName : String?) : List<Model>

    @Query("select m from Model m where m.brand=?1")
    fun findByClassifyAndBrandAndModelName(brandId : Int) : List<Model>


    @Query("select m from Model m where m.brand=?1")
    fun findAllByBrand(brand: Int) : List<Model>
}