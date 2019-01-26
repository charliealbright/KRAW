package com.jankapotamus.kraw.api

import com.jankapotamus.kraw.model.Listing
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RedditService {

    @GET("/{sort}.json")
    fun theFrontPage(@Path("sort") sortString: String): Call<Listing>
}