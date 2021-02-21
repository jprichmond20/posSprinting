package edu.coe.richmond

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.poslayout)
        }
    fun launchActivity(v: View) {
        var myIntent = Intent(this, AdminMode::class.java)
        startActivity(myIntent)
    }
    }