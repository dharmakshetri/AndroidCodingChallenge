package co.prandroid.swensoncodingchallenge.Question5.network;


import android.util.Log;

import co.prandroid.swensoncodingchallenge.Question5.model.CurrencyExchange;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by dharmakshetri on 10/17/17.
 */
public class Service {
    private final NetworkService networkService;

    public Service(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription getCurrency(final GetCurrencyCallback callback) {

        return networkService.getCurrency()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext (new Func1<Throwable, Observable<? extends CurrencyExchange>>() {
                    @Override
                    public Observable<? extends CurrencyExchange> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<CurrencyExchange>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CurrencyExchange currencyExchange) {
                        Log.e("EEEEEEE",currencyExchange.toString());
                        callback.onSuccess(currencyExchange);
                    }
                });

    }

    public interface GetCurrencyCallback{
        void onSuccess(CurrencyExchange currencyExchange);

        void onError(String networkError);
    }
}
