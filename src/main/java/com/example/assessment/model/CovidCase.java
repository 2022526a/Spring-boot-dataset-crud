package com.example.assessment.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "covid_cases")
public class CovidCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "report_date")
    private LocalDate reportDate;

    private String county;

    @Column(name = "confirmed_cases")
    private Integer confirmedCases;

    @Column(name = "hospitalized_cases")
    private Integer hospitalizedCases;

    private Integer deaths;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getReportDate() { return reportDate; }
    public void setReportDate(LocalDate reportDate) { this.reportDate = reportDate; }
    public String getCounty() { return county; }
    public void setCounty(String county) { this.county = county; }
    public Integer getConfirmedCases() { return confirmedCases; }
    public void setConfirmedCases(Integer confirmedCases) { this.confirmedCases = confirmedCases; }
    public Integer getHospitalizedCases() { return hospitalizedCases; }
    public void setHospitalizedCases(Integer hospitalizedCases) { this.hospitalizedCases = hospitalizedCases; }
    public Integer getDeaths() { return deaths; }
    public void setDeaths(Integer deaths) { this.deaths = deaths; }
}