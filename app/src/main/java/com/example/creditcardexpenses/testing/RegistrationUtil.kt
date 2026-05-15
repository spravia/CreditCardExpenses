package com.example.creditcardexpenses.testing
//TODO Testing
//https://www.youtube.com/playlist?list=PLQkwcJG4YTCSYJ13G4kVIJ10X5zisB2Lq
//Part3              RegistrationUtilTest
//Before and After   ResourceComparerTest
//



object RegistrationUtil {

    private val existingUsers = listOf("Peter", "Carl")

    fun validateRegistrationInput(
        username: String,
        password: String,
        confirmedPassword : String

    ) : Boolean {

        if(username.isEmpty() || password.isEmpty()){
            return false

        }
        if(username in existingUsers){
            return false
        }

        if(password != confirmedPassword){
            return false
        }

        if(password.count { it.isDigit()} < 2){
            return false
        }

        return true
    }
}