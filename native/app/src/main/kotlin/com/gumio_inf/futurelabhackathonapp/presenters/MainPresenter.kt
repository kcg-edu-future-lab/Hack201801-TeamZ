package com.gumio_inf.futurelabhackathonapp.presenters

import com.gumio_inf.futurelabhackathonapp.contracts.MainContract
import com.gumio_inf.futurelabhackathonapp.views.activity.MainActivity

/**
 * Created by gumio_inf on 2018/01/28.
 */
object MainPresenter: Presenter {

    lateinit var activity: MainActivity
    lateinit var contract: MainContract

    fun init(activity: MainActivity, contract: MainContract) {
        this.activity = activity
        this.contract = contract
    }

    fun showToolbar() {
        contract.showToolbar()
    }

    fun hideToolbar() {
        contract.hideToolbar()
    }

    override fun resume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun destroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}