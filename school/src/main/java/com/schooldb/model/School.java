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
    @Column(name="schoolId")
    private int schoolId;
    private String schoolName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emps_id", referencedColumnName = "schoolId")
    private List<Employee> employees;

}

