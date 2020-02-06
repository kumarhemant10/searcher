package com.hk.prj.vite.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ElasticSearchService implements IElasticSearchService {

    @Value("${elasticsearch.host}")
    private String eHOST;

	@Override
	public Object getData(String index) {
		// TODO connect to elastic instance
		
		// TODO get data from index by query
		
		return null;
	}

    
}
