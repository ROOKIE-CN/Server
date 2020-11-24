package cc.example.rookie.common

class Organize : HashMap<String, Any>() {

    fun add(key : String , value : Any) : Organize {
        this[key] = value
        return this;
    }

}