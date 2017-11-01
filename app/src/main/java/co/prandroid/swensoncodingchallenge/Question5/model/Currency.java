package co.prandroid.swensoncodingchallenge.Question5.model;

/**
 * Created by dharmakshetri on 10/17/17.
 */
public class Currency {
    private String name;
    private double rate;

    public Currency(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }
}
