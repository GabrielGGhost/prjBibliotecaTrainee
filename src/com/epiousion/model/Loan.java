package com.epiousion.model;

import java.util.Date;

public class Loan {
	
	private int idLoan;
	private String name;
	private Date loanDate;
	private LoanBook[] loanBooks;

	public Loan(int idLoan, String name, Date loanDate) {
		super();
		this.setIdLoan(idLoan);
		this.setName(name);
		this.setLoanDate(loanDate);
		this.setLoanBooks(loanBooks);
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
	public LoanBook[] getLoanBooks() {
		return loanBooks;
	}
	public void setLoanBooks(LoanBook[] loanBooks) {
		this.loanBooks = loanBooks;
	}
}
