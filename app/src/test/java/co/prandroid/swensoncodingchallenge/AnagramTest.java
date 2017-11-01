package co.prandroid.swensoncodingchallenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.prandroid.swensoncodingchallenge.Question2.Anagram;

/**
 * Created by dharmakshetri on 10/18/17.
 */

public class AnagramTest {
    private Anagram anagram;

    @Before
    public void setUp(){
        this.anagram = new Anagram();
    }

    @Test
    public void shoul_true_for_anagram_words(){
        Assert.assertTrue(anagram.permutation("dharma", "radmah"));
        Assert.assertTrue(anagram.permutation("debit card", "bad credit"));
    }

    @Test
    public void should_false_for_anagram_words(){
        Assert.assertFalse(anagram.permutation("debit card", "credit card"));
        Assert.assertFalse(anagram.permutation("punishment", "nine thumps"));
    }

    @Test
    public void should_false_for_empty_words(){
        Assert.assertTrue(anagram.permutation("", ""));
    }
}
