package com.expense.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
/**
 * 
 * @author Priya
 *
 */
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String name;
}
