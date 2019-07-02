package com.myapp.myapplication.core.view.edittext.validation

import android.content.Context
import com.myapp.myapplication.R
import java.util.regex.Pattern


abstract class BaseValidationRule(var errorMessage: String) {

    abstract fun isValid(input: String): Boolean
}

class PhoneValidationRule(errorMessage: String) : BaseValidationRule(errorMessage) {

    var phoneRegex = "(^012\\d|^016[23456789]|^018[68]|^0199|^08[689]|^09\\d)\\d{7}$"
    override fun isValid(input: String): Boolean {
        var pattern = Pattern.compile(phoneRegex)
        return pattern.matcher(input).find()
    }
}

class EmptyValidationRule : BaseValidationRule {
    constructor(errorMessage: String) : super(errorMessage)
    constructor(context: Context) : super(context.getString(R.string.error_empty_field))

    override fun isValid(input: String): Boolean {
        return !input.isNullOrEmpty()
    }
}

class NationalIdValidationRule(errorMessage: String) : BaseValidationRule(errorMessage) {

    override fun isValid(input: String): Boolean {
        return input.length == 9 || input.length == 12
    }

}

class MinIncomeLoanValidationRule(errorMessage: String) : BaseValidationRule(errorMessage) {

    override fun isValid(input: String): Boolean {
        val income = input.toDouble()
        return income > 3000000
    }

}