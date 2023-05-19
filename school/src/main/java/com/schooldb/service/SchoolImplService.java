package com.schooldb.service;

import com.schooldb.exception.DataAlreadyExistException;
import com.schooldb.repository.SchoolRepo;
import com.schooldb.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SchoolImplService implements SchoolService{

    @Autowired
    SchoolRepo schoolRepo;

    @Override
    public School saveSchoolData(School school) throws DataAlreadyExistException {

        Optional<School> optional= schoolRepo.findById((school.getSchoolId()));
        if(optional.isPresent()){
            throw new DataAlreadyExistException("user already exist");
        }
        return schoolRepo.save(school);
    }

    @Override
    public ArrayList<School> getAllSchooldata() {
        return (ArrayList<School>) schoolRepo.findAll();
    }

    }
