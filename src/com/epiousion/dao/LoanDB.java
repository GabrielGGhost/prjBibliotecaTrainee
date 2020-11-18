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
    private final String GET_LOANS_OF_THE_DAY = "CALL sp_getLoansOfTheDay";
    private final String GET_TODAY_DATE = "SELECT CAST(CURDATE() as DATE) as data;";
    private final String GET_SELECTED_LOAN = "CALL sp_getSelected(?)";
    private final String RECEIVE_BOOK = "CALL sp_receive_book(?)";
    private final String RENEW_BOOK = "CALL sp_renewBook(?)";
    private final String GET_ALL_BOOKS_LOAN = "CALL sp_getAllBooksLoan(?)";
    private final String GET_USER_SELECTED_LOAN_BOOKS = "CALL sp_getUserSelectedLoanBooks(?)";

    
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
    	UserDAO userdb = new UserDB();
    	
    	try{
    		conn = DataSourceConnection.getConexao();
    		stmt = conn.createStatement();
    		rs = stmt.executeQuery(GET_ALL_LOANS);
    		while(rs.next()){
    			
    			int idLoan = rs.getInt("idLoan");
    			int id = rs.getInt("idUser");
    			Date loanDate = rs.getDate("loanDate");
    			
    			User user = userdb.getUserByID(id);
    			
    			Loan loan = new Loan(idLoan, loanDate, user);
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
        }  finally {
        	DataSourceConnection.closeAll(conn, prepStmt, rs);
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
    
    public List<LoanBook> getLoansOfTheDay() throws EpiousionException{
    	Connection conn = null;
    	PreparedStatement prepStmt = null;
    	ResultSet rs = null;
    	List<LoanBook> loanList = new ArrayList<LoanBook>();
    	
    	try{
    		conn = DataSourceConnection.getConexao();
    		prepStmt = conn.prepareStatement(GET_LOANS_OF_THE_DAY);
    		
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
    
    public Date getTodayDate() throws EpiousionException{
    	Connection conn = null;
    	PreparedStatement prepStmt = null;
    	ResultSet rs = null;
    	Date date = null;
    	try{
    		conn = DataSourceConnection.getConexao();
    		prepStmt = conn.prepareStatement(GET_TODAY_DATE);
  
    		rs = prepStmt.executeQuery();
    		while(rs.next()){
    			
    			date = rs.getDate("data");
    		}
    		
    	} catch (SQLException e) {
            e.printStackTrace();
            throw new EpiousionException("Erro ao buscar livros", e);
        } finally {
        	DataSourceConnection.closeAll(conn, prepStmt, rs);
        }
    	System.out.println("Retornando livros...");
    	return date;
    }
    
    public LoanBook getSelectedLoan(int pIdLoan) throws EpiousionException{
    	Connection conn = null;
    	PreparedStatement prepStmt = null;
    	ResultSet rs = null;
    	LoanBook loan = null;
    	
    	try{
    		conn = DataSourceConnection.getConexao();
    		prepStmt = conn.prepareStatement(GET_SELECTED_LOAN);
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
    			String nameUser = rs.getString("name");
    			int idUser = rs.getInt("idUser");
    			
    			loan = new LoanBook(idLoanBook, idLoan, idBook, devolutionDate, returnedDate, loanDate, title, idUser, nameUser);
    		}
    		
    	} catch (SQLException e) {
            e.printStackTrace();
            throw new EpiousionException("Erro ao buscar livros", e);
        } finally {
        	DataSourceConnection.closeAll(conn, prepStmt, rs);
        }
    	System.out.println("Retornando livros...");
    	return loan;
    }
  
    public void receiveBook(int pIdLoan) throws EpiousionException{
    	Connection conn = null;
    	PreparedStatement prepStmt = null;
    	LoanBook loan = null;
    	
    	try{
    		conn = DataSourceConnection.getConexao();
    		prepStmt = conn.prepareStatement(RECEIVE_BOOK);
    		prepStmt.setInt(1, pIdLoan);
    		
    		prepStmt.executeQuery();
    		
    	} catch (SQLException e) {
            e.printStackTrace();
            throw new EpiousionException("Erro ao buscar livros", e);
        } finally {
        	DataSourceConnection.closeAll(conn, prepStmt);
        }
    	System.out.println("Retornando livros...");
    }
    
    public void renewBook(int pIdLoan) throws EpiousionException{
    	Connection conn = null;
    	PreparedStatement prepStmt = null;
    	LoanBook loan = null;
    	
    	try{
    		conn = DataSourceConnection.getConexao();
    		prepStmt = conn.prepareStatement(RENEW_BOOK);
    		prepStmt.setInt(1, pIdLoan);
    		
    		prepStmt.executeQuery();
    		
    	} catch (SQLException e) {
            e.printStackTrace();
            throw new EpiousionException("Erro ao buscar livros", e);
        } finally {
        	DataSourceConnection.closeAll(conn, prepStmt);
        }
    	System.out.println("Livro renovado...");
    }
    
    public List<LoanBook> getAllBooksLoan(int select) throws EpiousionException{
    	Connection conn = null;
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	List<LoanBook> loanList = new ArrayList<LoanBook>();
    	
    	try{
    		conn = DataSourceConnection.getConexao();
    		stmt = conn.prepareStatement(GET_ALL_BOOKS_LOAN);
    		stmt.setInt(1, select);
    		rs = stmt.executeQuery();
    		
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
        	DataSourceConnection.closeAll(conn, stmt, rs);
        }
    	return loanList;
    }
    
    
    public List<LoanBook> getUserSelectedLoanBooks(String id) throws EpiousionException{
    	Connection conn = null;
    	PreparedStatement prepStmt = null;
    	ResultSet rs = null;
    	List<LoanBook> loanList = new ArrayList<LoanBook>();
    	
    	try{
    		conn = DataSourceConnection.getConexao();
    		prepStmt = conn.prepareStatement(GET_USER_SELECTED_LOAN_BOOKS);
    		prepStmt.setString(1, id);
    		
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
