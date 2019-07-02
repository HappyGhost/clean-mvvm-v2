package com.myapp.myapplication.core.view.edittext.validation

import org.junit.Assert
import org.junit.Test

class MinIncomeLoanValidationRuleTest {

    var validation = MinIncomeLoanValidationRule("")

    @Test
    fun returnTrue_when_inputIsOver3Millions() {
        Assert.assertEquals(true, validation.isValid("3000001"))
    }

    @Test
    fun returnFalse_when_inputIsBelow3Millions() {
        Assert.assertEquals(false, validation.isValid("2000001"))
    }

    @Test
    fun returnTrue_when_inputIsEqual3Millions() {
        Assert.assertEquals(false, validation.isValid("3000000"))
    }

    @Test
    fun returnFalse_when_inputIsNotNumber() {
        Assert.assertEquals(false, validation.isValid("abc"))
    }
}