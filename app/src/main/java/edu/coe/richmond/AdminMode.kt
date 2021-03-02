package edu.coe.richmond

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AdminMode : AppCompatActivity() {

    var addBtn: Button? = null
    var deleteBtn: Button? = null
    var updateBtn: Button? = null
    var db:SQLHelper? = null
    var foodResult: TextView? = null
    var editTextFoodName: EditText? = null
    var editTextPrice: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adminmode)
        initView(this)
    }

    private fun initView(c: Context){
        addBtn = findViewById<Button>(R.id.addBtn)
        deleteBtn = findViewById<Button>(R.id.deleteBtn)
        updateBtn = findViewById<Button>(R.id.updateBtn)
        foodResult = findViewById<TextView>(R.id.foodResult)
        editTextFoodName  = findViewById<EditText>(R.id.editTextFoodName)
        editTextPrice = findViewById<EditText>(R.id.editTextPrice)
        db = SQLHelper(c)
            val data = db!!.readData()
            foodResult!!.text = ""
            for (i in 0 until data.size) {
                foodResult!!.append(
                        data[i].name + " " + data[i].price + "\n"
                )
            }
    }

    fun Insert(v: View){
        if (editTextFoodName!!.text.toString().isNotEmpty() &&
                editTextPrice!!.text.toString().isNotEmpty()
        ) {
            val item = Item(editTextFoodName!!.text.toString(), editTextPrice!!.text.toString().toInt())
            db!!.insertData(item)
            clearField()
        }
        else {
            Toast.makeText(this, "Please Fill All Data", Toast.LENGTH_SHORT).show()
        }
        val data = db!!.readData()
        foodResult!!.text = ""
        for (i in 0 until data.size) {
            foodResult!!.append(
                    data[i].name + " " + data[i].price + "\n"
            )
        }
    }

    fun Read(v:View){
        val data = db!!.readData()
        foodResult!!.text = ""
        for (i in 0 until data.size) {
            foodResult!!.append(
                    data[i].name + " " + data[i].price + "\n"
            )
        }
    }
    fun updateData(v: View) {
        if (editTextFoodName!!.text.toString().isNotEmpty() && editTextPrice!!.text.toString().isNotEmpty()) {
            val item = Item(editTextFoodName!!.text.toString(), editTextPrice!!.text.toString().toInt())
            db!!.updateData(item)
            clearField()
        }
        val data = db!!.readData()
        foodResult!!.text = ""
        for (i in 0 until data.size) {
            foodResult!!.append(
                    data[i].name + " " + data[i].price + "\n"
            )
        }
    }
    fun deleteData(v: View) {
        if (editTextFoodName!!.text.toString().isNotEmpty() && editTextPrice!!.text.toString().isNotEmpty()) {
            val item = Item(editTextFoodName!!.text.toString(), editTextPrice!!.text.toString().toInt())
            db!!.deleteData(item)
            clearField()
        }
        val data = db!!.readData()
        foodResult!!.text = ""
        for (i in 0 until data.size) {
            foodResult!!.append(
                    data[i].name + " " + data[i].price + "\n"
            )
        }
    }
    private fun clearField() {
        editTextFoodName!!.text.clear()
        editTextPrice!!.text.clear()
    }

    fun ClearDB(v:View){
        db!!.clearDB()
        foodResult!!.text = ""
        }

    fun goBack(v: View) {
        this.finish()
    }
}

