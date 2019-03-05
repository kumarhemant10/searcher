package com.hk.prj.vite.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor

@Entity
@Table(name="columns")
public class Columns {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="index_id")
    private Long indexId;
    @Column(name="column_display_name")
    private String columnDisplayName;
    @Column(name="column_name")
    private String columnName;
    @Column(name="search")
    private byte search;
    @Column(name="display")
    private byte display;
    @Column(name="active")
    private byte active;

}
