package com.example.mf.satwarasamaj.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mf.satwarasamaj.R
import kotlinx.android.synthetic.main.fragment_sign_up_password.*

class SignUpPasswordFragment : Fragment() {

    private var mListener: SignUpPasswordFragmentListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sign_up_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        finishButton.setOnClickListener {
            mListener?.onFinishButtonClicked()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is SignUpPasswordFragmentListener) {
            mListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement SignUpPasswordFragmentListener")
        }
    }

    interface SignUpPasswordFragmentListener {
        fun onFinishButtonClicked() {}
    }

}
