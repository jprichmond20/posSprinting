package edu.coe.richmond

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isNotEmpty


class MainActivity : AppCompatActivity() {

    var db:SQLHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.poslayout)
        initView(this)
        }

    override fun onStart() {
        super.onStart()
        val data = db!!.readData()
        var scroller = findViewById<View>(R.id.scroller) as LinearLayout
        while (scroller.isNotEmpty()) {
            scroller.removeAllViews()
        }
        for (i in 0 until data.size) {
            var name = data[i].foodName.toString()
            var price = data[i].foodPrice.toString()
            addControl(this, name, price)
        }
    }
    private fun initView(c: Context) {
        db = SQLHelper(c)
        var costText: TextView? = findViewById(R.id.costText)
    }
    fun launchActivity(v: View) {
        var myIntent = Intent(this, AdminMode::class.java)
        startActivity(myIntent)
    }

    fun addControl(v: MainActivity, name: String, price: String) {
        //Log.i("add control", "control added here")
        var scroller = findViewById<View>(R.id.scroller) as LinearLayout
        var newControl = UpDownBox(this as Context)
        newControl.foodText = name + " " + price
        scroller.addView(newControl)
    }

    }