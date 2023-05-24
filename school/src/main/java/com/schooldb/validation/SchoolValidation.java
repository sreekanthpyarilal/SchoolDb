package com.schooldb.validation;

import com.schooldb.exception.DataMissingException;
import com.schooldb.model.School;

public class SchoolValidation {

    public boolean IsSchoolDataPresent(School school) throws DataMissingException {

        boolean checked = false;
        if (school.getSchoolCode() == null) {
            throw new DataMissingException("Missing School Code");
        } else if (school.getSchoolName() == null) {
            throw new DataMissingException("Missing School Name");
        } else {
            return checked = true;
        }
    }
}
