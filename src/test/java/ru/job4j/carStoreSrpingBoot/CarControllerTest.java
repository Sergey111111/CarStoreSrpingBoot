package ru.job4j.carStoreSrpingBoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.carStoreSrpingBoot.controller.CarController;
import ru.job4j.carStoreSrpingBoot.model.Car;
import ru.job4j.carStoreSrpingBoot.repo.CarRepo;
import ru.job4j.carStoreSrpingBoot.repo.PicRepo;
import ru.job4j.carStoreSrpingBoot.repo.UserDetailsRepo;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@WebMvcTest(CarController.class)
@SpringBootTest
@AutoConfigureMockMvc

public class CarControllerTest {


  @Autowired
  private MockMvc mvc;

  @MockBean
  private CarRepo carRepo;
  @MockBean
  private UserDetailsRepo userDetailsRepo;
  @MockBean
  private PicRepo picRepo;

  @Test
  public void contexLoads() throws Exception {
    assertThat(mvc).isNotNull();
  }

  @Test
  public void WhenGetRequestThanResponseJson() throws Exception {
    Car car = new Car();
    car.setName("Lada");
    car.setBody("Sedan");
    String content = "[{name:'Lada', body:'Sedan'}]";
    given(this.carRepo.findAll()).willReturn(Collections.singletonList(car));
    this.mvc.perform(get("/car").accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk()).andExpect(content().json(content));
  }
}
