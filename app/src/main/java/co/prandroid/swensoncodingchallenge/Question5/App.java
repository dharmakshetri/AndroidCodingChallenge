package co.prandroid.swensoncodingchallenge.Question5;

import android.app.Application;

import co.prandroid.swensoncodingchallenge.Question5.network.AppModule;


/**
 * Created by dharmakshetri on 10/17/17.
 */

public class App extends Application {
    private static App instance;

    public static App getInstance() {
        return instance;
    }

    protected AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }


    public AppComponent getAppComponent() {
        return appComponent;
    }
}
