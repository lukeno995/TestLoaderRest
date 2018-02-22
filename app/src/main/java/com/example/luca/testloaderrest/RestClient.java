package com.example.luca.testloaderrest;


/**
 * Created by Luca on 13/02/2018.
 */

public class RestClient {
    private static final String BASE_URL = "https://testfirebase-8e382.firebaseio.com/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {

    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }

    private static class AsyncHttpClient {
        public void get(String absoluteUrl, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.get(getAbsoluteUrl(absoluteUrl), params, responseHandler);
        }
    }

    private static class RequestParams {
    }

    static class AsyncHttpResponseHandler {
    }
}
