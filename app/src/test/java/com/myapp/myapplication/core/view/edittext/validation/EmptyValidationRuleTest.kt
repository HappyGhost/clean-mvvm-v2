package com.myapp.myapplication.core.view.edittext.validation

import org.junit.Assert
import org.junit.Test

class EmptyValidationRuleTest{

    var emptyValidationRule = EmptyValidationRule("")

    @Test
    fun returnTrue_when_InputNotEmpty(){
        Assert.assertEquals(true, emptyValidationRule.isValid("abc"))
    }

    @Test
    fun returnFalse_when_InputIsEmpty(){
        Assert.assertEquals(false, emptyValidationRule.isValid(""))
    }
}