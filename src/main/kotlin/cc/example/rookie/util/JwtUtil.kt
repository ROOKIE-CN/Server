package cc.example.rookie.util

import cc.example.rookie.entity.User
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.*

class JwtUtil {

    companion object{

        var subject = "user"
        var timeout = 604800000
        var appsecret = "rookie&rabbit"

        fun generator(user: User?) : String? {

            if (user != null) {
                return Jwts.builder().setSubject(subject).claim("account",user.account).claim("password",user.password)
                        .setIssuedAt(Date())
                        .setExpiration(Date(System.currentTimeMillis() - timeout))
                        .signWith(SignatureAlgorithm.HS256, appsecret)
                        .compact()
            }
            return null
        }

        fun check(token: String) : Claims{
            return Jwts.parser().setSigningKey(appsecret)
                    .parseClaimsJws(token)
                    .body
        }

    }

}