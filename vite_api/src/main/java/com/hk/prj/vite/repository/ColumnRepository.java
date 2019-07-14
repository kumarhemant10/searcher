package com.hk.prj.vite.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hk.prj.vite.model.Columns;

@Repository
public interface ColumnRepository extends JpaRepository<Columns, Long> {
    Optional<List<Columns>> findByIndexId(Long indexId);
}
