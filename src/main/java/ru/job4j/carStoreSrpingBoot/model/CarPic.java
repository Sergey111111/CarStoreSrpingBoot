package ru.job4j.carStoreSrpingBoot.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Car picture annotated for hibernate
 */
@Entity
@Table(name = "carpics")
@Data
public class CarPic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String filename;
}