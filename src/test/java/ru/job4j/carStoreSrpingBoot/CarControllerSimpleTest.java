package ru.job4j.carStoreSrpingBoot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.job4j.carStoreSrpingBoot.controller.CarController;
import ru.job4j.carStoreSrpingBoot.model.Car;
import ru.job4j.carStoreSrpingBoot.repo.CarRepo;
import ru.job4j.carStoreSrpingBoot.repo.UserDetailsRepo;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarControllerSimpleTest {
  @Mock
  private UserDetailsRepo userRepo;
  @Mock
  private CarRepo carRepo;
  @InjectMocks
  private CarController controller;






  @Test
  public void whenGetCarsThenGot() {
    Car car = new Car();
    car.setName("Lada");
    car.setBody("Sedan");
    List<Car> cars = new ArrayList<>();
    cars.add(car);

    when(carRepo.findAll()).thenReturn(cars);
    System.out.println(controller.list().get(0).getName());
    verify(carRepo).findAll();
    assertNotNull(controller.list());
  }

}
