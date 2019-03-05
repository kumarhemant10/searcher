package com.hk.prj.vite.repository;

import com.hk.prj.vite.model.Columns;
import com.hk.prj.vite.model.Index;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColumnRepository extends JpaRepository<Columns, Long> {
    List<Columns> findByIndexId(Long indexId);
}
