package edu.coe.richmond

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.view.View
import android.content.Context
import android.widget.EditText
import android.widget.LinearLayout


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
        //foodResult!!.text = ""
        for (i in 0 until data.size) {
            foodResult!!.append(data[i].name + " " + data[i].price + "\n")
        }
    }
    private fun initView(c: Context) {
        db = SQLHelper(c)
    }
    fun launchActivity(v: View) {
        var myIntent = Intent(this, AdminMode::class.java)
        startActivity(myIntent)
    }

    fun addControl(v: View){
        var scroller = findViewById<View>(R.id.scroller) as LinearLayout
        var txtValue = findViewById<TextView>(R.id.txtValue)
        var downButton = findViewById<Button>(R.id.downButton)
        var upButton = findViewById<Button>(R.id.upButton)

        // Toast.makeText(this,item.text.toString(), Toast.LENGTH_LONG).show()
        var newControl = UpDownBox(this)

        scroller.addView(newControl)
    }

    }