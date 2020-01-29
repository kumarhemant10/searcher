package com.hk.prj.vite.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor

@Entity
@Table(name="config_columns")
public class Columns extends BaseEntity implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5968104684585583169L;

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
    private boolean search;
    
    @Column(name="display")
    private boolean display;
    
    @Column(name="active")
    private boolean active;

}
