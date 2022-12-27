package com.example.bestmoviedb_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bPopular = findViewById<Button>(R.id.buttonPopular);
        val bTop = findViewById<Button>(R.id.buttonTop);
        bPopular.setOnClickListener {
            openMoviesActivity("popular");
        }
        bTop.setOnClickListener {
            openMoviesActivity("top_rated");
        }
    }


    fun openMoviesActivity(type: String){
        val intent: Intent = Intent(baseContext, MoviesActivity::class.java);
        intent.putExtra("Type", type)
        startActivity(intent);
    }
}