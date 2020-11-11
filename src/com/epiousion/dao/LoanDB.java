package com.epiousion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.epiousion.exception.EpiousionException;
import com.epiousion.exception.LoginFailedException;
import com.epiousion.model.Book;
import com.epiousion.model.Loan;
import com.epiousion.model.LoanBook;
import com.epiousion.model.User;

public class LoanDB implements LoanDAO {

    private final String INSERT_LOAN = "CALL sp_saveLoan(?)";
    private final String INSERT_LOAN_BOOK = "CALL sp_saveLoanBook(?,?)";
    private final String GET_ALL_LOANS = "CALL sp_getAllLoans";
    private final String GET_USER_LOANS = "CALL sp_getUserLoans(?)";
    private final String GET_USER_LOAN_BOOKS = "CALL sp_getUserLoanBooks(?)";
    private final String GET_USER_BOOKS_LOAN = "CALL sp_getUserBooksLoan(?)";

    @Override
    public String saveLoan(String idUser) throws EpiousionException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement prepStmt = null;
        String idLoan = null;

        try {
        	conn = DataSourceConnection.getConexao();
            prepStmt = conn.prepareStatement(INSERT_LOAN);
            prepStmt.setString(1, idUser);
            rs = prepStmt.executeQuery();
            while(rs.next()){
            	idLoan = rs.getString("idLoan");
            }
        } catch (SQLException e) {
            String msg = "[ProdutosDB][save(Produto p)]: " + e.getMessage();
            EpiousionException ge = new EpiousionException(msg, e);
            throw ge;
        } finally {
        	DataSourceConnection.closeAll(conn, prepStmt, rs);
        }
        return idLoan;
    }
    
    @Override
    public void saveBookLoan(String idLoan, String idBook) throws EpiousionException {
        Connection conn = null;
        PreparedStatement prepStmt = null;

        try {
        	conn = DataSourceConnection.getConexao();
            prepStmt = conn.prepareStatement(INSERT_LOAN_BOOK);
            prepStmt.setString(1, idLoan);
            prepStmt.setString(2, idBook);

            prepStmt.execute();
           
        } catch (SQLException e) {
            String msg = "[ProdutosDB][save(Produto p)]: " + e.getMessage();
            EpiousionException ge = new EpiousionException(msg, e);
            throw ge;
        } finally {
        	DataSourceConnection.closeAll(conn, prepStmt);
        }
    }
    
    public List<Loan> getAllLoans() throws EpiousionException{
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	List<Loan> loanList = new ArrayList<Loan>();
    	
    	try{
    		conn = DataSourceConnection.getConexao();
    		stmt = conn.createStatement();
    		rs = stmt.executeQuery(GET_ALL_LOANS);
    		while(rs.next()){
    			
    			int idLoan = rs.getInt("idLoan");
    			String name = rs.getString("name");
    			Date loanDate = rs.getDate("loanDate");
    			
    			Loan loan = new Loan(idLoan, name, loanDate);
    			loanList.add(loan);
    		}
    	} catch (SQLException e) {
            e.printStackTrace();
            throw new EpiousionException("Erro ao buscar livros", e);
        } finally {
        	DataSourceConnection.closeAll(conn, stmt, rs);
        }
    	return loanList;
    }
    
    public List<Loan> getUserLoans(int id) throws EpiousionException{
    	Connection conn = null;
    	PreparedStatement prepStmt = null;
    	ResultSet rs = null;
    	List<Loan> loanList = new ArrayList<Loan>();
    	
    	try{
    		conn = DataSourceConnection.getConexao();
    		prepStmt = conn.prepareStatement(GET_USER_LOANS);
    		prepStmt.setInt(1, id);
    		
    		rs = prepStmt.executeQuery();
    		while(rs.next()){
    			
    			int idLoan = rs.getInt("idLoan");
    			Date loanDate = rs.getDate("loanDate");
    			int quantity = rs.getInt("quantityBooks");
    			
    			Loan loan = new Loan(idLoan, loanDate, quantity);
    			loanList.add(loan);
    		}
    		
    	} catch (SQLException e) {
            e.printStackTrace();
            throw new EpiousionException("Erro ao buscar livros", e);
        }
    	System.out.println("Retornando livros...");
    	return loanList;
    }
    
    public List<LoanBook> getUserLoanBooks(int id) throws EpiousionException{
    	Connection conn = null;
    	PreparedStatement prepStmt = null;
    	ResultSet rs = null;
    	List<LoanBook> loanList = new ArrayList<LoanBook>();
    	
    	try{
    		conn = DataSourceConnection.getConexao();
    		prepStmt = conn.prepareStatement(GET_USER_LOAN_BOOKS);
    		prepStmt.setInt(1, id);
    		
    		rs = prepStmt.executeQuery();
    		while(rs.next()){
    			
    			int idLoanBook = rs.getInt("idLoanBooks");
    			int idLoan = rs.getInt("idLoan");
    			int idBook = rs.getInt("idBook");
    			Date devolutionDate = rs.getDate("devolutionDate");
    			Date returnedDate = rs.getDate("returnedDate");
    			Date loanDate = rs.getDate("loanDate");
    			String title = rs.getString("title");
    			
    			LoanBook loanBook = new LoanBook(idLoanBook, idLoan, idBook, devolutionDate, returnedDate, loanDate, title);
    			loanList.add(loanBook);
    		}
    		
    	} catch (SQLException e) {
            e.printStackTrace();
            throw new EpiousionException("Erro ao buscar livros", e);
        } finally {
        	DataSourceConnection.closeAll(conn, prepStmt, rs);
        }
    	System.out.println("Retornando livros...");
    	return loanList;
    }
    
    public List<LoanBook> getUserBooksLoan(int pIdLoan) throws EpiousionException{
    	Connection conn = null;
    	PreparedStatement prepStmt = null;
    	ResultSet rs = null;
    	List<LoanBook> loanList = new ArrayList<LoanBook>();
    	
    	try{
    		conn = DataSourceConnection.getConexao();
    		prepStmt = conn.prepareStatement(GET_USER_BOOKS_LOAN);
    		prepStmt.setInt(1, pIdLoan);
    		
    		rs = prepStmt.executeQuery();
    		while(rs.next()){
    			
    			int idLoanBook = rs.getInt("idLoanBooks");
    			int idLoan = rs.getInt("idLoan");
    			int idBook = rs.getInt("idBook");
    			Date devolutionDate = rs.getDate("devolutionDate");
    			Date returnedDate = rs.getDate("returnedDate");
    			Date loanDate = rs.getDate("loanDate");
    			String title = rs.getString("title");
    			
    			LoanBook loanBook = new LoanBook(idLoanBook, idLoan, idBook, devolutionDate, returnedDate, loanDate, title);
    			loanList.add(loanBook);
    		}
    		
    	} catch (SQLException e) {
            e.printStackTrace();
            throw new EpiousionException("Erro ao buscar livros", e);
        } finally {
        	DataSourceConnection.closeAll(conn, prepStmt, rs);
        }
    	System.out.println("Retornando livros...");
    	return loanList;
    }
}
