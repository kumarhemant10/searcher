package com.hk.prj.vite.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public interface ElasticSearchServiceImpl {

    RestHighLevelClient getHighLevelRestClient();

    JsonNode getData(String type) throws IOException;
}
