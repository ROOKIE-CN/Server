package cc.example.rookie.annotation

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class UserAccess (
        val isAdmin : Boolean = false
)