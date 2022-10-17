package com.example.basketb.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class NetworkClient {

    companion object {
        private var instance : Retrofit? = null

        fun getInstance() : Retrofit {
            if(instance == null){
                instance = Retrofit.Builder()
                    .baseUrl("https://www.mocky.io")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return instance!!
        }

        fun <T> create(service : Class<T>) = instance?.create(service)
    }

}