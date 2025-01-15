package com.hahn.assessment.rabat.model;

import com.hahn.assessment.rabat.model.enums.EmploymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Getter @Setter
public class Employee extends AbstractEntity{
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "employment_status", nullable = false)
    private EmploymentStatus status;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contact_id")
    @MapsId
    private Contact contact;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "user_id")
    @MapsId
    private User user;

    public String getFullName() {
        return String.join(" ", firstName, lastName);
    }

}