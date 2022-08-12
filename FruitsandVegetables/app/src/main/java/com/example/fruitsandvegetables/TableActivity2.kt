package com.example.fruitsandvegetables

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory

class TableActivity2 : AppCompatActivity(),OnItemClickListener{
    val BASE_URL ="http://192.168.43.92:3001/v1/"
    var list = ArrayList<Receipt>()
    var refresh=0;
    private lateinit var blogAdapter: BlogRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table2)
        initRecyclerView()
        getData()
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
                    blogAdapter.submitList(response)
                    resetAdapterState()
                    //blogAdapter.notifyDataSetChanged()
                }
            } catch (e: Exception) { withContext(Dispatchers.Main){
                    Toast.makeText(applicationContext, "Fetching Data...", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onItemClicked(receipt: Receipt) {
        print(receipt.toString())
        val intent = Intent(this@TableActivity2,DeleteActivity::class.java)
        //print(preview.camera.);
        intent.putExtra("ID",receipt.id)
        intent.putExtra("name",receipt.fruitsName)
        intent.putExtra("price",receipt.fruitsPrice)
        intent.putExtra("quantity",receipt.quantity)
        intent.putExtra("total",receipt.totalPrice)
        finish()
        startActivity(intent)
    }

    private fun addDataSet(){
        blogAdapter.submitList(list)
        blogAdapter.notifyDataSetChanged()
    }

    private fun initRecyclerView(){

        findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = LinearLayoutManager(this@TableActivity2)
            blogAdapter = BlogRecyclerAdapter(this@TableActivity2)
            adapter = blogAdapter
        }
    }

    private fun resetAdapterState() {
        val myAdapter = findViewById<RecyclerView>(R.id.recycler_view).adapter
        findViewById<RecyclerView>(R.id.recycler_view).adapter = myAdapter
    }

}