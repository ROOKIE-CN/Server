package cc.example.rookie.service.impl

import cc.example.rookie.entity.Permission
import cc.example.rookie.entity.Role
import cc.example.rookie.repository.RoleRepository
import cc.example.rookie.service.RoleService
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.Resource

@Service
class RoleServiceImpl : RoleService{

    @Resource
    lateinit var roleRepository : RoleRepository

    override fun insertRole(roleName: String, permissions: Array<Permission>): Optional<Role> =
            Optional.of(roleRepository.save(Role(roleName,permissions.toSet())))

    override fun findRoleById(id: Int): Optional<Role> = roleRepository.findById(id)

    override fun findRoleByRoleName(name: String): Optional<Role> = roleRepository.findRoleByRoleName(name)

    override fun existsRoleById(id: Int): Boolean = findRoleById(id).isPresent

    override fun existsRoleByRoleName(name: String): Boolean {
        TODO("Not yet implemented")
    }
}