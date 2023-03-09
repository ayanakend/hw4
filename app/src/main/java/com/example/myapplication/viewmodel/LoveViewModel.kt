package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.remote.LoveModel
import com.example.myapplication.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    fun getLiveLove(firstName:String, secondName:String): LiveData<LoveModel> {
        return repository.getLove(firstName, secondName)
    }
}