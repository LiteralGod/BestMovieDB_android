package com.example.bestmoviedb_android

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MoviesAdapter(var movieList: List<Movie>, var context: Context): RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {


    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val movieTitle: TextView
        val movieImage: ImageView

        init{
            movieTitle = view.findViewById(R.id.movieTitle)
            movieImage = view.findViewById(R.id.movieImage)
        }
 }

    override fun getItemCount(): Int {
       return movieList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(context).inflate(R.layout.list_item,parent, false)
        return ViewHolder(view);
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.movieTitle.text = movieList[position].title
        Glide.with(context).load("https://image.tmdb.org/t/p/original" + movieList[position].poster_path)
            .into(holder.movieImage)


        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("title", movieList[position].title)
            intent.putExtra("overview", movieList[position].overview)
            intent.putExtra("image", movieList[position].poster_path)
            holder.itemView.context.startActivity(intent)
        }
    }
}

