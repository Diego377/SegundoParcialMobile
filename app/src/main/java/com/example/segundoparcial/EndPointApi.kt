package com.example.segundoparcial
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface EndPointApi {
    @GET(ConstantsRestApi.POSTS)
    fun getAllPost(): Call<List<Post>>
}