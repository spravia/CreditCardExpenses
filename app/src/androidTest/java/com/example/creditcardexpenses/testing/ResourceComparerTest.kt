package com.example.creditcardexpenses.testing

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.creditcardexpenses.R
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

  //TODO Before and After

class ResourceComparerTest{

    private  lateinit var resourceComparer : ResourceComparer
    private  lateinit var letra : String
    @Before
    fun setup(){

          if(!::letra.isInitialized){
               letra = "a"
          }
          resourceComparer = ResourceComparer()
    }

    @After
    fun teardown(){
    }

    @Test
    fun stringResourceSameAsGivenString_returnsTrue(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "CreditCardExpenses" )
        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDifferentAsGivenString_returnsFalse(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "Hello")
        assertThat(result).isFalse()
    }
}