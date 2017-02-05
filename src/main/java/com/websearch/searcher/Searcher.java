package com.websearch.searcher;

import com.websearch.result.Result;

public interface Searcher {
    Result search(String query);
}
