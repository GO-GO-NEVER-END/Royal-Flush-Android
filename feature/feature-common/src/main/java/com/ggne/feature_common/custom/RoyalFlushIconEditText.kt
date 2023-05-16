package com.ggne.feature_common.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.ggne.feature_common.R
import com.ggne.feature_common.databinding.RoyalFlushIconEditTextBinding

class RoyalFlushIconEditText(context: Context, attrs: AttributeSet) :
    ConstraintLayout(context, attrs) {

    private val binding =
        RoyalFlushIconEditTextBinding.inflate(LayoutInflater.from(context), this, true)

    init {

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.RoyalFlushIconEditText,
            0,
            0,
        ).apply {
            try {

                getResourceId(
                    R.styleable.RoyalFlushIconEditText_startIcon,
                    EMPTY_RESOURCE,
                ).let { resource ->
                    if (resource == EMPTY_RESOURCE) {
                        binding.startIc.visibility = GONE
                    } else {
                        binding.startIc.setImageResource(resource)
                    }
                }

                getResourceId(
                    R.styleable.RoyalFlushIconEditText_endIcon,
                    EMPTY_RESOURCE,
                ).let { resource ->
                    if (resource == EMPTY_RESOURCE) {
                        binding.endIc.visibility = GONE
                    } else {
                        binding.endIc.setImageResource(resource)
                    }
                }

                getString(R.styleable.RoyalFlushIconEditText_royalFlushIconEditTextHint).let { hint ->
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
