package com.websearch.searcher;

import com.websearch.result.Result;
import org.junit.Test;

public class GoogleSearcherTest {
    @Test
    public void search() throws Exception {
        Result result = new GoogleSearcher().search("");
        System.out.println(result);
    }

}