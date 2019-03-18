package com.lokal.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.lokal.Model.Article;
import com.lokal.Model.ArticleBO;
import io.dropwizard.elasticsearch.managed.ManagedEsClient;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.RequestLine;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.node.NodeBuilder;

import java.io.IOException;
import java.util.Map;

public class ArticleESClient {
    private RestClient restClient;
    ObjectMapper objectMapper;


    public ArticleESClient() {
    }

    public ArticleESClient(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;

        restClient = RestClient.builder(
                new HttpHost("localhost", 9200, "http"),
                new HttpHost("localhost", 9201, "http")).build();


    }

    public String getObject() throws IOException {
        Request request = new Request(
                "GET",
                "/");

        request.addParameter("pretty", "true");
        request.setEntity(new NStringEntity(
                "{\"json\":\"text\"}",
                ContentType.APPLICATION_JSON));

        Response response = restClient.performRequest(request);

        RequestLine requestLine = response.getRequestLine();
        HttpHost host = response.getHost();
        int statusCode = response.getStatusLine().getStatusCode();
        Header[] headers = response.getHeaders();
        String responseBody = EntityUtils.toString(response.getEntity());

        return responseBody;
    }

    public Map<Object, Object> indexObject(ArticleBO article) {

        return Maps.newHashMap();
    }
}
