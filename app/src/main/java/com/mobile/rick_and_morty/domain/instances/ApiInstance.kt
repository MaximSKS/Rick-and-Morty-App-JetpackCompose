package com.mobile.rick_and_morty.domain.instances

import com.mobile.rick_and_morty.data.remote.NetworkModule

object ApiInstance {
     val api = NetworkModule.provideApi()
}