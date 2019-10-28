package com.myapp.mvvmexample.core.dialog

import android.content.Context
import android.graphics.PorterDuff
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.myapp.myapplication.R

class LoadingDialogMaterial(context: Context) : BaseDialogMaterialView(context) {

    protected lateinit var mMessage: String

    private var tvMessage: TextView? = null
    private var progressBar: ProgressBar? = null

    override val layout: Int
        get() = R.layout.dialog_loading_default

    fun setMessage(message: String) {
        mMessage = message
        tvMessage?.text = message
    }

    override fun bindView() {
        progressBar = customView.findViewById(R.id.progressBar)
        progressBar?.indeterminateDrawable?.setColorFilter(
            ContextCompat.getColor(
                context,
                R.color.colorPrimary
            ),
            PorterDuff.Mode.MULTIPLY
        )
        tvMessage?.text = mMessage
    }
}
