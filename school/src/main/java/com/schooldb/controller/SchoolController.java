package com.schooldb.controller;

import com.schooldb.exception.DataAlreadyExistException;
import com.schooldb.exception.DataMissingException;
import com.schooldb.model.School;
import com.schooldb.service.SchoolService;
import com.schooldb.validation.SchoolValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/college")
public class SchoolController {
    @Autowired
    SchoolService schoolService;
    SchoolValidation validate = new SchoolValidation();

    @PostMapping("/add")
    public ResponseEntity<School> saveSchoolData(@RequestHeader(name = "stateCode", required = true) String stateCode, @RequestBody School school) throws DataAlreadyExistException, DataMissingException {

        if (validate.IsSchoolDataPresent(school)) {
            school.setStateCode(stateCode);
            School savedSchool = schoolService.saveSchoolData(school);
            System.out.println(savedSchool.getStateCode());
            return new ResponseEntity<School>(savedSchool, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/all")
    public ArrayList<School> getAllSchool() {
        return schoolService.getAllSchooldata();
    }

    @GetMapping("/{stateCode}")
    public ArrayList<School> getbyStatecode(@PathVariable String stateCode) {
        return schoolService.getbyStateCode(stateCode);
    }
}

