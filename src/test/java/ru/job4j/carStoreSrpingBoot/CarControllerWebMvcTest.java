package ru.job4j.carStoreSrpingBoot;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.carStoreSrpingBoot.controller.CarController;
import ru.job4j.carStoreSrpingBoot.model.Car;
import ru.job4j.carStoreSrpingBoot.repo.CarRepo;
import ru.job4j.carStoreSrpingBoot.repo.PicRepo;
import ru.job4j.carStoreSrpingBoot.repo.UserDetailsRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@WebMvcTest(CarController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerWebMvcTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CarRepo carRepo;

  @MockBean
  private UserDetailsRepo userDetailsRepo;

  @MockBean
  private PicRepo picRepo;

  @Test
  public void greetingShouldReturnMessageFromService() throws Exception {

    Car car = new Car();
    car.setName("Lada");
    car.setBody("Sedan");
    List<Car> cars = new ArrayList<>();
    cars.add(car);

    when(carRepo.findAll()).thenReturn(cars);
    this.mockMvc.perform(get("/car")).andDo(print()).andExpect(status().isOk())
      .andExpect(content().string(containsString("[{name:'Lada', body:'Sedan'}]")));
  }

}
