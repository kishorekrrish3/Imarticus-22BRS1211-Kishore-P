package com.example.app

import android.R
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var adapter: ImageAdapter? = null
    private var apiService: ApiService? = null

    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.setLayoutManager(GridLayoutManager(this, 2))

        apiService =
            RetrofitClient.getClient("https://your.base.url/").create(ApiService::class.java)
        fetchImages()
    }

    private fun fetchImages() {
        apiService.getImages().enqueue(object : Callback<List<Image?>?>() {
            fun onResponse(call: Call<List<Image?>?>?, response: Response<List<Image?>?>) {
                if (response.isSuccessful()) {
                    val images: List<Image> = response.body()
                    adapter = ImageAdapter(images)
                    recyclerView.setAdapter(adapter)
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Failed to retrieve images",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            fun onFailure(call: Call<List<Image?>?>?, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: " + t.message, Toast.LENGTH_SHORT).show()
                Log.e("MainActivity", t.message, t)
            }
        })
    }
}