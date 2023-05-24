package com.schooldb.service;

import com.schooldb.exception.DataAlreadyExistException;
import com.schooldb.model.Employee;
import com.schooldb.model.School;
import com.schooldb.repository.EmpRepo;
import com.schooldb.repository.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolImplService implements SchoolService {

    @Autowired
    SchoolRepo schoolRepo;

    @Autowired
    EmpRepo empRepo;

    @Override
    public School saveSchoolData(School school) throws DataAlreadyExistException {
        boolean emp_exist = false;
        Optional<School> optional = schoolRepo.findById((school.getSchoolId()));
        if (optional.isPresent()) {
            ArrayList<Integer> emp_ids = new ArrayList<>();
            List<Employee> emp = school.getEmployees();
            for (Employee id : emp) {
                Optional<Employee> ids = empRepo.findById(id.getEmpId());
                if (ids.isPresent()) {
                    System.out.println("emp already exist" + id.getEmpId());
                    emp_exist = true;
                } else {
                    return schoolRepo.save(school);
                }
            }
        }
        if (emp_exist) {
            throw new DataAlreadyExistException("User already exist");
        }
        return schoolRepo.save(school);

    }


    @Override
    public ArrayList<School> getAllSchooldata() {
        return (ArrayList<School>) schoolRepo.findAll();
    }

    @Override
    public ArrayList<School> getbyStateCode(String stateCode) {

        return schoolRepo.findByStateCode(stateCode);
    }
}