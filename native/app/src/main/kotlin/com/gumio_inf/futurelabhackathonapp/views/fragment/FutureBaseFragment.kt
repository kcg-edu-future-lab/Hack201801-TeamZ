package com.gumio_inf.futurelabhackathonapp.views.fragment

import android.support.v4.app.Fragment
import com.gumio_inf.futurelabhackathonapp.R
import com.gumio_inf.futurelabhackathonapp.models.enumerate.FragmentType

/**
 * Created by gumio_inf on 2018/01/28.
 */
open class FutureBaseFragment: Fragment() {
    fun replaceMainContainerTransaction(fragmentType: FragmentType) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.mainContainer, fragmentType.getFragment(), fragmentType.getTag())
        transaction.addToBackStack(null)
        transaction.commit()
    }
}