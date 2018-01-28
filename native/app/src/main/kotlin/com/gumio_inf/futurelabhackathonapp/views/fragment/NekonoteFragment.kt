package com.gumio_inf.futurelabhackathonapp.views.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gumio_inf.futurelabhackathonapp.R


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [NekonoteFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [NekonoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NekonoteFragment : FutureBaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_nekonote, container, false)
    }

}