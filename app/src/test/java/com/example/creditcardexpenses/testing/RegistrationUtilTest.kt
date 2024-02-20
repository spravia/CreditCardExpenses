package com.example.creditcardexpenses.testing

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest{

    //  Uso de backticks   ``   para definir el nomber de una clase Test

    @Test
    fun `empty username returns false`(){

        val result = RegistrationUtil.validateRegistrationInput("","123", "123")

        assertThat(result).isFalse()

    }


    @Test
    fun `valid username and correctly repeated password returns true`(){

        val result = RegistrationUtil.validateRegistrationInput("Savas","123", "123")

        assertThat(result).isTrue()

    }


    @Test
    fun `username already exists  returns false`(){

        val result = RegistrationUtil.validateRegistrationInput("Carl","123", "123")

        assertThat(result).isFalse()

    }


    @Test
    fun `incorrectly confirmed password returns false`(){

        val result = RegistrationUtil.validateRegistrationInput("Carl","123", "sdfsdf")

        assertThat(result).isFalse()

    }

    @Test
    fun `empty password returns false`(){

        val result = RegistrationUtil.validateRegistrationInput("Savas","", "")

        assertThat(result).isFalse()

    }

    @Test
    fun `less than 2 digit password returns false`(){

        val result = RegistrationUtil.validateRegistrationInput("Savas","dsdasdasd", "sadasdasd")

        assertThat(result).isFalse()

    }



}