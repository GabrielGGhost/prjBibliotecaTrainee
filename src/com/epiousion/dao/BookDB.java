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

public class BookDB implements BookDAO {

    private final String INSERT_QUERY = "insert into book (nome,preco,marca) values (?,?,?)";
    private final String SELECT_BY_TOMBO = "select * from books where tombo = ?";
    private final String SELECT_ALL_BOOKS= "select * from books";
    private final String DES_ACTIVE_USER= "update user set active = ? where id = ?";

    @Override
    public void save(Book book) throws EpiousionException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement prepStmt = null;
        try {
            conn = ConnectionManager.getConexao();
            prepStmt = conn.prepareStatement(INSERT_QUERY);
            prepStmt.execute();
        } catch (SQLException e) {
            String msg = "[ProdutosDB][save(Produto p)]: " + e.getMessage();
            EpiousionException ge = new EpiousionException(msg, e);
            throw ge;
        } finally {
            ConnectionManager.closeAll(conn, prepStmt, rs);
        }
    }

    @Override
    public Book getBookByTombo(int tombo) throws EpiousionException {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Book book = null;
        try {
            conn = ConnectionManager.getConexao();
            prepStmt = conn.prepareStatement(SELECT_BY_TOMBO);
            prepStmt.setInt(1, tombo);
            
            rs = prepStmt.executeQuery();
            if (rs.next()) {
            	int vTombo = rs.getInt("tombo");
                String title = rs.getString("title");
                int year = rs.getInt("year");
                String author = rs.getString("author");
                book = new Book(vTombo, title, year, author);
            }

        } catch (SQLException e) {
            String msg = "[ProdutosDB][getProdutoById()]: " + e.getMessage();
            EpiousionException ge = new EpiousionException(msg, e);
            throw ge;
        } finally {
            ConnectionManager.closeAll(conn, prepStmt, rs);
        }
        return book;
    }
    
    public List<Book> getAllBooks() throws EpiousionException{
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	List<Book> bookList = new ArrayList<Book>();
    	
    	try{
    		conn = ConnectionManager.getConexao();
    		stmt = conn.createStatement();
    		rs = stmt.executeQuery(SELECT_ALL_BOOKS);
    		while(rs.next()){
    			int id = rs.getInt("idBook");
    			String title = rs.getString("title");
    			int year = rs.getInt("year");
    			String description = rs.getString("description");
    			String picturepath = rs.getString("picturepath");
    			int tombo = rs.getInt("tombo");
    			String author = rs.getString("author");
    			boolean active = rs.getBoolean("active");
    			
    			Book b = new Book(id, title, year, description, picturepath, tombo, author, active);
    			bookList.add(b);
    		}
    	} catch (SQLException e) {
            e.printStackTrace();
            throw new EpiousionException("Erro ao buscar livros", e);
        } finally {
            ConnectionManager.closeAll(conn, stmt);
        }
    	return bookList;
    }
    
    public void des_active(int idUser, boolean status) throws EpiousionException{
    	Connection conn = null;
    	PreparedStatement prepStmt = null;
    	
    	try{
    		conn = ConnectionManager.getConexao();
    		prepStmt = conn.prepareStatement(DES_ACTIVE_USER);
    		
    		if(status) prepStmt.setBoolean(1, !status);
    		else prepStmt.setBoolean(1, status);
    		
    		prepStmt.setInt(2, idUser);
    		prepStmt.execute();
    	} catch(SQLException e){
    	    String msg = "[UserDB][des(Produto p)]: " + e.getMessage();
    	    EpiousionException ge = new EpiousionException(msg, e);
    	    throw ge;
    	}
    }
}
