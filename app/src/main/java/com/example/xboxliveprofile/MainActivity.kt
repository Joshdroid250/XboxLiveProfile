package com.example.xboxliveprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.example.xboxliveprofile.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            buscarStatPlayer()
        }
    }
    private fun getRetrofit(): Retrofit {
        val clientOk = OkHttpClient.Builder().addInterceptor { chain ->
            val token: String = "tok_dev_upH3fXJSDS3x5QD2zGzrNBU8BQxmb4nvUu7JkanRnbAyRbyHnoqbRcoQVTkqgQ2u"
            val newRequest: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
            chain.proceed(newRequest)
        }.build()
        return Retrofit
            .Builder()
            .baseUrl("https://halo.api.stdlib.com/infinite@1.0.0/tooling/xbox-network/players/profile/")
            .client(clientOk)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun buscarStatPlayer(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val txtSearch: String = binding.edtBuscar.text.toString().lowercase()
                val call = getRetrofit().create(ApiService::class.java).getStatsXboxLive("?gamertag=$txtSearch")
                if (call.isSuccessful){
                    val gamertag:String = call.body()?.data?.player?.gamertag.toString()
                    val photo:String = call.body()?.data?.player?.gamerpicUrl.toString()
                    binding.txGamertag.text = "$gamertag"
                    Picasso.get().load(photo).into(binding.imGamerTag)
                }

            }catch (ex: Exception){
                val msn = Toast.makeText(this@MainActivity, "Error de conexion", Toast.LENGTH_LONG)
                msn.setGravity(Gravity.CENTER, 0, 0)
                msn.show()

            }
        }
    }
}