package cc.example.rookie.repository

import cc.example.rookie.entity.ParameterOption
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ParameterOptionRepository : JpaRepository<ParameterOption,Int> {


    @Query("select o from ParameterOption o where o.parent=?1")
    fun findAllByParent(parent: Int) : List<ParameterOption>

}