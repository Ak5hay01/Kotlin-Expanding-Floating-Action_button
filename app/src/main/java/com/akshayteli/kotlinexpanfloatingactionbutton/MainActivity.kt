package com.akshayteli.kotlinexpanfloatingactionbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val rotateOpen: Animation by lazy{ AnimationUtils.loadAnimation(this,R.anim.rotate_open)}
    private val rotateClose: Animation by lazy{ AnimationUtils.loadAnimation(this,R.anim.rotate_close)}
    private val fromBottom: Animation by lazy{ AnimationUtils.loadAnimation(this,R.anim.from_bottom)}
    private val toBottom: Animation by lazy{ AnimationUtils.loadAnimation(this,R.anim.to_bottom)}

    private var clicked = false

    lateinit var add:FloatingActionButton
    lateinit var edit:FloatingActionButton
    lateinit var search:FloatingActionButton
    lateinit var refresh:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add = findViewById<FloatingActionButton>(R.id.fab_add)
        edit = findViewById<FloatingActionButton>(R.id.fab_edit)
        refresh = findViewById<FloatingActionButton>(R.id.fab_refresh)
        search = findViewById<FloatingActionButton>(R.id.fab_search)

        add.setOnClickListener {
            onButtonClicked()
        }

        edit.setOnClickListener {
            Toast.makeText(this,"Edit button clicked",Toast.LENGTH_SHORT).show()
        }
        refresh.setOnClickListener {
            Toast.makeText(this,"Refresh button clicked",Toast.LENGTH_SHORT).show()
        }
        search.setOnClickListener {
            Toast.makeText(this,"Search button clicked",Toast.LENGTH_SHORT).show()
        }

    }

    private fun onButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)
        clicked = !clicked
    }

    private fun setVisibility(clicked:Boolean) {
        if(!clicked){
            edit.visibility = View.VISIBLE
            search.visibility = View.VISIBLE
            refresh.visibility = View.VISIBLE

        }else{
            edit.visibility = View.INVISIBLE
            search.visibility = View.INVISIBLE
            refresh.visibility = View.INVISIBLE
        }

    }

    private fun setAnimation(clicked:Boolean) {

        if(!clicked){
            edit.startAnimation(fromBottom)
            search.startAnimation(fromBottom)
            refresh.startAnimation(fromBottom)
            add.startAnimation(rotateOpen)
        }else{
            edit.startAnimation(toBottom)
            search.startAnimation(toBottom)
            refresh.startAnimation(toBottom)
            add.startAnimation(rotateClose)
        }

    }

    private fun setClickable(clicked:Boolean) {
        if(!clicked){
            edit.isClickable = true
            search.isClickable = true
            refresh.isClickable = true

        }else{
            edit.isClickable = false
            search.isClickable = false
            refresh.isClickable = false
        }

    }

}