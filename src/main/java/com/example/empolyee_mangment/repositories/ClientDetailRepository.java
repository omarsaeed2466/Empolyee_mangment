package com.example.empolyee_mangment.repositories;

import com.example.empolyee_mangment.Entites.ClientDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface ClientDetailRepository extends JpaRepository<ClientDetail, Long> {
    List<ClientDetail> findAllByEmployeeEmployeeIdOrderByCreatedAtDesc(long employeeId);
}
