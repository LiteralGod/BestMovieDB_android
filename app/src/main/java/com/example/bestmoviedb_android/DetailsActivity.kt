package com.example.bestmoviedb_android

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val image = findViewById<ImageView>(R.id.details_imageView);
        val textTitle = findViewById<TextView>(R.id.details_title);
        val textOverview = findViewById<TextView>(R.id.details_overview);
        val intentTitle = intent.getStringExtra("title");
        val intentOverview = intent.getStringExtra("overview");
        val intentImage = intent.getStringExtra("image")


        Glide.with(baseContext).load("https://image.tmdb.org/t/p/original" + intentImage.toString())
            .into(image)
        textTitle.text = intentTitle
        textOverview.text = intentOverview




    }
}