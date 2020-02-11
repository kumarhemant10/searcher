package com.hk.prj.vite.service;

import java.util.List;

import com.hk.prj.vite.model.Columns;

public interface ColumnService {

	List<Columns> get(long indexId);

	Columns get(long indexId, Long columnId);

	Columns save(long indexId, Columns column);

	void delete(Long indexId, Long columnId);

}
