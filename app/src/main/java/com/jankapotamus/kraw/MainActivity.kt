package com.jankapotamus.kraw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jankapotamus.kraw.api.RedditService
import com.jankapotamus.kraw.databinding.ActivityMainBinding
import com.jankapotamus.kraw.model.Listing
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var retrofit = Retrofit.Builder()
            .baseUrl("https://www.reddit.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var reddit = retrofit.create(RedditService::class.java)

        var apiCall = reddit.theFrontPage("best")
        apiCall.enqueue(object: Callback<Listing> {
            override fun onFailure(call: Call<Listing>, t: Throwable) {
            }

            override fun onResponse(call: Call<Listing>, response: Response<Listing>) {
                mBinding.test.text = response.body()?.kind
            }
        })
    }
}
