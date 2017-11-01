package co.prandroid.swensoncodingchallenge.Question5.acitivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import co.prandroid.swensoncodingchallenge.R
import kotlinx.android.synthetic.main.converterlayout.*
import java.text.DecimalFormat

/**
 * Created by dharmakshetri on 10/18/17.
 */

class ConvertedActivity : AppCompatActivity() {

    private var base: String? = null
    private var currencyName: String? = null
    private var currencyRate: Double = 0.toDouble()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.converterlayout)

        init()
        renderView()
        inputChangeValues()

    }

    private fun inputChangeValues() {
        editTextViewBaseValue.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (s.toString().length == 0) {
                    return
                }

                val input: Double
                try {
                    input = java.lang.Double.parseDouble(s.toString())
                } catch (e: NumberFormatException) {
                    editTextViewBaseValue.setText("")
                    return
                }


                val output = input * currencyRate
                val decimalFormat = DecimalFormat("#,###.##")
                tvConvertedValue.setText(decimalFormat.format(output))
            }
        })
    }

    private fun renderView() {
        tvBaseCurrency.text=base
        tvConvertedValue.text=currencyRate.toString()
        tvConvrtedCurrency.text=currencyName
    }

    private fun init() {
        val intent = intent
        base=intent.getStringExtra("base")
        currencyName = intent.getStringExtra("currency_name")
        currencyRate = intent.getDoubleExtra("currency_rate", 0.0)
    }
}
