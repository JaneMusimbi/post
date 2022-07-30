package com.revision.mypost

//import android.graphics.PostProcessor
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.revision.mypost.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchPosts()
    }

    fun fetchPosts() {
        var apiClient = Apiclient.buildApiclient(ApiInterface::class.java)
        var request = apiClient.getposts()

        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(
                call: Call<List<Post>>,
                response: Response<List<Post>>
            ) {
                if (response.isSuccessful) {
                    var posts = response.body()!!
                    Log.d("TAG", posts.toString())
                    var postAdapter = PostrvAdapter(baseContext, posts)
                    binding.rvPost.layoutManager = LinearLayoutManager(baseContext)
                    binding.rvPost.adapter = postAdapter
                    Toast.makeText(baseContext, "Fetched ${posts.size} posts", Toast.LENGTH_LONG)
                        .show()

                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

        })


    }
}
