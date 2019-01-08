package ru.job4j.carStoreSrpingBoot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Advertisement
 */
@Entity
@Table(name = "cars")
@Data
public class Car implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String text;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private User user;
  private String color;
  private String engine;
  private String body;
  private boolean sold;
  private Integer price;

  @Column(updatable = false)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  LocalDateTime creationDate;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "car_id")
  private List<CarPic> pics;
}
