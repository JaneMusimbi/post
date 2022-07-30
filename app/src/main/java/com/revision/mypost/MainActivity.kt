package com.revision.mypost

//import android.graphics.PostProcessor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.telecom.Call
//import android.view.SurfaceHolder
//import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.revision.mypost.databinding.ActivityMainBinding
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchPosts()
    }
    fun fetchPosts(){
        var apiClient = Apiclient.buildApiclient(ApiInterface::class.java)
        var request =  apiClient.getposts()

        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(
                call: retrofit2.Call<List<Post>>,
                response: Response<List<Post>>
            ) {
                if (response.isSuccessful){
                    var posts = response.body()
                    Toast.makeText(baseContext,"Fetched ${posts!!.size} posts", Toast.LENGTH_LONG)
                        .show()

                    var displayPostsRvAdapter=displayPostrvAdapter(baseContext,posts)
                    binding.rvPost.layoutManager=LinearLayoutManager(baseContext)
                    binding.rvPost.adapter = displayPostsRvAdapter

                }
            }

            override fun onFailure(call: retrofit2.Call<List<Post>>, t: Throwable) {
            }

        })


    }}