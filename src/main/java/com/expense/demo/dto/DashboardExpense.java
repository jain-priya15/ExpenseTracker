package com.expense.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Date;

public class DashboardExpense {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM-yyyy")
	private String monthAndYear;
	private long amount;
	public String getMonthAndYear() {
		return monthAndYear;
	}
	public void setMonthAndYear(String monthAndYear) {
		this.monthAndYear = monthAndYear;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public DashboardExpense(String monthAndYear, long amount) {
		super();
		this.monthAndYear = monthAndYear;
		this.amount = amount;
	}
	
	
	

}
