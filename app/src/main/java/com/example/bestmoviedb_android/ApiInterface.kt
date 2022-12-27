package com.example.bestmoviedb_android

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiInterface {

    @GET("{value}?api_key=67145ead4a484e68bb814e8f40a76ce8&language=en-US&page=1")
    fun getData(@Path("value") value: String): Call<JsonResponse>

}