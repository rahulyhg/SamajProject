package com.example.mf.satwarasamaj.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mf.satwarasamaj.R

class SignUpNameFragment : Fragment() {

    var mListener: SignUpNameFragmentListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sign_up_name, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is SignUpNameFragmentListener){
            mListener = context
        }else{
            throw RuntimeException(context.toString() + " must implement SignUpNameFragmentListener")
        }
    }

    interface SignUpNameFragmentListener {
        fun onNextButtonClicked(){}
    }
}
