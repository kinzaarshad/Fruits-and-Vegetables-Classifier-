package com.example.fruitsandvegetables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory

class DeleteActivity : AppCompatActivity() {
    var quantity=0;
    var price=""
    var name="";
    var id=""
    var total="";

    val BASE_URL ="http://192.168.43.92:3001/v1/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)
        id= intent.getStringExtra("ID").toString()
        name= intent.getStringExtra("name").toString()
        price= intent.getStringExtra("price").toString()
        quantity= Integer.parseInt(intent.getStringExtra("quantity").toString())
        total= intent.getStringExtra("total").toString()
        findViewById<EditText>(R.id.editName).setText(name)
        findViewById<TextView>(R.id.resultPrice).text=price
        findViewById<TextView>(R.id.quantityText).text=intent.getStringExtra("quantity").toString()
        findViewById<TextView>(R.id.resultTotalPrice).text=total


        findViewById<ImageButton>(R.id.upperbutton).setOnClickListener(){ view ->
            val t =findViewById<TextView>(R.id.quantityText);
            quantity=Integer.parseInt(t.text.toString())+1;
            t.text=quantity.toString();
            getCurrentData()

        }
        findViewById<ImageButton>(R.id.lowerbutton).setOnClickListener(){ view ->
            val t =findViewById<TextView>(R.id.quantityText);
            quantity=Integer.parseInt(t.text.toString());
            if(quantity<=0){

            }
            else{
                quantity--;
                t.text=quantity.toString();
                getCurrentData()
            }

        }

        findViewById<Button>(R.id.deleteButton).setOnClickListener(){ view ->
            val api = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)

            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val response = api.deleteReceipt(id)?.await()
                    if (response != null) {
                            Toast.makeText(applicationContext, "Data Deleted", Toast.LENGTH_SHORT).show()
                            //
                    }

                } catch (e: Exception) { withContext(Dispatchers.Main) {
                    Toast.makeText(applicationContext, "Data Deleted...", Toast.LENGTH_SHORT).show()
                }
                }
            }

        }

        findViewById<Button>(R.id.editButton).setOnClickListener(){ view ->
            val api = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)

            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val response = api.editReceipt(id,getReceiptRequest())?.await()
                    if (response != null) {
                            Toast.makeText(applicationContext, "Data Edited Successfully", Toast.LENGTH_SHORT).show()
                    }

                } catch (e: Exception) { withContext(Dispatchers.Main) {
                    Toast.makeText(applicationContext, "Data Edited...", Toast.LENGTH_SHORT).show()
                }
                }
            }

        }
    }

    private fun getCurrentData() {
        //findViewById<TextView>(R.id.resultPrice).text=price
        var quantity=findViewById<TextView>(R.id.quantityText).text.toString()
        var total =price.toInt()* quantity.toInt()
        findViewById<TextView>(R.id.resultTotalPrice).text=total.toString()
    }

    fun getReceiptRequest(): JsonObject {
        val request = JsonObject()
        //val request = postReq(result,findViewById<TextView>(R.id.resultPrice).text.toString(),findViewById<TextView>(R.id.quantityText).text.toString(),findViewById<TextView>(R.id.resultTotalPrice).text.toString())
        request.addProperty("fruitsName",findViewById<TextView>(R.id.editName).text.toString())
        request.addProperty("fruitsPrice",findViewById<TextView>(R.id.resultPrice).text.toString())
        request.addProperty("quantity",findViewById<TextView>(R.id.quantityText).text.toString())
        request.addProperty("totalPrice",findViewById<TextView>(R.id.resultTotalPrice).text.toString())
        print(request.toString())
        return request;
    }
}