package com.hk.prj.vite.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

import javax.persistence.*;


@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@ToString
@Entity
@Table(name="config_index")
public class Index extends BaseEntity implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5143772338482241734L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="index_name")
    private String name;

    @Column(name="index_url")
    private String url;
    
    

}
