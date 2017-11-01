package co.prandroid.swensoncodingchallenge.Question5;




import javax.inject.Singleton;

import co.prandroid.swensoncodingchallenge.Question5.network.AppModule;
import co.prandroid.swensoncodingchallenge.Question5.network.NetworkModule;
import dagger.Component;

/**
 * Created by dharmakshetri on 10/17/17.
 */
@Singleton
@Component(modules = {NetworkModule.class,AppModule.class})
public interface AppComponent {
    void inject(App mainActivity);
}
