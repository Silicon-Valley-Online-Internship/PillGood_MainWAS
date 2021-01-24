package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface NutinfoRepository extends JpaRepository<Nutinfo, Long> {

    Nutinfo findByFoodname(@Param("foodname") String foodname);
}
