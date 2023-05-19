package com.schooldb.repository;

import com.schooldb.model.Employee;
import com.schooldb.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer> {
}
