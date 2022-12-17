package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.FIR;

@Repository
public interface FIRDao extends JpaRepository<FIR,Integer>{

}
