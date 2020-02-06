package com.hk.prj.vite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.prj.vite.exception.ResourceNotFoundException;
import com.hk.prj.vite.model.Columns;
import com.hk.prj.vite.model.Index;
import com.hk.prj.vite.repository.ColumnRepository;
import com.hk.prj.vite.repository.IndexRepository;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired IndexRepository indexRepository ;

    @Autowired ColumnRepository columnRepository ;

    @Autowired IElasticSearchService elasticSearchDAO;

    public List<Index> getIndices(){
        return indexRepository.findAll();
    }

    public List<Columns> getColumns(Long indexId){
        return columnRepository.findByIndexId(indexId).orElseThrow(()-> new ResourceNotFoundException("Columns not found for index with id: "+indexId)) ;
    }

    public Object getData(String indexName){
    	Index index=indexRepository.findByName(indexName).orElseThrow(()-> new ResourceNotFoundException("Index not found with name: "+indexName));
        return elasticSearchDAO.getData(index.getUrl());
    }
}
