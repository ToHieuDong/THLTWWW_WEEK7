package com.example.week7.backend.repositories;

import com.example.week7.backend.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepoditory extends JpaRepository<Employee, Long> {

}
