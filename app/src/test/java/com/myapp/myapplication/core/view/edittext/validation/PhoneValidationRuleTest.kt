package com.myapp.myapplication.core.view.edittext.validation

import org.junit.Assert
import org.junit.Test

class PhoneValidationRuleTest {

    var phoneValidationRule = PhoneValidationRule("")

    @Test
    fun returnTrue_When_PhoneStartWith0120And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01201234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0120AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("012012345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0120AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0120654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith0121And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01211231234"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0121AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("012112312345"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0121AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0121654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith0122And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01221231234"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0122AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("012212312345"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0122AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0122654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith0123And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01231234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0123AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("012312345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0123AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0123654321"))
    }


    @Test
    fun returnTrue_When_PhoneStartWith0124And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01241234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0124AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("012412345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0124AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0124654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith0125And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01251234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0125AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("012512345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0125AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0125654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith0126And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01261234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0126AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("012612345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0126AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0126654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith0127And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01271234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0127AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("012712345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0127AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0127654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith0128And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01281234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0128AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("012812345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0128AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0128654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith0129And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01291234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0129AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("012912345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0129AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0129654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith0162And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01621234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0162AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("016212345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0162AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0162654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith0163And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01631234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0163AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("016312345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0163AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0164654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith0164And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01641234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0164AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("016412345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0164AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0164654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith0165And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01651234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0165AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("016512345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0165AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0165654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith0166And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01661234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0166AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("016612345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0166AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0166654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith0167And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01671234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0167AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("016712345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0167AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0167654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith0168And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01681234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0168AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("016812345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0168AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0168654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith0169And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01691234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0169AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("016912345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0169AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0169654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith0186And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01861234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0186AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("018612345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0186AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0186654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith0188And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01881234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0188AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("018812345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0188AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0188654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith0199And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("01991234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0199AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("019912345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith0199AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0199654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith086And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("0861234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith086AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("08612345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith086AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("086654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith088And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("0881234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith088AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("08812345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith088AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("088654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith089And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("0891234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith089AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("08912345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith089AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("089654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith090And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("0901234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith090AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("09012345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith090AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("090654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith091And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("0911234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith091AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("09112345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith091AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("091654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith092And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("0921234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith092AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("09212345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith092AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("092654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith093And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("0931234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith093AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("09312345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith093AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("093654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith094And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("0941234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith094AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("09412345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith094AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("094654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith095And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("0951234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith095AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("09512345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith095AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("095654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith096And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("0961234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith096AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("09612345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith096AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("096654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith097And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("0971234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith097AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("09712345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith097AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("097654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith098And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("0981234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith098AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("09812345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith098AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("098654321"))
    }

    @Test
    fun returnTrue_When_PhoneStartWith099And7NumberAfterThat() {
        Assert.assertEquals(true, phoneValidationRule.isValid("0991234567"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith099AndOver7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("09912345678"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith099AndBelow7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("099654321"))
    }

    @Test
    fun returnFalse_When_PhoneStartWith070And7NumberAfterThat() {
        Assert.assertEquals(false, phoneValidationRule.isValid("0701234567"))
    }

    @Test
    fun returnFalse_When_PhoneIsEmpty() {
        Assert.assertEquals(false, phoneValidationRule.isValid(""))
    }

}