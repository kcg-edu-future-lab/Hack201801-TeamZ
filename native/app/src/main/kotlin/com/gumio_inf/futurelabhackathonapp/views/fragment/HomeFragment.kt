package com.gumio_inf.futurelabhackathonapp.views.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Spinner
import com.gumio_inf.futurelabhackathonapp.R
import com.gumio_inf.futurelabhackathonapp.databinding.FragmentHomeBinding
import com.gumio_inf.futurelabhackathonapp.models.api.FutureServices




/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : FutureBaseFragment() {

    private var mBinding: FragmentHomeBinding? = null
    private var mClient: FutureServices? = null

    private var mTaskText: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return mBinding?.root!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        mBinding?.sendYabai?.setOnClickListener {
//            App().client().sendEmergency()
//        }

        // リスナーを登録
        mBinding?.taskText?.onItemSelectedListener = object : OnItemSelectedListener {
            //　アイテムが選択された時
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                val spinner = parent as Spinner
                val item = spinner.selectedItem as String
                mTaskText = item
                Log.d("task:", mTaskText)
            }
            //　アイテムが選択されなかった
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        mBinding?.sendButton?.setOnClickListener {

            Log.d("task:", mTaskText)
            Log.d("time:", mBinding?.timeText?.text.toString())
            Log.d("detail:", mBinding?.detailsText?.text.toString())
            Log.d("yabai:", mBinding?.yabaiCheck?.isChecked!!.toString())

//            mClient?.sendInput(
//                    mTaskText!!,
//                    mBinding?.timeText?.text.toString(),
//                    mBinding?.detailsText?.text.toString(),
//                    mBinding?.yabaiCheck?.isChecked!!
//            )
        }
    }
}