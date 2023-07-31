package com.mobilebreakero.common.navigationanim

import com.mobilebreakero.common.R

object NavOptions {

    val NavOptions = androidx.navigation.NavOptions.Builder()
        .setPopEnterAnim(R.anim.fade_in)
        .setEnterAnim(R.anim.slide_in)
        .setPopExitAnim(R.anim.slide_out)
        .setExitAnim(R.anim.fade_out)
        .build()
}