package com.gumio_inf.futurelabhackathonapp.models.enumerate

import android.support.v4.app.Fragment
import com.gumio_inf.futurelabhackathonapp.views.fragment.HomeFragment
import com.gumio_inf.futurelabhackathonapp.views.fragment.NekonoteFragment
import com.gumio_inf.futurelabhackathonapp.views.fragment.YabaiFragment

/**
 * Created by gumio_inf on 2018/01/28.
 */
enum class FragmentType constructor(val index: Int) {
    YABAI(1000),
    HOME(2000),
    NEKONOTE(3000)
    ;

    companion object {
        fun fromInt(index: Int): FragmentType? {
            return values().firstOrNull { it.index == index }
        }

        fun getTitleText(fragment: Fragment): String {
            return when (fragment.tag) {
                YABAI.getTag() -> "ヤバイ"
                HOME.getTag() -> "ホーム"
                NEKONOTE.getTag() -> "猫の手"
                else -> return "hoge"
            }
        }
    }

    fun getFragment(): Fragment {
        return when (this) {
            YABAI -> YabaiFragment()
            HOME -> HomeFragment()
            NEKONOTE -> NekonoteFragment()
        }
    }

    fun getTag(): String {
        return this.index.toString()
    }
}