package com.example.demo.domain;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NutinfoRepositoryTest {

    @Autowired
    NutinfoRepository nutinfoRepository;

    @After
    public void cleanup() {
        nutinfoRepository.deleteAll();
    }

    @Test
    public void addData_load() {
        //given
        String foodName = "Test name";
        String calories = "Test calories";
        String carbohydrate = "Test carbo";
        String protein = "Test protein";
        String fat = "Test fat";

        nutinfoRepository.save(Nutinfo.builder()
                                .foodname(foodName)
                                .calories(calories)
                                .carbohydrate(carbohydrate)
                                .protein(protein)
                                .fat(fat)
                                .build());

        //when
        List<Nutinfo> nutinfoList = nutinfoRepository.findAll();

        //then
        Nutinfo nutinfo = nutinfoList.get(0);
        assertThat(nutinfo.getFoodname()).isEqualTo(foodName);
        assertThat(nutinfo.getCalories()).isEqualTo(calories);
        assertThat(nutinfo.getCarbohydrate()).isEqualTo(carbohydrate);
        assertThat(nutinfo.getProtein()).isEqualTo(protein);
        assertThat(nutinfo.getFat()).isEqualTo(fat);
    }
}
