package cc.example.rookie.service

import cc.example.rookie.entity.Permission
import cc.example.rookie.entity.Role
import java.util.*

interface RoleService {

    fun insertRole(roleName : String,permissions : Array<Permission>) : Optional<Role>

    fun findRoleById(id : Int) : Optional<Role>

    fun findRoleByRoleName(name : String) : Optional<Role>

    fun existsRoleById(id : Int) : Boolean

    fun existsRoleByRoleName(name : String) : Boolean



}