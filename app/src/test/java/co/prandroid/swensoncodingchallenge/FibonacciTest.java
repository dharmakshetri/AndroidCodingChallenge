package co.prandroid.swensoncodingchallenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.prandroid.swensoncodingchallenge.Question3.Fibonacci;

/**
 * Created by dharmakshetri on 10/18/17.
 */

public class FibonacciTest {
    private Fibonacci fibonacci;

    @Before
    public void setUp(){
        this.fibonacci = new Fibonacci();
    }

    @Test
    public void should_return_correct_nth_fibonacciNumber_recurssive(){
        Assert.assertEquals(1, fibonacci.recursiveMethod(1));
        Assert.assertEquals(1, fibonacci.recursiveMethod(2));
        Assert.assertEquals(5, fibonacci.recursiveMethod(5));
        Assert.assertEquals(144, fibonacci.recursiveMethod(12));
        Assert.assertNotEquals(144, fibonacci.recursiveMethod(11));
    }

    @Test
    public void should_return_correct_nth_fibonacciNumber_iterative(){
        Assert.assertEquals(1, fibonacci.iterativeMethod(1));
        Assert.assertEquals(1, fibonacci.iterativeMethod(2));
        Assert.assertEquals(5, fibonacci.iterativeMethod(5));
        Assert.assertEquals(144, fibonacci.iterativeMethod(12));
        Assert.assertNotEquals(144, fibonacci.iterativeMethod(11));
    }
}
