package com.example.bestmoviedb_android

import com.google.gson.annotations.SerializedName

class JsonResponse(
    @SerializedName("results")
    var results: ArrayList<Movie>)
