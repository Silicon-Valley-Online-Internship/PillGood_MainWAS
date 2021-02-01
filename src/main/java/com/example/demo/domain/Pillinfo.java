package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Pillinfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String pillname;

    @Column(nullable = false)
    private String effect;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String engrave;

    @Column(nullable = false)
    private String sideeffect;

    @Column(nullable = false)
    private String url;

    @Builder
    public Pillinfo(String pillname, String effect, String company,
                    String engrave, String sideeffect, String url) {
        this.pillname = pillname;
        this.effect = effect;
        this.company = company;
        this.engrave = engrave;
        this.sideeffect = sideeffect;
        this.url = url;
    }

    public void update(String pillname, String effect, String company,
                            String engrave, String sideeffect, String url) {
        this.pillname = pillname;
        this.effect = effect;
        this.company = company;
        this.engrave = engrave;
        this.sideeffect = sideeffect;
        this.url = url;
    }
}
