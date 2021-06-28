package com.example.qoldmovies.mvvm.views

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.qoldmovies.R

class EntryActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entry_activity)
        init()
    }

    private fun init(){
        val intent = Intent(this,MoviesActivity::class.java)
        object : CountDownTimer(3000, 3000){
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                startActivity(intent)
            }
        }.start()
    }
}