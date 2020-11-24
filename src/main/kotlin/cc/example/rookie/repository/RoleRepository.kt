package cc.example.rookie.repository

import cc.example.rookie.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RoleRepository : JpaRepository<Role,Int> {

    @Query("select r from Role r where r.roleName=?1")
    fun findRoleByRoleName(name : String) : Optional<Role>

}