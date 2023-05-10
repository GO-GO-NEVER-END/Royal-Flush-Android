package com.ggne.feature_common.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.ggne.feature_common.R
import com.ggne.feature_common.databinding.RoyalFlushEditTextBinding

class RoyalFlushEditText(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private val binding =
        RoyalFlushEditTextBinding.inflate(LayoutInflater.from(context), this, true)

    init {

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.RoyalFlushEditText,
            0,
            0,
        ).apply {
            try {

                getResourceId(
                    R.styleable.RoyalFlushEditText_startIcon,
                    EMPTY_RESOURCE,
                ).let { resource ->
                    if (resource == EMPTY_RESOURCE) {
                        binding.startIc.visibility = GONE
                    } else {
                        binding.startIc.setImageResource(resource)
                    }
                }

                getResourceId(
                    R.styleable.RoyalFlushEditText_endIcon,
                    EMPTY_RESOURCE,
                ).let { resource ->
                    if (resource == EMPTY_RESOURCE) {
                        binding.endIc.visibility = GONE
                    } else {
                        binding.endIc.setImageResource(resource)
                    }
                }

                getString(R.styleable.RoyalFlushEditText_royalFlushEditTextHint).let { hint ->
                    binding.et.hint = hint
                }

            } finally {
                recycle()
            }
        }

        removeAllViews()
        addView(binding.root)
    }

    companion object {
        private const val EMPTY_RESOURCE = -1
    }
}
