package cc.example.rookie.util

import java.util.regex.Pattern

class Utils {

    companion object {

        private var pattern = "^1(3([0-35-9]\\d|4[1-8])|4[14-9]\\d|5([0125689]\\d|7[1-79])|66\\d|7[2-35-8]\\d|8\\d{2}|9[13589]\\d)\\d{7}\$"

        fun verificationAccount(account: String)= Regex(pattern).matches(account)
    }

}