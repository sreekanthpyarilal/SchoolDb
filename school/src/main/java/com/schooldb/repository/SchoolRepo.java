package com.schooldb.repository;

import com.schooldb.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SchoolRepo extends JpaRepository<School, Integer> {
    public ArrayList<School> findByStateCode(String schoolCode);


}
