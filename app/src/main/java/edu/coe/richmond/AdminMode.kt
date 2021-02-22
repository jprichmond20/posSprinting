package edu.coe.richmond

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AdminMode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adminmode)
        //val i = intent
        //val txt = i.extras!!.getString("TEXT")
        //val txtBox = findViewById<TextView>(R.id.IntentTxt)
        //txtBox.text = txt

    }

    fun goBack(v: View) {
        this.finish()
    }
}

