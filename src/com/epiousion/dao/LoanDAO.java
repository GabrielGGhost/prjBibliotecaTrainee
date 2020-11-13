package com.epiousion.dao;

import java.util.Date;
import java.util.List;

import com.epiousion.exception.EpiousionException;
import com.epiousion.model.Loan;
import com.epiousion.model.LoanBook;


public interface LoanDAO {

    public String saveLoan(String idUser) throws EpiousionException;
    
    public void saveBookLoan(String idLoan, String idBook) throws EpiousionException;
    
    public List<Loan> getAllLoans() throws EpiousionException;
    
    public List<Loan> getUserLoans(int id) throws EpiousionException;
    
    //Lista todos os livros empréstados de um usuário
    public List<LoanBook> getUserLoanBooks(int id) throws EpiousionException;
    
    //Lista todos os livros de um empréstimo de um usuário
    public List<LoanBook> getUserBooksLoan(int id) throws EpiousionException;

    public List<LoanBook> getLoansOfTheDay() throws EpiousionException;
    
    public Date getTodayDate() throws EpiousionException;
    
    public LoanBook getSelectedLoan(int id) throws EpiousionException;

	public void receiveBook(int id) throws EpiousionException;
}