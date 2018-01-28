package com.gumio_inf.futurelabhackathonapp.models.api

import com.gumio_inf.futurelabhackathonapp.models.entity.User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by gumio_inf on 2018/01/28.
 */
interface FutureServices {
    @GET("api/user/{username}")
    fun getUser(@Path("username") user: String): Observable<User>

    @POST("")
    fun sendEmergency()
}