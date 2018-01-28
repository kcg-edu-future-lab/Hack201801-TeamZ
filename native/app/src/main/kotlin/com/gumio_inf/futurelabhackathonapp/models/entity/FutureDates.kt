package com.gumio_inf.futurelabhackathonapp.models.entity

import java.util.*

/**
 * Created by gumio_inf on 2018/01/28.
 */
data class User(
        var name: String,
        var role: String,
        var schedule: Schedule,
        var created_at: String,
        var updated_at: String
) {
    data class Schedule(
            var date: Date,
            var emergency: Boolean
    )
}