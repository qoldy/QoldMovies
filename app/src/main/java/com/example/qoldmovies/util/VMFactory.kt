package com.example.qoldmovies.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.qoldmovies.mvvm.viewmodels.MoviesVM

class VMFactory: ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MoviesVM::class.java))
            return MoviesVM() as T;
        throw IllegalArgumentException ("UnknownViewModel")
    }
}