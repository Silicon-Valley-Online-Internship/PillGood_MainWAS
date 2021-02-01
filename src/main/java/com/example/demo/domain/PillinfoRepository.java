package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface PillinfoRepository extends JpaRepository<Pillinfo, Long> {

    Pillinfo findByPillname(@Param("pillname") String pillname);
}
