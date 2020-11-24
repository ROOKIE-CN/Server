package cc.example.rookie.common

class ResultData : HashMap<String, Any>() {

    fun push(string: String,value : Any) : ResultData{
        this[string] = value
        return this;
    }

}