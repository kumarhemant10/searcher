package com.hk.prj.vite.controller;


import com.hk.prj.vite.constant.UrlConstants;
import com.hk.prj.vite.model.Columns;
import com.hk.prj.vite.model.Index;
import com.hk.prj.vite.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * rest controller for data apis
 */
@CrossOrigin
@RestController
public class IndexController {

    @Autowired IndexService indexService;

    @GetMapping(UrlConstants.GET_INDICES)
    public ResponseEntity<List<Index>> getTypes(){
        List<Index> indices= null;
        indices= indexService.getIndices();
        return new ResponseEntity<>(indices,HttpStatus.OK);
    }

    @GetMapping(UrlConstants.GET_COLUMNS)
    public ResponseEntity<List<Columns>> getColumns(@PathVariable("indexId") Long indexId){
        List<Columns> columns= null;
        columns= indexService.getColumns(indexId);
        return new ResponseEntity<>(columns,HttpStatus.OK);
    }

    @PostMapping(UrlConstants.GET_DATA_BYTYPE)
    public ResponseEntity<Object> searchData(@PathVariable("index") String type){
        Object data= indexService.getData(type);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

}
