package com.epiousion.dao;

import java.util.List;

import com.epiousion.exception.EpiousionException;
import com.epiousion.model.Loan;


public interface LoanDAO {

    public String saveLoan(String idUser) throws EpiousionException;
    
    public void saveBookLoan(String idLoan, String idBook) throws EpiousionException;
    
    public List<Loan> getAllLoans() throws EpiousionException;
}