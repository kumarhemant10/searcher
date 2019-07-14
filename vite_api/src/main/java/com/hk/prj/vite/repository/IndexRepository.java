package com.hk.prj.vite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hk.prj.vite.model.Index;

@Repository
public interface IndexRepository extends JpaRepository<Index, Long> {

	Optional<Index> findByName(String indexName);

	Optional<Index> findById(Long indexId);
}
