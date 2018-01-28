package com.gumio_inf.futurelabhackathonapp.views.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gumio_inf.futurelabhackathonapp.R
import com.gumio_inf.futurelabhackathonapp.databinding.FragmentYabaiBinding


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [YabaiFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [YabaiFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class YabaiFragment : FutureBaseFragment() {

    private var mBinding: FragmentYabaiBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_yabai, container, false)
        return mBinding?.root!!
    }
}

