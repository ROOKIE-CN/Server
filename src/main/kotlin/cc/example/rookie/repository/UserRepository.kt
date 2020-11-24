package cc.example.rookie.repository

import cc.example.rookie.entity.User
import com.sun.org.apache.xpath.internal.operations.Bool
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.io.Serializable
import java.util.*

@Repository
interface UserRepository : JpaRepository<User,Int>,Serializable  {

    @Query("select u from User u where u.account=?1")
    fun findByAccount(account: String) : Optional<User>

    @Query("select u from User u where u.account=?1 and u.password=?2")
    fun login(account: String,password: String) : User

//    fun existsByAccount(account: String) :

}