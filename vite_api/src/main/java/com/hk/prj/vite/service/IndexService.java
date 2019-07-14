package com.hk.prj.vite.service;

import java.util.List;

import com.hk.prj.vite.model.Columns;
import com.hk.prj.vite.model.Index;

public interface IndexService {
    /**
     * it will return data from elastic search system
     *
     * @param type
     * @return
     */
    Object getData(String indexName);

    /**
     * it will return all available indices in system
     * @return
     */
    List<Index> getIndices();

    /**
     * get columns of an index by indexId
     * @param indexId
     * @return
     */
    public List<Columns> getColumns(Long indexId);
}
