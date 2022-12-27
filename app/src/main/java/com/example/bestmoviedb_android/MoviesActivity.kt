package com.example.bestmoviedb_android


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesActivity : AppCompatActivity() {


    private lateinit var movieList: ArrayList<Movie>
    lateinit var intentValue: String
    lateinit var retrofitClient: RetrofitClient
    lateinit var recyclerView: RecyclerView
    lateinit var progressBar : ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        intentValue = intent.getStringExtra("Type").toString()
        retrofitClient = RetrofitClient(intentValue)
        recyclerView = findViewById(R.id.recyclerView)
        fetchPosts();

    }

    private fun inflateRecyclerview(movieList: List<Movie>){
        val moviesAdapter: MoviesAdapter = MoviesAdapter(movieList, baseContext)
        recyclerView.layoutManager = LinearLayoutManager(baseContext)
        recyclerView.adapter = moviesAdapter


    }

    private fun fetchPosts() {
        val retrofitData: Call<JsonResponse> = retrofitClient.getRetroFitClient().getData(intentValue)

        //Progress bar
        progressBar = findViewById(R.id.progressBar);
        retrofitData.enqueue(object : Callback<JsonResponse?> {
            override fun onResponse(call: Call<JsonResponse?>, response: Response<JsonResponse?>) {
                val jsonResponse: JsonResponse = response.body()!!
                movieList = jsonResponse.results
                inflateRecyclerview(movieList)
                progressBar.visibility = View.GONE;

            }

            override fun onFailure(call: Call<JsonResponse?>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }
        })


        }
    }