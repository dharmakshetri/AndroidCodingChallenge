package co.prandroid.swensoncodingchallenge.Question5.network;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dharmakshetri on 10/17/17.
 */

@Module
public class AppModule {
    Application application;


    public AppModule(Application application) {
        this.application = application;
    }


    @Provides
    @Singleton
    @ForApplication
    Context provideContext() {
        return application;
    }
}
