package com.prevoty.smartfilter.client;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class SmartFilterClient {
    private String apiBase;
    private String apiKey;

    public SmartFilterClient(String apiKey) {
        this.apiKey = apiKey;
        this.apiBase = "https://api.prevoty.com/1";
    }

    // Endpoint: /key/verify
    public boolean Verify() throws NetworkException, BadInputParameterException, BadApiKeyException, AccountQuotaException, RequestTooLargeException {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            String url = this.apiBase + "/key/verify";
            HttpGet request = new HttpGet(url);
            URI uri = new URIBuilder(request.getURI()).addParameter("api_key", this.apiKey).build();
            request.setURI(uri);
            HttpResponse response = httpClient.execute(request);
            switch (response.getStatusLine().getStatusCode()) {
                case 200:
                    return true;
                case 400:
                    throw new BadInputParameterException();
                case 403:
                    throw new BadApiKeyException();
                case 413:
                    throw new RequestTooLargeException();
                case 500:
                    throw new InternalError();
                case 507:
                    throw new AccountQuotaException();
                default:
                    throw new NetworkException();
            }
        } catch (ClientProtocolException e) {
            throw new BadApiKeyException();
        } catch (IOException e) {
            throw new NetworkException();
        } catch (URISyntaxException e) {
            throw new NetworkException();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    // Endpoint: /key/info
    public InfoResult Info() throws NetworkException, BadInputParameterException, BadApiKeyException, AccountQuotaException, RequestTooLargeException {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            String url = this.apiBase + "/key/info";
            HttpGet request = new HttpGet(url);
            URI uri = new URIBuilder(request.getURI()).addParameter("api_key", this.apiKey).build();
            request.setURI(uri);
            HttpResponse response = httpClient.execute(request);

            ResponseHandler<String> handler = new BasicResponseHandler();
            String body = handler.handleResponse(response);

            switch (response.getStatusLine().getStatusCode()) {
                case 200:
                    Gson gson = new Gson();
                    return gson.fromJson(body, InfoResult.class);
                case 400:
                    throw new BadInputParameterException();
                case 403:
                    throw new BadApiKeyException();
                case 413:
                    throw new RequestTooLargeException();
                case 500:
                    throw new InternalError();
                case 507:
                    throw new AccountQuotaException();
                default:
                    throw new NetworkException();
            }
        } catch (ClientProtocolException e) {
            throw new BadApiKeyException();
        } catch (IOException e) {
            throw new NetworkException();
        } catch (URISyntaxException e) {
            throw new NetworkException();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    // Endpoint: /key/info
    public boolean VerifyRule(String ruleKey) throws NetworkException, BadInputParameterException, BadApiKeyException, AccountQuotaException, RequestTooLargeException {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            String url = this.apiBase + "/rule/verify";
            HttpGet request = new HttpGet(url);
            URI uri = new URIBuilder(request.getURI()).addParameter("api_key", this.apiKey).addParameter("rule_key", ruleKey).build();
            request.setURI(uri);
            HttpResponse response = httpClient.execute(request);

            switch (response.getStatusLine().getStatusCode()) {
                case 200:
                    return true;
                case 400:
                    throw new BadInputParameterException();
                case 403:
                    throw new BadApiKeyException();
                case 413:
                    throw new RequestTooLargeException();
                case 500:
                    throw new InternalError();
                case 507:
                    throw new AccountQuotaException();
                default:
                    throw new NetworkException();
            }
        } catch (ClientProtocolException e) {
            throw new BadApiKeyException();
        } catch (IOException e) {
            throw new NetworkException();
        } catch (URISyntaxException e) {
            throw new NetworkException();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    // Endpoint: /xss/filter
    public FilterResult Filter(String input, String ruleKey) throws NetworkException, BadInputParameterException, BadApiKeyException, AccountQuotaException, RequestTooLargeException {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            String url = this.apiBase + "/xss/filter";
            HttpPost request = new HttpPost(url);

            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("api_key", this.apiKey));
            nvps.add(new BasicNameValuePair("rule_key", ruleKey));
            nvps.add(new BasicNameValuePair("input", input));
            request.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

            HttpResponse response = httpClient.execute(request);

            ResponseHandler<String> handler = new BasicResponseHandler();
            String body = handler.handleResponse(response);

            switch (response.getStatusLine().getStatusCode()) {
                case 200:
                    Gson gson = new Gson();
                    return gson.fromJson(body, FilterResult.class);
                case 400:
                    throw new BadInputParameterException();
                case 403:
                    throw new BadApiKeyException();
                case 413:
                    throw new RequestTooLargeException();
                case 500:
                    throw new InternalError();
                case 507:
                    throw new AccountQuotaException();
                default:
                    throw new NetworkException();
            }
        } catch (ClientProtocolException e) {
            throw new BadApiKeyException();
        } catch (IOException e) {
            throw new NetworkException();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    // Endpoint: /url/results
    public UrlInformation UrlResults(String urlIdentifier) throws NetworkException, BadInputParameterException, BadApiKeyException {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            String url = this.apiBase + "/url/results";
            HttpGet request = new HttpGet(url);
            URI uri = new URIBuilder(request.getURI()).addParameter("api_key", this.apiKey).addParameter("url", urlIdentifier).build();
            request.setURI(uri);

            HttpResponse response = httpClient.execute(request);
            ResponseHandler<String> handler = new BasicResponseHandler();
            String body = handler.handleResponse(response);

            switch (response.getStatusLine().getStatusCode()) {
                case 200:
                    Gson gson = new Gson();
                    return gson.fromJson(body, UrlInformation.class);
                case 400:
                    throw new BadInputParameterException();
                case 403:
                    throw new BadApiKeyException();
                case 500:
                    throw new InternalError();
                default:
                    throw new NetworkException();
            }
        } catch (ClientProtocolException e) {
            throw new BadApiKeyException();
        } catch (IOException e) {
            throw new NetworkException();
        } catch (URISyntaxException e) {
            throw new NetworkException();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }
}
