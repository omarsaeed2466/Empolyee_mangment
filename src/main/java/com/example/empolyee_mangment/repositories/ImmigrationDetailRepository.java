package com.example.empolyee_mangment.repositories;

import com.example.empolyee_mangment.Entites.ImmigrationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(readOnly = true)
public interface ImmigrationDetailRepository extends JpaRepository<ImmigrationDetail, Long> {
    List<ImmigrationDetail> findAllByEmployeeEmployeeId(long employeeId);
}
