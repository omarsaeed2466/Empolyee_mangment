package com.example.empolyee_mangment.repositories;

import com.example.empolyee_mangment.Entites.Employee;
import com.example.empolyee_mangment.Entites.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TimesheetRepository extends JpaRepository<TimeSheet, Long> {

    public List<TimeSheet.Timesheet> findByEmployeeEmployeeId(long employeeId);
    public TimeSheet findTimesheetByToDateAndEmployee(LocalDate endDate, Employee employee);
    public List<TimeSheet> findTimesheetsByFromDateGreaterThanEqualAndToDateLessThanEqual(LocalDate fromDate, LocalDate toDate);
    public List<TimeSheet> findTimesheetsByFromDateGreaterThanEqualAndToDateLessThanEqualAndTimesheetStatus
            (LocalDate fromDate, LocalDate toDate, String timesheetStatus);

}
