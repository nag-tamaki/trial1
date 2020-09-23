package com.example.trial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trial.MsgData;

@Repository
public interface MsgDataRepository extends JpaRepository<MsgData, Long> {

}
