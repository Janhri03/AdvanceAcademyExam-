package com.SpringProjectMavenJan.SpringProjectMavenJan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "workers")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private Double salary;

    @Column(unique = true)
    private String EGN;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Job job;

}
