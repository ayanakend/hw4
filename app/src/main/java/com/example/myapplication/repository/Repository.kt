package com.example.myapplication.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.remote.LoveApi
import com.example.myapplication.remote.LoveModel
import com.example.myapplication.remote.LoveService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi){
    fun getLove(firstName:String, secondName: String): MutableLiveData<LoveModel>{
        val  liveLoveData = MutableLiveData<LoveModel>()

        api.calculatePercentage(firstName, secondName).enqueue(object :Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    liveLoveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "error" )
            }
        })
        return liveLoveData
    }

}