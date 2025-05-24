package com.example.assessment.repository;


import com.example.assessment.model.CovidCase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CovidCaseRepository extends JpaRepository<CovidCase, Long> {
    List<CovidCase> findAllByOrderByReportDateDesc();
}