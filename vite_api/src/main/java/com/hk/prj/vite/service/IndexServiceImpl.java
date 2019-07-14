package com.hk.prj.vite.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.hk.prj.vite.exception.ResourceNotFoundException;
import com.hk.prj.vite.model.Columns;
import com.hk.prj.vite.model.Index;
import com.hk.prj.vite.repository.ColumnRepository;
import com.hk.prj.vite.repository.IndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired IndexRepository indexRepository ;

    @Autowired ColumnRepository columnRepository ;

    @Autowired ElasticSearchServiceImpl elasticSearchDAO;

    public List<Index> getIndices(){
        return indexRepository.findAll();
    }

    public List<Columns> getColumns(Long indexId){
        return columnRepository.findByIndexId(indexId).orElseThrow(()-> new ResourceNotFoundException("Columns not found for index with id: "+indexId)) ;
    }

    public Object getData(String indexName){
    	
    	Index index=indexRepository.findByName(indexName).orElseThrow(()-> new ResourceNotFoundException("Index not found with name: "+indexName));
    	
        JsonNode data = null;
        try {
            data = elasticSearchDAO.getData(index.getUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
