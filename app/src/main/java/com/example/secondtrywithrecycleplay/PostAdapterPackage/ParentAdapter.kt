package com.example.secondtrywithrecycleplay.PostAdapterPackage

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.secondtrywithrecycleplainner.ParentViewHolder
import com.example.secondtrywithrecycleplay.PostData
import com.example.secondtrywithrecycleplay.PostType
import com.example.secondtrywithrecycleplay.R
import com.example.secondtrywithrecycleplay.SecondPost

class ParentAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var item: List<PostType> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int): Int {
        return item[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        if(viewType == PostType.FIRST_POST){
            view = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_recycleview, parent, false)
            return ParentViewHolder(view)
        }else if (viewType == PostType.SECOND_POST){
            view = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_recycleview, parent, false)
            return SecondPostViewHolder(view)
        }else {
            view = LayoutInflater.from(parent.context).inflate(R.layout.post_ad,parent, false)
            return PostAdViewHolder(view)
        }
}


    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when {
            getItemViewType(position) == PostType.FIRST_POST -> {
                (holder as ParentViewHolder).populateModel(item[position])

            }
            getItemViewType(position) == PostType.SECOND_POST -> {
                (holder as SecondPostViewHolder).popMod2(item[position] as SecondPost)
            }
            else -> {
                (holder as PostAdViewHolder).pop2Mod(item[position] as postAd)
            }
        }
       }





}