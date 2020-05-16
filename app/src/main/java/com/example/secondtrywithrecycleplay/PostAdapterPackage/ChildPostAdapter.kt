package com.example.secondtrywithrecycleplay.PostAdapterPackage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.secondtrywithrecycleplay.PostData
import com.example.secondtrywithrecycleplay.PostType
import com.example.secondtrywithrecycleplay.R

class ChildPostAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var item: List<PostType> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun popMod(data: PostData){

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            PostType.FIRST_POST -> {
                ChildViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.post_1, parent, false)
                )

            }
           else -> {
                ChildViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.post_2, parent, false)
                )
            }

        }

    override fun getItemViewType(position: Int): Int {
        return item[position].type
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when {
            getItemViewType(position) == PostType.FIRST_POST -> (holder as ChildViewHolder).popMod(item[position] as PostData)
            getItemViewType(position) == PostType.SECOND_POST -> (holder as ChildViewHolder).popMod(item[position] as PostData)
          }
    }
}