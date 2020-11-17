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

    private final String INSERT_QUERY = "CALL sp_registerBook(?, ?, ?, ?)";
    private final String SELECT_BY_TOMBO = "SELECT * FROM books WHERE tombo NOT IN(SELECT idBook FROM loan_books) AND tombo = ?";
    private final String GET_BY_TOMBO = "SELECT * FROM books WHERE tombo = ?";
    private final String SELECT_BY_TOMBO_AJAX = "SELECT * FROM books WHERE tombo = ?";
    private final String SELECT_ALL_BOOKS= "select * from books order by tombo desc";
    private final String DES_ACTIVE_BOOK= "update books set active = ? where tombo = ?";

    @Override
    public void register(Book book) throws EpiousionException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement prepStmt = null;
        try {
        	conn = DataSourceConnection.getConexao();
            prepStmt = conn.prepareStatement(INSERT_QUERY);
            prepStmt.setString(1, book.getTitle());
            prepStmt.setInt(2, book.getYear());
            prepStmt.setString(3, book.getAuthor());
            prepStmt.setString(4, book.getDescription());

            prepStmt.execute();
        } catch (SQLException e) {
            String msg = "[BookDB][register(Book b)]: " + e.getMessage();
            EpiousionException ge = new EpiousionException(msg, e);
            throw ge;
        } finally {
        	DataSourceConnection.closeAll(conn, prepStmt, rs);
        }
    }

    @Override
    public Book getBookByTombo(int tombo) throws EpiousionException {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Book book = null;
        try {
        	conn = DataSourceConnection.getConexao();
            prepStmt = conn.prepareStatement(SELECT_BY_TOMBO);
            prepStmt.setInt(1, tombo);
            
            rs = prepStmt.executeQuery();
            if (rs.next()) {
            	int vTombo = rs.getInt("tombo");
                String title = rs.getString("title");
                int year = rs.getInt("year");
                String author = rs.getString("author");
                String picturepath = rs.getString("picturepath");
                String description = rs.getString("description");
                boolean active = rs.getBoolean("active");
                book = new Book(title, year, description, picturepath,vTombo , author, active);
            }
        } catch (SQLException e) {
            String msg = "[ProdutosDB][getProdutoById()]: " + e.getMessage();
            EpiousionException ge = new EpiousionException(msg, e);
            throw ge;
        } finally {
        	DataSourceConnection.closeAll(conn, prepStmt, rs);
        }
        return book;
    }
    
    public Book getAllBookByTombo(int tombo) throws EpiousionException {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Book book = null;
        try {
        	conn = DataSourceConnection.getConexao();
            prepStmt = conn.prepareStatement(GET_BY_TOMBO);
            prepStmt.setInt(1, tombo);
            
            rs = prepStmt.executeQuery();
            if (rs.next()) {
            	int vTombo = rs.getInt("tombo");
                String title = rs.getString("title");
                int year = rs.getInt("year");
                String author = rs.getString("author");
                String picturepath = rs.getString("picturepath");
                String description = rs.getString("description");
                boolean active = rs.getBoolean("active");
                book = new Book(title, year, description, picturepath,vTombo , author, active);
            }
        } catch (SQLException e) {
            String msg = "[ProdutosDB][getProdutoById()]: " + e.getMessage();
            EpiousionException ge = new EpiousionException(msg, e);
            throw ge;
        } finally {
        	DataSourceConnection.closeAll(conn, prepStmt, rs);
        }
        return book;
    }
    
    public List<Book> getAllBooks() throws EpiousionException{
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	List<Book> bookList = new ArrayList<Book>();
    	
    	try{
    		conn = DataSourceConnection.getConexao();
    		stmt = conn.createStatement();
    		rs = stmt.executeQuery(SELECT_ALL_BOOKS);
    		while(rs.next()){
    			int tombo = rs.getInt("tombo");
    			String title = rs.getString("title");
    			int year = rs.getInt("year");
    			String description = rs.getString("description");
    			String picturepath = rs.getString("picturepath");
    			String author = rs.getString("author");
    			boolean active = rs.getBoolean("active");
    			
    			Book b = new Book(title, year, description, picturepath, tombo, author, active);
    			bookList.add(b);
    		}
    	} catch (SQLException e) {
            e.printStackTrace();
            throw new EpiousionException("Erro ao buscar livros", e);
        } finally {
        	DataSourceConnection.closeAll(conn, stmt, rs);
        }
    	return bookList;
    }
    
    public void des_active(int idUser, boolean status) throws EpiousionException{
    	Connection conn = null;
    	PreparedStatement prepStmt = null;
    	
    	try{
    		conn = DataSourceConnection.getConexao();
    		prepStmt = conn.prepareStatement(DES_ACTIVE_BOOK);
    		
    		prepStmt.setBoolean(1, !status);

    		
    		prepStmt.setInt(2, idUser);
    		prepStmt.execute();
    	} catch(SQLException e){
    	    String msg = "[UserDB][des(Produto p)]: " + e.getMessage();
    	    EpiousionException ge = new EpiousionException(msg, e);
    	    throw ge;
    	} finally {
        	DataSourceConnection.closeAll(conn, prepStmt);
        }
    }
    
    public Book getBookByTomboAjax(int tombo) throws EpiousionException {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Book book = null;
        try {
        	conn = DataSourceConnection.getConexao();
            prepStmt = conn.prepareStatement(SELECT_BY_TOMBO_AJAX);
            prepStmt.setInt(1, tombo);
            
            rs = prepStmt.executeQuery();
            if (rs.next()) {
            	int vTombo = rs.getInt("tombo");
                String title = rs.getString("title");
                int year = rs.getInt("year");
                String author = rs.getString("author");
                String picturepath = rs.getString("picturepath");
                String description = rs.getString("description");
                boolean active = rs.getBoolean("active");
                book = new Book(title, year, description, picturepath,vTombo , author, active);
            }
        } catch (SQLException e) {
            String msg = "[ProdutosDB][getProdutoById()]: " + e.getMessage();
            EpiousionException ge = new EpiousionException(msg, e);
            throw ge;
        } finally {
        	DataSourceConnection.closeAll(conn, prepStmt, rs);
        }
        return book;
    }
}
