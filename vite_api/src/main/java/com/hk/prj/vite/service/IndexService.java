package com.hk.prj.vite.service;

import java.util.List;

import com.hk.prj.vite.model.Index;

public interface IndexService {

	List<Index> get();

	Index get(long indexId);

	Index save(Index index);

	void delete(long indexId);
    
	
}
