package cc.example.rookie.repository

import cc.example.rookie.entity.Malfunction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MalfunctionRepository : JpaRepository<Malfunction,Int> {
}