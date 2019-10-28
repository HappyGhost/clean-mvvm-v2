package com.myapp.myapplication.core.view.edittext

import android.content.Context
import com.google.android.material.textfield.TextInputEditText
import android.util.AttributeSet
import com.myapp.myapplication.core.view.edittext.validation.BaseValidationRule
import com.myapp.myapplication.core.view.edittext.validation.EmptyValidationRule


open class BankEditText : TextInputEditText {

    var validationRules = arrayListOf<BaseValidationRule>()
    var isRequiredField = true
    var emptyValidationRule = EmptyValidationRule(context)

    constructor(context: Context) : super(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        validationRules.add(emptyValidationRule)
    }

    open fun addValidationRule(validationRule: BaseValidationRule) {
        validationRules.add(validationRule)
    }

    fun isValid(): Boolean {
        if (!isRequiredField && text.toString().isEmpty()) {
            return true
        }

        validationRules.forEach {
            if (!it.isValid(text.toString())) {
                error = it.errorMessage
                return false
            }
        }
        return true
    }

    fun setEmptyErrorMessage(errorMessage: String) {
        emptyValidationRule.errorMessage = errorMessage
    }
}