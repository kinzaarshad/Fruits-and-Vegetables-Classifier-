package com.example.fruitsandvegetables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory

class Result : AppCompatActivity() {

    var quantity=0;

    val BASE_URL ="http://192.168.43.92:3001/v1/"
        //"http://192.168.0.1/v1/fruits"
    val TAG = "MainActivity"
    var price=""
    var result="";
    //TextView t= new TextView();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        result= intent.getStringExtra("Result").toString()
        findViewById<TextView>(R.id.resultName).text="Result:"+result
        getPicture(result)
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
        findViewById<Button>(R.id.button).setOnClickListener(){ view ->
            val api = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)

            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val response = api.postReceipt(getReceiptRequest())?.await()
                    if (response != null) {
                        if(response.Fruit.fruitsPrice!=null){
                            Toast.makeText(applicationContext, "Data Uploaded Successfully", Toast.LENGTH_SHORT).show()
                //
                        }
                    }

                } catch (e: Exception) { withContext(Dispatchers.Main) {
                        Toast.makeText(applicationContext, "Data Uploaded...", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
        getCurrentData()


    }

    private fun getPicture(result: String?) {
        if(result=="Apple"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.apple)
            price="35"
        }
        if(result=="apple_6"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.apple)
            price="35"
        }
        if(result=="apple_braeburn_1"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.apple)
            price="35"
        }
        if(result=="apple_crimson_snow_1"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.apple)
            price="40"
        }
        if(result=="apple_golden_1"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.apple)
            price="40"
        }
        if(result=="apple_golden_2"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.apple)
            price="40"
        }
        if(result=="apple_golden_3"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.apple)
            price="40"
        }
        if(result=="apple_granny_smith_1"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.apple)
            price="40"
        }
        if(result=="apple_hit_1"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.apple)
            price="35"
        }
        if(result=="apple_pink_lady_1)"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.apple)
            price="35"
        }
        if(result=="apple_red_1"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.apple)
            price="35"
        }
        if(result=="apple_red_2"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.apple)
            price="35"
        }
        if(result=="apple_red_3"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.apple)
            price="35"
        }
        if(result=="apple_red_delicious_1"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.apple)
            price="35"
        }
        if(result=="apple_red_yellow_1"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.apple)
            price="35"
        }
        if(result=="apple_rotten_1"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.apple)
            price="15"
        }
        if(result=="banana"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.banana)
            price="25"
        }
        if(result=="beetroot"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.beetroot)
            price="50"
        }
        if(result=="Bitter_Melon"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.bittermelon)
            price="50"
        }
        if(result=="Brinjal_Dotted"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.eggplant)
            price="45"
        }
        if(result=="cabbage"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.cabage)
            price="45"
        }
        if(result=="cabbage_white_1"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.cabage)
            price="45"
        }
        if(result=="capsicum"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.capsicum)
            price="45"
        }
        if(result=="carrot"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.carrot)
            price="35"
        }
        if(result=="cauliflower"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.cauliflower)
            price="35"
        }
        if(result=="Chilli"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.chilli)
            price="35"
        }
        if(result=="chilli pepper"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.capsicum)
            price="35"
        }
        if(result=="corn"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.corn)
            price="25"
        }
        if(result=="cucumber_1"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.cucumber)
            price="25"
        }
        if(result=="cucumber_3"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.cucumber)
            price="25"
        }
        if(result=="eggplant"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.eggplant)
            price="45"
        }
        if(result=="eggplant_1"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.eggplant)
            price="45"
        }
        if(result=="Fig"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.figs)
            price="35"
        }
        if(result=="garlic"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.garlic)
            price="30"
        }
        if(result=="ginger"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.ginger)
            price="30"
        }
        if(result=="grapes"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.grapes)
            price="50"
        }
        if(result=="Green_Orange"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.orange)
            price="35"
        }
        if(result=="Green_Paper"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.capsicum)
            price="35"
        }
        if(result=="jalepeno"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.jalepeno)
            price="35"
        }
        if(result=="Kiwi"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.kiwi)
            price="35"
        }
        if(result=="lemon"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.lemon)
            price="25"
        }
        if(result=="lettuce"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.lettuce)
            price="35"
        }
        if(result=="mango"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.mango)
            price="50"
        }
        if(result=="Onion"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.onion)
            price="35"
        }
        if(result=="orange"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.orange)
            price="35"
        }
        if(result=="Papper"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.capsicum)
            price="35"
        }
        if(result=="paprika"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.capsicum)
            price="35"
        }
        if(result=="pear"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.pear)
            price="45"
        }
        if(result=="pear_1"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.pear)
            price="45"
        }
        if(result=="pear_3"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.pear)
            price="45"
        }
        if(result=="peas"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.peas)
            price="45"
        }
        if(result=="pineapple"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.pineapple)
            price="45"
        }
        if(result=="pomegranate"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.pomegranate)
            price="45"
        }
        if(result=="potato"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.potato)
            price="45"
        }
        if(result=="raddish"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.radish)
            price="45"
        }
        if(result=="Red_Cabbage"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.cabage)
            price="35"
        }
        if(result=="Sapodilla"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.sapodilla)
            price="35"
        }
        if(result=="SMG"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.smg)
            price="35"
        }
        if(result=="soy beans"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.soybeans)
            price="35"
        }
        if(result=="spinach"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.spinach)
            price="35"
        }
        if(result=="Spoung_Gourd"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.spounggoard)
            price="35"
        }
        if(result=="Strawberry"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.strawberry)
            price="50"
        }
        if(result=="sweetcorn"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.corn)
            price="25"
        }
        if(result=="sweetpotato"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.potato)
            price="35"
        }
        if(result=="tomato"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.tomato)
            price="35"
        }
        if(result=="Tomato_Green"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.tomato)
            price="35"
        }
        if(result=="Tomato_Red"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.tomato)
            price="35"
        }
        if(result=="turnip"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.turnip)
            price="35"
        }
        if(result=="watermelon"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.watermelon)
            price="35"
        }
        if(result=="zucchini_1"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.zuchini)
            price="35"
        }
        if(result=="zuchini_dark_1"){
            findViewById<ImageView>(R.id.resultImage).setImageResource(R.drawable.zuchini)
            price="35"
        }
    }

    private fun getCurrentData() {
        findViewById<TextView>(R.id.resultPrice).text=price
        var quantity=findViewById<TextView>(R.id.quantityText).text.toString()
        var total =price.toInt()* quantity.toInt()
        findViewById<TextView>(R.id.resultTotalPrice).text=total.toString()

//        val api = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiInterface::class.java)
//
//        GlobalScope.launch(Dispatchers.IO) {
//            try {
//                val response = api.getPrice(result)?.await()
//                if(response!=null){
//                    val data=response.fruitsPrice
//                    findViewById<TextView>(R.id.resultPrice).text=data.toString()
//                    var quantity=findViewById<TextView>(R.id.quantityText).text.toString()
//                    var total =data.toInt()* quantity.toInt()
//                    findViewById<TextView>(R.id.resultTotalPrice).text=total.toString()
//                }
////                if (response.isSuccessful) {
////
////                    val data = response.body()!!
////                    Log.d(TAG, data.toString())
////
////                    withContext(Dispatchers.Main) {
//////                        tv_textView.visibility = View.VISIBLE
//////                        tv_timeStamp.visibility = View.VISIBLE
//////                        progressBar.visibility = View.GONE
//////                        tv_timeStamp.text = data.createdAt
//////                        tv_textView.text = data.text
////
////                    }
////
////                }
//            } catch (e: Exception) { withContext(Dispatchers.Main){
//                    Toast.makeText(
//                        applicationContext,
//                        "Seems like something went wrong...",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
//        }


    }

    fun getPriceRequest(): JsonObject {
        val request = JsonObject()
        request.addProperty("Title",result)
        return request;
    }

    fun getReceiptRequest(): JsonObject {
        val request = JsonObject()
        //val request = postReq(result,findViewById<TextView>(R.id.resultPrice).text.toString(),findViewById<TextView>(R.id.quantityText).text.toString(),findViewById<TextView>(R.id.resultTotalPrice).text.toString())
        request.addProperty("fruitsName",result)
        request.addProperty("fruitsPrice",findViewById<TextView>(R.id.resultPrice).text.toString())
        request.addProperty("quantity",findViewById<TextView>(R.id.quantityText).text.toString())
        request.addProperty("totalPrice",findViewById<TextView>(R.id.resultTotalPrice).text.toString())
        print(request.toString())
        return request;
    }


}

class postReq internal constructor(val fruitsWeight: String, val fruitsPrice: String,val quantity:String,val totalPrice:String)

