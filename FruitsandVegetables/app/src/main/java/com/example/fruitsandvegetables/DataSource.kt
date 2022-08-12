package com.example.fruitsandvegetables

import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory


class DataSource{


    val BASE_URL ="http://192.168.0.103:3001/v1/"

    companion object{
        fun createDataSet(): ArrayList<Receipt>{
            val list = ArrayList<Receipt>()
            list.add(
                Receipt(
                    "something",
                    "fruit",
                    "0",
                    "0",
                    "0"
                )
            )
            return list
        }
    }

    private fun getData(){
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = api.getReceipts()?.await()
                if(response!=null){
                    print(response)
                }
            } catch (e: Exception) { withContext(Dispatchers.Main){
//                Toast.makeText(
//                    getA,
//                    "Seems like something went wrong...",
//                    Toast.LENGTH_SHORT
//                ).show()
            }
            }
        }
    }


//    companion object{
//        val list = ArrayList<Receipt>()
//        fun createDataSet(a:List<Receipt> ): ArrayList<Receipt>{
//            //val list = ArrayList<Receipt>()
//            for (i in 1..a.size) {
//                list.add(
//                    Receipt(
//                        "something",
//                        a[i].fruitsPrice,
//                        "something",
//                        "something"
//                        //a[i].fruitsQuantity,
//                        //a[i].fruitsTotal
//                    )
//                )
//            }
//            return list
//        }
//
//    }
}