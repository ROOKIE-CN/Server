package cc.example.rookie.repository

import cc.example.rookie.entity.Parameter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParameterRepository : JpaRepository<Parameter,Int> {



}