package co.prandroid.swensoncodingchallenge.Question5.presenter


import co.prandroid.swensoncodingchallenge.Question5.model.CurrencyExchange
import co.prandroid.swensoncodingchallenge.Question5.network.Service
import co.prandroid.swensoncodingchallenge.Question5.ui.CurrencyView
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

/**
 * Created by dharmakshetri on 10/17/17.
 */
class CurrencyPresenter( private val service: Service?, private val view: CurrencyView) {
    private val subscriptions: CompositeSubscription
    @Inject
    private var services:Service? = service

    init {
        this.subscriptions = CompositeSubscription()

    }

    fun getCurrency() {
        view.showWait()

        val subscription = services!!.getCurrency(object : Service.GetCurrencyCallback {
            override fun onSuccess(currencyExchange: CurrencyExchange) {
                view.removeWait()
                view.getCurrencyListSuccess(currencyExchange)
            }

            override fun onError(networkError: String) {
                view.removeWait()
                view.onFailure("data could not get")
            }

        })

        subscriptions.add(subscription)
    }

    fun onStop() {
        subscriptions.unsubscribe()
    }
}
