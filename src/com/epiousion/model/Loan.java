package com.epiousion.model;

import java.util.Date;

public class Loan {
	
	private int idLoan;
	private String name;
	private Date loanDate;
	private int quantity;
	
	public Loan(int idLoan, String name, Date loanDate) {
		this.setName(name);
		this.setIdLoan(idLoan);
		this.setLoanDate(loanDate);
	}
	
	public Loan(int idLoan, Date loanDate, int quantity) {
		super();
		this.setIdLoan(idLoan);
		this.setLoanDate(loanDate);
		this.setQuantity(quantity);
	}
	
	public int getIdLoan() {
		return this.idLoan;
	}
	public void setIdLoan(int idLoan) {
		this.idLoan = idLoan;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Date getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	//public LoanBook[] getLoanBooks() {
	//	return loanBooks;
	//}
	//public void setLoanBooks(LoanBook[] loanBooks) {
	//	this.loanBooks = loanBooks;
	//}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
