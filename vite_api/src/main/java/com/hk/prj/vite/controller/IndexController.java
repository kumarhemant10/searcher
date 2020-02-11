package com.hk.prj.vite.controller;


import static com.hk.prj.vite.constant.UrlConstants.INDICES;
import static com.hk.prj.vite.constant.UrlConstants.INDICES_BY_ID;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hk.prj.vite.model.Index;
import com.hk.prj.vite.service.IndexService;

/**
 * rest controller for data apis
 */
@CrossOrigin
@RestController
public class IndexController {

    @Autowired IndexService is;

    @GetMapping(INDICES)
    public ResponseEntity<List<Index>> get(){
        List<Index> indices= null;
        indices= is.get();
        return new ResponseEntity<>(indices,HttpStatus.OK);
    }
    
    @GetMapping(INDICES_BY_ID)
    public ResponseEntity<Index> get(@PathVariable("id") long indexId){
        return new ResponseEntity<>(is.get(indexId),HttpStatus.OK);
    }
    
    @PostMapping(INDICES)
    public ResponseEntity<Index> save(@RequestBody Index index){        
        return new ResponseEntity<>(is.save(index),HttpStatus.OK);
    }
    
    @DeleteMapping(INDICES_BY_ID)
    public ResponseEntity<?> delete(@PathVariable("id") long indexId){   
    	is.delete(indexId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
