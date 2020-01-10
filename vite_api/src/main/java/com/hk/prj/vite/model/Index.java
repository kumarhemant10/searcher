package com.hk.prj.vite.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor

@Entity
@Table(name="config_index")
public class Index {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="index_name")
    private String name;

    @Column(name="index_url")
    private String url;

}
