package com.schooldb.controller;

import com.schooldb.exception.DataAlreadyExistException;
import com.schooldb.model.School;
import com.schooldb.service.SchoolService;
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

    @PostMapping("/add")
    public ResponseEntity<School> saveSchoolData(@RequestBody School school) throws DataAlreadyExistException{

        School savedSchool = schoolService.saveSchoolData(school);
        return new ResponseEntity<School>(savedSchool, HttpStatus.CREATED);
    }

    @GetMapping("/all")

    public ArrayList<School> getAllSchool(){

       return schoolService.getAllSchooldata();

    }
}

