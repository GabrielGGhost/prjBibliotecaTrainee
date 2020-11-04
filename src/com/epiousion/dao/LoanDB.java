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
import com.epiousion.model.User;

public class LoanDB implements LoanDAO {

    private final String INSERT_LOAN = "CALL sp_saveLoan(?)";
    private final String INSERT_LOAN_BOOK = "CALL sp_saveLoanBook(?,?)";
    private final String GET_ALL_LOANS = "CALL sp_getAllLoans";

    @Override
    public String saveLoan(String idUser) throws EpiousionException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement prepStmt = null;
        String idLoan = null;

        try {
            conn = ConnectionManager.getConexao();
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
            ConnectionManager.closeAll(conn, prepStmt, rs);
        }
        
        return idLoan;
    }
    
    @Override
    public void saveBookLoan(String idLoan, String idBook) throws EpiousionException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement prepStmt = null;

        try {
            conn = ConnectionManager.getConexao();
            prepStmt = conn.prepareStatement(INSERT_LOAN_BOOK);
            prepStmt.setString(1, idLoan);
            prepStmt.setString(2, idBook);

            prepStmt.execute();
           
            
        } catch (SQLException e) {
            String msg = "[ProdutosDB][save(Produto p)]: " + e.getMessage();
            EpiousionException ge = new EpiousionException(msg, e);
            throw ge;
        } finally {
            ConnectionManager.closeAll(conn, prepStmt, rs);
        }
    }
    
    public List<Loan> getAllLoans() throws EpiousionException{
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	List<Loan> loanList = new ArrayList<Loan>();
    	
    	try{
    		conn = ConnectionManager.getConexao();
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
            ConnectionManager.closeAll(conn, stmt);
        }
    	return loanList;
    }
}
