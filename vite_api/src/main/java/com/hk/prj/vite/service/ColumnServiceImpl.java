package com.hk.prj.vite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.prj.vite.exception.ResourceNotFoundException;
import com.hk.prj.vite.model.Columns;
import com.hk.prj.vite.repository.ColumnRepository;

@Service
public class ColumnServiceImpl implements ColumnService {

	@Autowired ColumnRepository cr;
	
	@Override
	public List<Columns> get(long indexId) {
		return cr.findByIndexId(indexId)
				.orElseThrow(()-> new ResourceNotFoundException("Columns not found for index with id: "+indexId)) ;
	}

	@Override
	public Columns get(long indexId, Long columnId) {
		return cr.findByIndexIdAndId(indexId, columnId)
				.orElseThrow(()-> new ResourceNotFoundException("Columns not found for index id with id: "+indexId +", columnId: "+columnId)) ;
	}

	@Override
	public Columns save(long indexId, Columns column) {
		return cr.save(column);
	}

	@Override
	public void delete(Long indexId, Long columnId) {
		cr.delete(columnId);
	}

}
