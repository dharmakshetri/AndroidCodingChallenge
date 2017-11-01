package co.prandroid.swensoncodingchallenge.Question5.acitivity

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import co.prandroid.swensoncodingchallenge.Question5.adapter.CurrencyAdapter
import co.prandroid.swensoncodingchallenge.Question5.model.Currency
import co.prandroid.swensoncodingchallenge.Question5.model.CurrencyExchange
import co.prandroid.swensoncodingchallenge.Question5.network.Service
import co.prandroid.swensoncodingchallenge.Question5.presenter.CurrencyPresenter
import co.prandroid.swensoncodingchallenge.Question5.ui.CurrencyView
import co.prandroid.swensoncodingchallenge.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by dharmakshetri on 10/17/17.
 */

class MainActivity : BaseActivity() , CurrencyView {

    private var recyclerview: RecyclerView? = null

    var service: Service? =null

   /* @Inject
    var view: CurrencyView?=null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        renderView()
        init()
        val presenter = CurrencyPresenter(this!!.service, this)
        presenter.getCurrency()
    }

    fun renderView() {
        setContentView(R.layout.activity_main)
        recyclerview = findViewById<RecyclerView>(R.id.recycler_view)

    }

    fun init() {
        recyclerview!!.layoutManager = LinearLayoutManager(this)
    }


    override fun showWait() {
       showProgressDialog()
    }

    override fun removeWait() {
       hideProgressDialog()
    }

    override fun onFailure(appErrorMessage: String) {
        Toast.makeText(applicationContext,"Error !!!",Toast.LENGTH_SHORT).show()
    }

    override fun getCurrencyListSuccess(currencyResponse: CurrencyExchange) {
        tvDate.text=currencyResponse!!.base
        tvBaseCurrencyMain.text=currencyResponse!!.date

        val adapter = CurrencyAdapter(applicationContext, currencyResponse,
                object : CurrencyAdapter.OnItemClickListener {
                    override fun onClick(Item: Currency?) {
                        Toast.makeText(applicationContext, Item.toString(),
                        Toast.LENGTH_LONG).show()

                        val intent = Intent(applicationContext, ConvertedActivity::class.java)
                        intent.putExtra("base",tvBaseCurrencyMain.text)
                        intent.putExtra("currency_name", Item!!.name)
                        intent.putExtra("currency_rate", Item!!.rate)


                        startActivity(intent)
                    }
                })

        recyclerview!!.adapter = adapter

    }
}
