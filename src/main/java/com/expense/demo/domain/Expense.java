package com.expense.demo.domain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String title;
	private String description;
	@Min(1)
	private int amount;
	/*
	 * private int month; private int year;
	 */
	@Past(message="Date cannot be in the future")
	private Date date;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;
	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

	@Override
	public String toString() {
		return "Expense [id=" + id + ", title=" + title + ", description=" + description + ", amount=" + amount
				+ ", date=" + date + ", category=" + category + ", user=" + user + "]";
	}
	
	
}
