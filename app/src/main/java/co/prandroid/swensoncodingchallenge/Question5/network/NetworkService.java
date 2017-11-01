package co.prandroid.swensoncodingchallenge.Question5.network;


import co.prandroid.swensoncodingchallenge.Question5.model.CurrencyExchange;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by dharmakshetri on 10/17/17.
 */
public interface NetworkService {

    @GET("/latest")
    Observable<CurrencyExchange> getCurrency();

}
