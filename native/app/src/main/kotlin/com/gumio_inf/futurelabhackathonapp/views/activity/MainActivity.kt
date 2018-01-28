package com.gumio_inf.futurelabhackathonapp.views.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.gumio_inf.futurelabhackathonapp.R
import com.gumio_inf.futurelabhackathonapp.contracts.MainContract
import com.gumio_inf.futurelabhackathonapp.databinding.ActivityMainBinding
import com.gumio_inf.futurelabhackathonapp.models.enumerate.FragmentType
import com.gumio_inf.futurelabhackathonapp.presenters.MainPresenter

class MainActivity : FutureBaseAppCompatActivity(), MainContract {

    private var mBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if (MySharedPreferences.getActiveAppLogin()!!) {
//            MySharedPreferences.setFirstAppLaunch(true)
//            Log.d("isLogin", MySharedPreferences.getActiveAppLogin().toString())
//            setupViews()
//        } else {
//            MySharedPreferences.setFirstAppLaunch(false)
//            Log.d("isFirstLaunch", MySharedPreferences.getFirstAppLaunch().toString())
//            setupViews()
//        }
        setupViews()
    }

    private fun setupViews() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding?.bottomBar?.setOnTabSelectListener { tabId ->
            onTabChanged(tabId)
        }
        MainPresenter.init(this, this)
    }

    private fun onTabChanged(tabId: Int) {
        when (tabId) {
            R.id.tab_yabai -> {
                replaceMainContainerTransaction(FragmentType.YABAI)
            }
            R.id.tab_home -> {
                replaceMainContainerTransaction(FragmentType.HOME)
            }
            R.id.tab_nekonote -> {
                replaceMainContainerTransaction(FragmentType.NEKONOTE)
            }
        }
    }

    override fun showToolbar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideToolbar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
