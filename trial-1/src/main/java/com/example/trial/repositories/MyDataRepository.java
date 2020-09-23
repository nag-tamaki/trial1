package com.example.trial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.trial.MyData;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long>{
//	public Optional<MyData> findById(Long name);
	@Query("SELECT d FROM MyData d ORDER BY d.name")
	List<MyData> findAllOrderByName();
}
