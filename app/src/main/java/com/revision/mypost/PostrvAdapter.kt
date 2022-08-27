
package com.revision.mypost

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.revision.mypost.databinding.ActivityCommentsBinding
import com.revision.mypost.databinding.PostListItemBinding

class PostrvAdapter(var post:List<Post>): RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):PostViewHolder {
        var binding = PostListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPosts = post.get(position)
        with(holder.binding){
            tvuserId.text = currentPosts.userId.toString()
            tvid.text = currentPosts.id.toString()
            tvtitle.text = currentPosts.title
            tvbody.text = currentPosts.body
            val context=holder.itemView.context
            holder.binding.cvPosts.setOnClickListener {
                val intent=Intent(context, CommentsActivity::class.java)
                intent.putExtra("POST_ID",currentPosts.id)
                context.startActivity(intent)

            }
        }
    }

    override fun getItemCount(): Int {
        return post.size
    }
}
class PostViewHolder(val binding: PostListItemBinding): RecyclerView.ViewHolder(binding.root)

