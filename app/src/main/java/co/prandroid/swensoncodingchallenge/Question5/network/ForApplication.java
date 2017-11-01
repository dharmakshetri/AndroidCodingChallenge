package co.prandroid.swensoncodingchallenge.Question5.network;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by dharmakshetri on 10/17/17.
 */

@Qualifier
@Retention(RUNTIME)
public @interface ForApplication {
}
