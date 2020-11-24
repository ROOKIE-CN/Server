package cc.example.rookie.common.serializer

import cc.example.rookie.common.Organize
import cc.example.rookie.entity.User
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider

class UserSerializer : JsonSerializer<User>() {

    override fun serialize(user: User?, jsonGenerator: JsonGenerator?, p2: SerializerProvider?) {

        if (user != null && jsonGenerator != null){
            jsonGenerator.writeObject(Organize()
                    .add("id",user.id)
                    .add("account",user.account)
                    .add("userName",user.userName))
        }

    }
}