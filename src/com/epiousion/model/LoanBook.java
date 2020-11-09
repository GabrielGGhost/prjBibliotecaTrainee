package com.epiousion.model;

import java.util.Date;

public class LoanBook {
	
	private int idLoanBook;
	private int idLoan;
	private int idBook;
	private Date devolutionDate;
	private Date returnedDate;
	private Date loanDate;
	private String title;
	
	public LoanBook(int idLoanBook, int idBook, Date devolutionDate, Date returnedDate) {
		super();
		this.setIdLoanBook(idLoanBook);
		this.setIdBook(idBook);
		this.setDevolutionDate(devolutionDate);
		this.setReturnedDate(returnedDate);
	}
	
	public LoanBook(int idLoanBook, int idLoan, int idBook, Date devolutionDate, Date returnedDate, Date loanDate, String title) {
		this.setIdLoanBook(idLoanBook);
		this.setIdLoan(idLoan);
		this.setIdBook(idBook);
		this.setDevolutionDate(devolutionDate);
		this.setReturnedDate(returnedDate);
		this.setLoanDate(loanDate);
		this.setTitle(title);
	}

	public int getIdLoanBook() {
		return this.idLoanBook;
	}
	public void setIdLoanBook(int idLoanBook) {
		this.idLoanBook = idLoanBook;
	}
	public int getIdBook() {
		return this.idBook;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	public Date getDevolutionDate() {
		return this.devolutionDate;
	}
	public void setDevolutionDate(Date devolutionDate) {
		this.devolutionDate = devolutionDate;
	}
	public Date getReturnedDate() {
		return this.returnedDate;
	}
	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}
	public int getIdLoan() {
		return this.idLoan;
	}
	public void setIdLoan(int idLoan) {
		this.idLoan = idLoan;
	}
	public Date getLoanDate() {
		return this.loanDate;
	}
	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
