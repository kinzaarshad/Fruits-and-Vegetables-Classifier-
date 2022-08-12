package com.example.fruitsandvegetables

import android.telecom.Call
import com.google.gson.JsonObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface ApiInterface {

//    @GET("/facts/random")
//    fun getPrice() : Call<Price>

    @GET("fruits/search")
    @FormUrlEncoded
    fun getPrice(@Query("FruitsId") FruitId:String): retrofit2.Call<Price?>?

    @POST("fruits/")
    fun postReceipt(@Body body: JsonObject): retrofit2.Call<Response>?

    @PUT("fruits/delete/")
    fun deleteReceipt(@Query("FruitId") FruitId:String): retrofit2.Call<Receipt>?

    @PUT("fruits/")
    fun editReceipt(@Query("FruitId") FruitId:String,@Body body: JsonObject): retrofit2.Call<Receipt>?

    @GET("fruits")
    fun getReceipts(): retrofit2.Call<List<Receipt>>?

//    companion object {
//
//        var BASE_URL = "http:///"
//
//        fun create() : ApiInterface {
//
//            val retrofit = Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(BASE_URL)
//                .build()
//            return retrofit.create(ApiInterface::class.java)
//
//        }
//    }

//    @GET("/facts/random")
//    fun getCatFacts(): Call<RandomCatFacts>
}