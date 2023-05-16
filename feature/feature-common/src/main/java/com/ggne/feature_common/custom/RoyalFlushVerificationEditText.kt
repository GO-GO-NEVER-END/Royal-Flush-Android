package com.ggne.feature_common.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.ggne.feature_common.extensions.EMPTY
import com.ggne.feature_common.R
import com.ggne.feature_common.extensions.addAfterTextChangedListener
import com.ggne.feature_common.databinding.RoyalFlushVerificationEditTextBinding

class RoyalFlushVerificationEditText(context: Context, attrs: AttributeSet) :
    ConstraintLayout(context, attrs) {

    private var maxLength: Int
    private var verificationText: String = String.EMPTY

    val text
        get() = binding.et.text.toString()

    val editText
        get() = binding.et

    private val binding =
        RoyalFlushVerificationEditTextBinding.inflate(LayoutInflater.from(context), this, true)

    init {

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.RoyalFlushVerificationEditText,
            0,
            0,
        ).apply {
            try {

                getString(R.styleable.RoyalFlushVerificationEditText_royalFlushVerificationEditTextHint).let { hint ->
                    binding.et.hint = hint
                }

                getInt(R.styleable.RoyalFlushVerificationEditText_maxLength, Int.MAX_VALUE).let { inputtedMaxLength ->
                    maxLength = inputtedMaxLength
                }

                getBoolean(R.styleable.RoyalFlushVerificationEditText_isCounterVisible, true).let { isVisible ->
                    if (isVisible) {

                        with(binding.counterTv) {
                            visibility = VISIBLE
                            text = context.getString(R.string.text_counter_format, 0, maxLength)
                        }

                        binding.et.addAfterTextChangedListener { text ->
                            if (text.length <= maxLength) {
                                binding.counterTv.text = context.getString(R.string.text_counter_format, text.length, maxLength)
                            } else {
                                with(binding.et) {
                                    setText(text.substring(0, maxLength))
                                    setSelection(maxLength)
                                }
                            }
                        }

                    } else {
                        binding.counterTv.visibility = GONE
                        maxLength = Int.MAX_VALUE
                    }

                }

                getBoolean(R.styleable.RoyalFlushVerificationEditText_isVerificationVisible, false).let { isVisible ->
                    if (isVisible) {
                        getString(R.styleable.RoyalFlushVerificationEditText_verificationText).let { inputtedVerificationText ->
                            verificationText = inputtedVerificationText ?: String.EMPTY
                        }
                        setVerification(true)
                    } else {
                        setVerification(false)
                    }
                }


            } finally {
                recycle()
            }
        }

        removeAllViews()
        addView(binding.root)

    }

    fun setVerificationText(text: String) {
        verificationText = text
    }

    fun setVerification(isVerified: Boolean) {
        if (isVerified) {
            binding.verificationTv.visibility = VISIBLE
            binding.verificationTv.text = verificationText
        } else {
            binding.verificationTv.visibility = GONE
        }
    }


}