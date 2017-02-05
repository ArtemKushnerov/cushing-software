package com.websearch.searcher;

import com.websearch.exception.GoogleSearchException;
import com.websearch.result.Result;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class GoogleSearcher implements Searcher {
    private static final String GOOGLE = "http://www.google.com/search?q=";
    private static final String USER_AGENT = "Googlebot";
    private static final String CSS_QUERY = ".g>.r>a";

    @Override
    public Result search(String query) {
        Element firstLink = getFirstLinkReturnedByGoogle(query);
        return formResult(firstLink);
    }

    private Element getFirstLinkReturnedByGoogle(String query) {
        Element firstLink;
        try {
            firstLink = Jsoup.connect(GOOGLE + query).userAgent(USER_AGENT).get().select(CSS_QUERY).get(0);
        } catch (IOException e) {
            throw new GoogleSearchException("An error happened while searching Google", e);
        }
        return firstLink;
    }

    private Result formResult(Element link) {
        String title = link.text();
        String url = extractURL(link.absUrl("href"));

        return new Result(url, title);
    }

    private String extractURL(String url) {
        return url.substring(url.indexOf('=') + 1, url.indexOf('&'));
    }
}
