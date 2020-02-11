package com.hk.prj.vite.controller;

import static com.hk.prj.vite.constant.UrlConstants.COLUMNS;
import static com.hk.prj.vite.constant.UrlConstants.COLUMNS_BY_ID;

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

import com.hk.prj.vite.model.Columns;
import com.hk.prj.vite.service.ColumnService;

@CrossOrigin
@RestController
public class ColumnController {
	
	@Autowired ColumnService cs;
	
	@GetMapping(COLUMNS)
    public ResponseEntity<List<Columns>> get(@PathVariable("id") long indexId){
        return new ResponseEntity<>(cs.get(indexId),HttpStatus.OK);
    }

	@GetMapping(COLUMNS_BY_ID)
    public ResponseEntity<Columns> get(@PathVariable("id") long indexId, @PathVariable("id") Long columnId){
        return new ResponseEntity<>(cs.get(indexId, columnId),HttpStatus.OK);
    }
	
	@PostMapping(COLUMNS)
    public ResponseEntity<Columns> save(@PathVariable long indexId, @RequestBody Columns column){
        return new ResponseEntity<>(cs.save(indexId, column),HttpStatus.CREATED);
    }
	
	@DeleteMapping(COLUMNS_BY_ID)
    public ResponseEntity<?> delete(@PathVariable("id") long indexId, @PathVariable("id") Long columnId){
		cs.delete(indexId, columnId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
