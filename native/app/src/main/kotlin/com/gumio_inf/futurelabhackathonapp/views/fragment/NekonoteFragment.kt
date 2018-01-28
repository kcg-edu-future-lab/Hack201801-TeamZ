package com.gumio_inf.futurelabhackathonapp.views.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gumio_inf.futurelabhackathonapp.R
import com.gumio_inf.futurelabhackathonapp.databinding.FragmentNekonoteBinding


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [NekonoteFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [NekonoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NekonoteFragment : FutureBaseFragment() {

    private var mBinding: FragmentNekonoteBinding? = null
    //private var mAdapter: RecyclerView.Adapter<NekonoteAdapter.ViewHolder>? = null

    private val itemImages: List<Int>? = null
    private val itemNames: List<String>? = null
    private val itemTimes: List<String>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_nekonote, container, false)
        return mBinding?.root!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // mBinding?.
    }

}