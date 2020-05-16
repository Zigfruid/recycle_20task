package com.example.secondtrywithrecycleplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondtrywithrecycleplay.PostAdapterPackage.ChildPostAdapter
import com.example.secondtrywithrecycleplay.PostAdapterPackage.ParentAdapter
import com.example.secondtrywithrecycleplay.PostAdapterPackage.postAd
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.horizontal_recycleview.*
import kotlinx.android.synthetic.main.vertical_recycle.*

class MainActivity : AppCompatActivity() {

    private val pAdapter = ParentAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv1.adapter = pAdapter
        rv1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv1.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        fillData()
    }


    private fun fillData() {
        val massiv: MutableList<PostType> = mutableListOf()
        for (i in 1..20) {
            if (i%5==0){
                val Reklam = postAd(PostType.THIRD_POST, " ", " ")
                massiv.add(Reklam)
            }else {
                val FirstPost = PostData(PostType.FIRST_POST, " ", " ")
                massiv.add(FirstPost)
                val SecPost = SecondPost(PostType.SECOND_POST, " ", " ")
                massiv.add(SecPost)
            }
        }
        pAdapter.item = massiv
    }
}
