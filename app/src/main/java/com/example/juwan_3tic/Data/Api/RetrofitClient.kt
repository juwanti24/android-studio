package com.example.juwan_3tic.Data.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetrofitClient {
    // GANTI dengan Project URL dan publishable key milik project latihan.
// Jangan gunakan secret key / service_role key pada aplikasi Android.
    const val BASE_URL = "https://mxenuvbqbtfcqfpzwtpv.supabase.co/rest/v1/"
    const val API_KEY = "sb_publishable_wzV3R8osNlQAIcTmT_xv6Q_rPlNN4-Q"
    val service: CatatanApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatatanApiService::class.java)
    }
}