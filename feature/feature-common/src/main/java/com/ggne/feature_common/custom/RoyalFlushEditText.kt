package com.ggne.feature_common.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.ggne.feature_common.databinding.RoyalFlushEditTextBinding

class RoyalFlushEditText(context: Context, attrs: AttributeSet): ConstraintLayout(context, attrs) {

    private val binding = RoyalFlushEditTextBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        removeAllViews()
        addView(binding.root)
    }
}