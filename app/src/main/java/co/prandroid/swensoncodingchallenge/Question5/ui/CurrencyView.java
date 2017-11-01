package co.prandroid.swensoncodingchallenge.Question5.ui;


import co.prandroid.swensoncodingchallenge.Question5.model.CurrencyExchange;

/**
 * Created by dharmakshetri on 10/17/17.
 */
public interface CurrencyView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getCurrencyListSuccess(CurrencyExchange currencyExchange);

}
