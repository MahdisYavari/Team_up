package com.example.teamup.view.features.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.teamup.R

class ActivityBase : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}