package com.hk.prj.vite.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ElasticSearchService implements ElasticSearchServiceImpl {

    @Value("${elasticsearch.url}")
    String e_url;

    @Override
    public RestHighLevelClient getHighLevelRestClient() {
        RestHighLevelClient restClient = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200)
                )
        );
        return restClient;
    }

    @Override
    public JsonNode getData(String type) throws IOException {
        JsonNode data =null;
        RestHighLevelClient restHighLevelClient = getHighLevelRestClient();

        //TODO: Query dsl can be prepared and added here
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //prepare search request
        SearchRequest searchRequest = new SearchRequest();

        //set index to search request
        searchRequest.indices(type.split(","));
        //set query to search request
        searchRequest.source(searchSourceBuilder);

        //perform search
        try {
            SearchResponse res = restHighLevelClient.search(searchRequest);
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readTree(res.toString().getBytes("UTF-8"));

        } catch (IOException e) {
            //log exception
            e.printStackTrace();
        }
        finally {
            //close client resource
            restHighLevelClient.close();
        }
        return data;
    }
}
