
package com.revision.mypost

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.revision.mypost.databinding.ActivityMainBinding
import com.revision.mypost.databinding.PostListItemBinding

class PostrvAdapter(var  context: Context, var displaypost:List<Post>):
    RecyclerView.Adapter<PostrvAdapter.RetrofitViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RetrofitViewHolder {
        var binding = PostListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RetrofitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentPosts = displaypost.get(position)
        with(holder.binding){
            tvuserId.text = currentPosts.userId.toString()
            tvid.text = currentPosts.id.toString()
            tvtitle.text = currentPosts.title
            tvbody.text = currentPosts.body
        }
    }

    override fun getItemCount(): Int {
        return displaypost.size
    }
    class RetrofitViewHolder(val binding: PostListItemBinding): RecyclerView.ViewHolder(binding.root)

}

