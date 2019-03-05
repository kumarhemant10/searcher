package com.hk.prj.vite.service;

import com.hk.prj.vite.model.Columns;
import com.hk.prj.vite.model.Index;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface IndexService {
    /**
     * it will return data from elastic search system
     *
     * @param type
     * @return
     */
    Object getData(String type);

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
