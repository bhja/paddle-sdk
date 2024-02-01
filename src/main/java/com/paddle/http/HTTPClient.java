package com.paddle.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import java.util.Map;

public class HTTPClient {
    private final HttpClient client;
    public static final int DEFAULT_CONNECT_TIMEOUT = 30 * 1000;
    public static final int DEFAULT_READ_TIMEOUT = 80 * 1000;
    private final String apiKey;
    private int readTimeOut ;



    public HTTPClient(HTTPConfig config) {
        client =
                HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).followRedirects(HttpClient.Redirect.NORMAL)
                          .connectTimeout(Duration.ofSeconds(config.getConnectionTimeOut()>0?
                                                                     config.getConnectionTimeOut():
                                                                     DEFAULT_CONNECT_TIMEOUT))
                          .build();
        this.readTimeOut = config.getReadTimeOut();
        this.apiKey = config.getApiKey();
    }


    /**
     * Appends the query parameters to the url.
     * @param uri
     * @param queryParams
     * @return
     */
    public URI queryParameters(String uri, Map<String, String> queryParams) {
        try {
            URI oldURI = new URI(uri);
            StringBuilder builder = new StringBuilder();
            queryParams.forEach((key, value) -> builder.append("&").append(key).append("=").append(value));
            return new URI(oldURI.getScheme(), oldURI.getAuthority(), oldURI.getPath(),
                           oldURI.getQuery() == null ? builder.substring(1) : oldURI.getQuery() + builder, oldURI.getFragment());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param uri
     * @param method
     * @param bodyPublisher
     * @return
     */
    public HttpRequest request(URI uri, String method,
                               HttpRequest.BodyPublisher bodyPublisher) {
        return request(uri, getHeaders(), method, bodyPublisher);
    }

    public HttpRequest request(URI uri, Map<String, String> headers, String method,
                               HttpRequest.BodyPublisher bodyPublisher) {
        HttpRequest.Builder request = HttpRequest.newBuilder().
                                                 uri(URI.create(uri.toString())).
                                                 timeout(Duration.ofMinutes(readTimeOut>0?readTimeOut: DEFAULT_READ_TIMEOUT));
        headers.forEach(request::header);
        request.method(method, bodyPublisher);
        return request.build();
    }


    public HttpResponse<String> execute(HttpRequest request,
    HttpResponse.BodyHandler<String> bodyHandler) throws InterruptedException,
            IOException {
        return client.send(request, bodyHandler);
    }


    private Map<String, String> getHeaders() {
        return Map.of("Authorization", "Bearer " + this.apiKey,
                      "Content-Type", "application/json",
                      "Accept", "application/json");


    }


}
