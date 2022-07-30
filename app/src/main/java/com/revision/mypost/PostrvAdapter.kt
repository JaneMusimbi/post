
package com.revision.mypost

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
//import com.revision.mypost.databinding.ActivityMainBinding
import com.revision.mypost.databinding.PostListItemBinding

class displayPostrvAdapter(var Context: Context, var displaypost:List<Post>):
    RecyclerView.Adapter<displayPostrvAdapter.retrofitViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):retrofitViewHolder {
        var binding = PostListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return retrofitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: displayPostrvAdapter.retrofitViewHolder, position: Int) {
        var currentPosts = displaypost.get(position)
        holder.binding.tvuserId.text = currentPosts.userId.toString()
        holder.binding.tvid.text = currentPosts.id.toString()
        holder.binding.tvtitle.text = currentPosts.title
        holder.binding.tvbody.text = currentPosts.body

    }

    override fun getItemCount(): Int {
        return displaypost.size
    }
    class retrofitViewHolder(val binding: PostListItemBinding): RecyclerView.ViewHolder(binding.root)

}

