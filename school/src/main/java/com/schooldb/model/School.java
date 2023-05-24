package com.schooldb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "School")
public class School {

    @Id
    @Column(name = "schoolId")
    private int schoolId;
    private String schoolName;
    private String schoolCode;
    private String stateCode;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fn_schoolId", referencedColumnName = "schoolId")
    private List<Employee> employees;

}

