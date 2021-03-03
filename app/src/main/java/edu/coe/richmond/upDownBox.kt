package edu.coe.richmond

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class UpDownBox : LinearLayout, View.OnClickListener {
    private var mDownButton: Button? = null
    private var mUpButton: Button? = null
    private var mValue: TextView? = null
    private var startVal = 0
    private var foodVal: TextView? = null
    private var startFood = "Candy"

    constructor(context: Context) : super(context) {
        initializeViews(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initializeViews(context)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.UpDownBox)
        startVal = ta.getInt(R.styleable.UpDownBox_startVal, 0)
        ta.recycle()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initializeViews(context)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.UpDownBox)
        startVal = ta.getInt(R.styleable.UpDownBox_startVal, 0)
        // mValue.setText(((Integer)startVal).toString());
        ta.recycle()
    }

    private fun initializeViews(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.updownbox, this)
        mDownButton = findViewById<View>(R.id.downButton) as Button
        mUpButton = findViewById<View>(R.id.upButton) as Button
        mValue = findViewById<View>(R.id.txtValue) as TextView
        mValue!!.text = startVal.toString()
        mDownButton!!.setOnClickListener(this)
        mUpButton!!.setOnClickListener(this)
        foodVal = findViewById<View>(R.id.foodTxt) as TextView
        foodVal!!.text = startFood.toString()
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    var value: Int
        get() = mValue!!.text.toString().toInt()
        set(v) {
            mValue!!.text = v.toString()
        }

    override fun onClick(v: View) {
        var `val` = mValue!!.text.toString().toInt()
        when (v.id) {
            R.id.downButton -> `val`--
            R.id.upButton -> `val`++
        }
        mValue!!.text = `val`.toString()
    }
    var foodText: String
        get() = foodVal!!.text.toString()
        set(v) {
            foodVal!!.text = v.toString()
        }
}