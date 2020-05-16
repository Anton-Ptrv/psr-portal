package com.rined.psr.portal.auth;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Disabled
public class AuthenticationTest {

    private BasicCookieStore createCookie(String domain, String cookies) {
        BasicCookieStore cookieStore = new BasicCookieStore();
        BasicClientCookie cookie = new BasicClientCookie("JSESSIONID", cookies);
        cookie.setDomain(domain);
        cookie.setPath("/");
        cookieStore.addCookie(cookie);
        return cookieStore;
    }

    private Optional<BasicCookieStore> getCookie(String loginUrl, String login, String password, String domain) throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(loginUrl);

            String json = "{\"login\": \"admin\", \"password\": \"admin\"}";
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-type", "application/json");

            try (CloseableHttpResponse response = client.execute(httpPost)) {
                for (Header header : response.getAllHeaders()) {
                    if (header.getName().equals("Set-Cookie")) {
                        String cookieValue = header.getValue();
                        if (cookieValue.startsWith("JSESSIONID=")) {
                            String sessionId = cookieValue.substring("JSESSIONID=".length(), cookieValue.indexOf(";"));
                            return Optional.of(createCookie(domain, sessionId));
                        }
                    }
                }
            }
        }
        return Optional.empty();
    }


    public void getPsr() throws IOException {
        Optional<BasicCookieStore> cookie =
                getCookie("http://localhost:8080/login", "dev", "dev", "localhost");

        if (cookie.isPresent()) {
            HttpClient client = HttpClientBuilder.create().setDefaultCookieStore(cookie.get()).build();
            HttpGet httpGet = new HttpGet("http://localhost:8080/psr/api/psr");
            HttpResponse response = client.execute(httpGet);
            String collect = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
                    .lines().collect(Collectors.joining("\n"));
            System.out.println(collect);
        }
    }

    @Test
    void apacheHttpAuthenticationTest() throws IOException {
        Optional<BasicCookieStore> cookie =
                getCookie("http://localhost:8080/login", "admin", "admin", "localhost");
    }

    @Test
    void requestOnly() throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("http://localhost:8080/login");

            String json = "{\"login\": \"admin\", \"password\": \"admin\"}";
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-type", "application/json");

            try (CloseableHttpResponse response = client.execute(httpPost)) {
                System.out.println(response.getStatusLine());
            }
        }
    }
}
