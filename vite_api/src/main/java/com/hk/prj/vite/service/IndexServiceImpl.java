package com.hk.prj.vite.service;

import java.util.List;

import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.prj.vite.model.Index;
import com.hk.prj.vite.repository.IndexRepository;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired IndexRepository ir ;

	@Override
	public List<Index> get() {
		return ir.findAll();
	}

	@Override
	public Index get(long indexId) {
		return ir.findById(indexId)
				.orElseThrow(()-> new ResourceNotFoundException("Index not found with Id = "+indexId));
	}

	@Override
	public Index save(Index index) {
		return ir.save(index);
	}

	@Override
	public void delete(long indexId) {
		ir.delete(indexId);
	}

   
}
