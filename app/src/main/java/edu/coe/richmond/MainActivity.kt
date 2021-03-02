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
    private fun initView(c: Context) {
        db = SQLHelper(c)
    }
    fun launchActivity(v: View) {
        var myIntent = Intent(this, AdminMode::class.java)
        startActivity(myIntent)
    }

    fun addControl(v: View){
        var scroll = findViewById<View>(R.id.scrollingll) as LinearLayout
        var leftItem = findViewById<View>(R.id.editLeft) as EditText
        var rightItem = findViewById<View>(R.id.editRight)as EditText

        // Toast.makeText(this,item.text.toString(), Toast.LENGTH_LONG).show()
        var newControl = UpDownBox(this)
        newControl.leftOption = leftItem!!.text.toString()
        newControl.rightOption = rightItem!!.text.toString()

        scroll.addView(newControl)
    }

    }