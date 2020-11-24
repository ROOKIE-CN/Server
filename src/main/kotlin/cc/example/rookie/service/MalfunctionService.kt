package cc.example.rookie.service

import cc.example.rookie.common.Result
import cc.example.rookie.entity.Malfunction
import java.util.*

interface MalfunctionService {

    fun findAll() : List<Malfunction>

    fun save(content : String,eval : Double) : Result

    fun save(malfunction: Malfunction) : Malfunction

    fun findById(id : Int) : Optional<Malfunction>

    fun existsById(id : Int) : Boolean




}