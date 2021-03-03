package edu.coe.richmond

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import android.database.sqlite.SQLiteStatement as SQLiteStatement1

val DATABASENAME = "MY DATABASE"
val TABLENAME = "Items"
val COL_NAME = "name"
val COL_PRICE = "price"
val COL_ID = "id"
class SQLHelper(var context: Context) : SQLiteOpenHelper(context, DATABASENAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        createTable(db)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    private fun createTable(db:SQLiteDatabase?) {
        val createTable =
                "CREATE TABLE " + TABLENAME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NAME + " VARCHAR(256)," + COL_PRICE + " INTEGER)"
        db?.execSQL(createTable)
    }

    fun insertData(item:Item) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_NAME, item.name)
        contentValues.put(COL_PRICE, item.price)
        //Log.i("Price", item.price.toString())
        val result = database.insert(TABLENAME, null, contentValues)
        if (result == (0).toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }
    fun readData(): MutableList<Item> {
        val list: MutableList<Item> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLENAME"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                val item = Item()
                item.name = result.getString(result.getColumnIndex(COL_NAME)).toString()
                item.price = result.getString(result.getColumnIndex(COL_PRICE)).toDouble()
                list.add(item)
            }
            while (result.moveToNext())
        }
        return list
    }
    fun updateData(item: Item): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_NAME, item.name)
        contentValues.put(COL_PRICE, item.price)
        db.update(TABLENAME, contentValues, "NAME = ?", arrayOf(item.name))
        return true
    }
    fun deleteData(item: Item): Int {
        val db = this.writableDatabase
        return db.delete(TABLENAME, "NAME = ?", arrayOf(item.name))
    }
    fun clearDB(){
        val db = this.readableDatabase
        val dropTable = "DROP TABLE IF EXISTS "+ TABLENAME
        db.execSQL(dropTable)
        createTable(db)
    }
}