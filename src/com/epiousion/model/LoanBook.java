package com.epiousion.model;

import java.util.Date;

public class LoanBook {
	
	private int idLoanBook;
	private int idBook;
	private Date devolutionDate;
	private Date returnedDate;
	
	public LoanBook(int idLoanBook, int idBook, Date devolutionDate, Date returnedDate) {
		super();
		this.setIdLoanBook(idLoanBook);
		this.setIdBook(idBook);
		this.setDevolutionDate(devolutionDate);
		this.setReturnedDate(returnedDate);
	}
	
	public int getIdLoanBook() {
		return idLoanBook;
	}
	public void setIdLoanBook(int idLoanBook) {
		this.idLoanBook = idLoanBook;
	}
	public int getIdBook() {
		return idBook;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	public Date getDevolutionDate() {
		return devolutionDate;
	}
	public void setDevolutionDate(Date devolutionDate) {
		this.devolutionDate = devolutionDate;
	}
	public Date getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}
}
