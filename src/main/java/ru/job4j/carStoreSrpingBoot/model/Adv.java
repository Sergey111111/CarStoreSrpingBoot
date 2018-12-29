package ru.job4j.carStoreSrpingBoot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Advertisement
 */
@Entity
@Table(name = "advs")
@Data
public class Adv implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.IdName.class)
    private Long id;
    @JsonView(Views.IdName.class)
    private String text;
//    @ManyToOne
//    @JoinTable(name = "advs_usr",
//            joinColumns = @JoinColumn(name = "adv_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    private Set<User> users;
//    @OneToOne
//    @JoinColumn(name="id")
//    private Car car;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(Views.FullAdv.class)
    LocalDateTime creationDate;
}