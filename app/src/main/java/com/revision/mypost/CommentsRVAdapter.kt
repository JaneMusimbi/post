package com.revision.mypost

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.revision.mypost.databinding.CommentsListItemBinding

class CommentsRVAdapter(var commentList:List<comment>):RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding = CommentsListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent,false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var Comment = commentList.get(position)
        with(holder.binding){
            tvpost.text = Comment.postId.toString()
            tvID.text = Comment.id.toString()
            tvname.text = Comment.name
            tvemail.text = Comment.email
            tvBody1.text = Comment.body
        }
    }

    override fun getItemCount(): Int {
        return commentList.size
    }
}

class CommentViewHolder(var binding: CommentsListItemBinding):RecyclerView.ViewHolder(binding.root)