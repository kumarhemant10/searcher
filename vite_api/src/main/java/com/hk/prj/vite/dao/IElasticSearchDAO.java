package com.hk.prj.vite.dao;

import com.fasterxml.jackson.databind.JsonNode;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public interface IElasticSearchDAO {

    RestHighLevelClient getHighLevelRestClient();

    JsonNode getData(String type) throws IOException;
}
