package cc.example.rookie.repository

import cc.example.rookie.entity.Classify
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClassifyRepository : JpaRepository<Classify,Int>{



}