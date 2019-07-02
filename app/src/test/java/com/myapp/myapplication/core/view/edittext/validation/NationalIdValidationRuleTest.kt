package com.myapp.myapplication.core.view.edittext.validation

import org.junit.Assert
import org.junit.Test

class NationalIdValidationRuleTest{

    var validation = NationalIdValidationRule("")

    @Test
    fun returnTrue_when_InputIs12Numbers(){
        Assert.assertEquals(true, validation.isValid("123456789012"))
    }

    @Test
    fun returnTrue_when_InputIs9Numbers(){
        Assert.assertEquals(true, validation.isValid("123456789"))
    }

    @Test
    fun returnFalse_when_InputIs11Numbers(){
        Assert.assertEquals(false, validation.isValid("12345678901"))
    }

    @Test
    fun returnFalse_when_InputIs13Numbers(){
        Assert.assertEquals(false, validation.isValid("1234567890123"))
    }

    @Test
    fun returnFalse_when_InputIs8Numbers(){
        Assert.assertEquals(false, validation.isValid("12345678"))
    }

    @Test
    fun returnFalse_when_InputIs10Numbers(){
        Assert.assertEquals(false, validation.isValid("1234567890"))
    }
}