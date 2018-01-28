package com.gumio_inf.futurelabhackathonapp.views.activity

import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.gumio_inf.futurelabhackathonapp.R
import com.gumio_inf.futurelabhackathonapp.models.enumerate.FragmentType
import com.gumio_inf.futurelabhackathonapp.models.enumerate.TranAnimType

/**
 * Created by gumio_inf on 2018/01/28.
 */
open class FutureBaseAppCompatActivity: AppCompatActivity() {
    fun replaceMainContainerTransaction(fragmentType: FragmentType, animType: TranAnimType = TranAnimType.IN_LEFT_OUT_RIGHT){
        Log.d("replaceMain", "fragmentType = $fragmentType, animType = $animType")
        val transaction = supportFragmentManager.beginTransaction()
        when(animType) {
            TranAnimType.IN_UP_OUT_DOWN ->
                transaction.setCustomAnimations(R.anim.in_up, R.anim.out_down, R.anim.in_up, R.anim.out_down)
            TranAnimType.IN_LEFT_OUT_RIGHT ->
                transaction.setCustomAnimations(R.anim.in_left, R.anim.out_right, R.anim.in_left, R.anim.out_right)
        }
        transaction.replace(R.id.mainContainer, fragmentType.getFragment(), fragmentType.getTag())
        transaction.commit()
    }

    fun replaceSecondContainerTransaction(fragmentType: FragmentType, animType: TranAnimType){
        Log.d("replaceSecond", "fragmentType = $fragmentType, animType = $animType")
        val transaction = supportFragmentManager.beginTransaction()
        when(animType) {
            TranAnimType.IN_UP_OUT_DOWN ->
                transaction.setCustomAnimations(R.anim.in_up, R.anim.out_down, R.anim.in_up, R.anim.out_down)
            TranAnimType.IN_LEFT_OUT_RIGHT ->
                transaction.setCustomAnimations(R.anim.in_left, R.anim.out_right, R.anim.in_left, R.anim.out_right)
        }
//        transaction.replace(R.id.secondContainer, fragmentType.getFragment(), fragmentType.getTag())
        transaction.addToBackStack(null)
        transaction.commit()
    }
}