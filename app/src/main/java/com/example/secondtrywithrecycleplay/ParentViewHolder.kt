package com.example.secondtrywithrecycleplainner

import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.secondtrywithrecycleplay.PostAdapterPackage.ChildPostAdapter
import com.example.secondtrywithrecycleplay.PostData
import com.example.secondtrywithrecycleplay.PostType
import kotlinx.android.synthetic.main.horizontal_recycleview.view.*
import kotlinx.android.synthetic.main.vertical_recycle.view.*
import java.util.*

class ParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var adapter: ChildPostAdapter = ChildPostAdapter()
    fun populateModel(data: PostType) {
        itemView.rv_horizontal.adapter = adapter
        itemView.rv_horizontal.layoutManager =
            LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
        itemView.rv_horizontal.addItemDecoration(DividerItemDecoration(itemView.context, DividerItemDecoration.HORIZONTAL))
        fillDataWithRandom()
    }

    private fun fillDataWithRandom(){
        val random = Random().nextInt()
        if (random%2 == 0){
            fillData()
        }else{
            fillSecDat()
        }
    }

    private fun fillData() {
        val massiv: MutableList<PostType> = mutableListOf()
        for (i in 1..20) {
            val firstPost = PostData(PostType.FIRST_POST, " ", " ")
            massiv.add(firstPost)
            val secondPost = PostData(PostType.SECOND_POST, " ", " ")
            massiv.add(secondPost)

        }
        adapter.item = massiv
    }
    private fun fillSecDat(){
        val massiv: MutableList<PostType> = mutableListOf()
        for (i in 1..20) {
            val secondPost = PostData(PostType.SECOND_POST, " ", " ")
            massiv.add(secondPost)
            val firstPost = PostData(PostType.FIRST_POST, " ", " ")
            massiv.add(firstPost)
        }
        adapter.item = massiv
    }
}