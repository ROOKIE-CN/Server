package cc.example.rookie.repository

import cc.example.rookie.entity.Brand
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface BrandRepository : JpaRepository<Brand, Int> {

    @Query("select b from Brand b where b.classify=?1")
    fun findAllByClassify(classify: Int) : List<Brand>


}