package com.example.empolyee_mangment.repositories;

import com.example.empolyee_mangment.Entites.Employee;
import com.example.empolyee_mangment.constants.QueryProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EmpolyeeRepo extends JpaRepository<Employee, Long> {
    Employee findEmployeeByEmployeeEmailId(String emailId);

    int countEmployeeByEmployeeEmailId(String emailId);

    int countEmployeeByEmployeeEmailIdAndEmpPassword(String emailId, String password);

    @Modifying
    @Query(QueryProperties.updatePassword)
    int updatePassword(@Param("password") String password, @Param("emailId") String emailId);

    @Modifying
    @Query(QueryProperties.updateEmployeeProfileByEmpId)
    int updateEmployeeProfile(@Param("employeeFirstName") String employeeFirstName,
                              @Param("employeeLastName") String employeeLastName,
                              @Param("employeeTitle") String employeeTitle,
                              @Param("employeePhone") String employeePhone,
                              @Param("employeeId") long employeeId);

    @Modifying
    @Query(QueryProperties.updateStaffProfileByEmpId)
    int updateStaffProfile(@Param("employeeFirstName") String employeeFirstName,
                           @Param("employeeLastName") String employeeLastName,
                           @Param("employeeTitle") String employeeTitle,
                           @Param("employeePhone") String employeePhone,
                           @Param("employeeId") long employeeId);
}
