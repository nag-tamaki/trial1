package com.example.trial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trial.MyData;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long>{

}
