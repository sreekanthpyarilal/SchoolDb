package com.schooldb.service;

import com.schooldb.exception.DataAlreadyExistException;
import com.schooldb.model.School;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface SchoolService {

    public School saveSchoolData(School school) throws DataAlreadyExistException;

    public ArrayList<School> getAllSchooldata();

    public ArrayList<School> getbyStateCode(String stateCode);

}
