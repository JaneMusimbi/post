
package com.revision.mypost

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.revision.mypost.databinding.ActivityMainBinding
import com.revision.mypost.databinding.PostListItemBinding

class PostrvAdapter(var  context: Context, var post:List<Post>):
    RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):PostViewHolder {
        var binding = PostListItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPosts = post.get(position)
        with(holder.binding){
            tvuserId.text = currentPosts.userId.toString()
            tvid.text = currentPosts.id.toString()
            tvtitle.text = currentPosts.title
            tvbody.text = currentPosts.body
        }
    }

    override fun getItemCount(): Int {
        return post.size
    }
}
class PostViewHolder(val binding: PostListItemBinding): RecyclerView.ViewHolder(binding.root)

