package edu.coe.pos3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clearButton: Button = findViewById(R.id.clearButton)
        val burgDown: Button = findViewById(R.id.burgDown)
        val burgUp: Button = findViewById(R.id.burgUp)
        val candyDown: Button = findViewById(R.id.candyDown)
        val candyUp: Button = findViewById(R.id.candyUp)
        val sodaDown: Button = findViewById(R.id.sodaDown)
        val sodaUp: Button = findViewById(R.id.sodaUp)
        val hotdogDown: Button = findViewById(R.id.hotdogDown)
        val hotdogUp: Button = findViewById(R.id.hotdogUp)
        val totalCost: TextView = findViewById(R.id.totalCost)
        val burgerQty: TextView = findViewById(R.id.burgerQty)
        val candyQty: TextView = findViewById(R.id.candyQty)
        val sodaQty: TextView = findViewById(R.id.sodaQty)
        val hotdogQty: TextView = findViewById(R.id.hotdogQty)
        var `val1` = burgerQty.text.toString().toInt()
        var `val2` = candyQty.text.toString().toInt()
        var `val3` = sodaQty.text.toString().toInt()
        var `val4` = hotdogQty.text.toString().toInt()
        var total = 0

        clearButton.setOnClickListener {
            burgerQty.text = "0"
            candyQty.text = "0"
            sodaQty.text = "0"
            hotdogQty.text = "0"
            totalCost.text = "0"
        }
        
        burgDown.setOnClickListener {
            `val1`--
            burgerQty.text = `val1`.toString()
            if (`val1` >= 0) {
                total = totalCost.text.toString().toInt()
                totalCost.text = (total - 3).toString()
            }
        }
        burgUp.setOnClickListener {
            `val1`++
            burgerQty.text = `val1`.toString()
            if (`val1` >= 0) {
                total = totalCost.text.toString().toInt()
                totalCost.text = (total + 3).toString()
            }
        }
            candyDown.setOnClickListener {
                `val2`--
                candyQty.text = `val2`.toString()
                if (`val2` >= 0) {
                    total = totalCost.text.toString().toInt()
                    totalCost.text = (total - 2).toString()
                }
            }
            candyUp.setOnClickListener {
                `val2`++
                candyQty.text = `val2`.toString()
                if (`val2` >= 0) {
                    total = totalCost.text.toString().toInt()
                    totalCost.text = (total + 2).toString()
                }
            }
            sodaDown.setOnClickListener {
                `val3`--
                sodaQty.text = `val3`.toString()
                if (`val3` >= 0) {
                    total = totalCost.text.toString().toInt()
                    totalCost.text = (total - 2).toString()
                }
            }
            sodaUp.setOnClickListener {
                `val3`++
                sodaQty.text = `val3`.toString()
                if (`val3` >= 0) {
                    total = totalCost.text.toString().toInt()
                    totalCost.text = (total + 2).toString()
                }
            }
            hotdogDown.setOnClickListener {
                `val4`--
                hotdogQty.text = `val4`.toString()
                if (`val4` >= 0) {
                    total = totalCost.text.toString().toInt()
                    totalCost.text = (total - 3).toString()
                }
            }
            hotdogUp.setOnClickListener {
                `val4`++
                hotdogQty.text = `val4`.toString()
                if (`val4` >= 0) {
                    total = totalCost.text.toString().toInt()
                    totalCost.text = (total + 3).toString()
                }
            }

        }
    }