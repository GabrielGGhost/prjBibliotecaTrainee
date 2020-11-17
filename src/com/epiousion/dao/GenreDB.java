package com.epiousion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import com.epiousion.exception.EpiousionException;
import com.epiousion.model.Book;
import com.epiousion.model.Genre;

public class GenreDB implements GenreDAO {

    private final String INSERT_QUERY = "INSERT INTO GENDERS(name) VALUES(?)";
    private final String GET_ALL_GENDERS = "SELECT * FROM GENDERS order by idGender desc";
    private final String GET_UNREGISTERED_GENDERS = "CALL sp_getUnregisteredGenres(?)";
    private final String GET_REGISTERED_GENDERS = "CALL sp_getRegisteredGenres(?)";
    private final String LINK_GENDER = "CALL sp_linkGender(?,?)";
    private final String UNLINK_GENDER = "CALL sp_unlinkGender(?,?)";

    @Override
    public void register(Genre gender) throws EpiousionException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement prepStmt = null;
        try {
        	conn = DataSourceConnection.getConexao();
            prepStmt = conn.prepareStatement(INSERT_QUERY);
            prepStmt.setString(1, gender.getName());

            prepStmt.execute();
        } catch (SQLException e) {
            String msg = "[BookDB][register(Book b)]: " + e.getMessage();
            EpiousionException ge = new EpiousionException(msg, e);
            throw ge;
        } finally {
        	DataSourceConnection.closeAll(conn, prepStmt, rs);
        }
    }
    
    public List<Genre> getAllGenders() throws EpiousionException{
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	List<Genre> genderList = new ArrayList<Genre>();
    	
    	try{
    		conn = DataSourceConnection.getConexao();
    		stmt = conn.createStatement();
    		rs = stmt.executeQuery(GET_ALL_GENDERS);
    		while(rs.next()){
    			
    			int id = rs.getInt("idGender");
    			String name = rs.getString("name");

    			
    			Genre b = new Genre(id,name);
    			genderList.add(b);
    		}
    	} catch (SQLException e) {
            e.printStackTrace();
            throw new EpiousionException("Erro ao buscar gêneros", e);
        } finally {
        	DataSourceConnection.closeAll(conn, stmt, rs);
        }
    	return genderList;
    }
    
    @Override
    public List<Genre> getUnregisteredGenres(String pId) throws EpiousionException{
    	Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        List<Genre> genderList = new ArrayList<Genre>();
        try {
        	conn = DataSourceConnection.getConexao();
            prepStmt = conn.prepareStatement(GET_UNREGISTERED_GENDERS);
            prepStmt.setString(1, pId);
            
            rs = prepStmt.executeQuery();
            while (rs.next()) {
            	
            	int id = rs.getInt("idGender");
    			String name = rs.getString("name");

    			Genre b = new Genre(id,name);
    			genderList.add(b);
            }
        } 
        catch (SQLException e) {
            String msg = "[ProdutosDB][getProdutoById()]: " + e.getMessage();
            EpiousionException ge = new EpiousionException(msg, e);
            throw ge;
        } finally {
        	DataSourceConnection.closeAll(conn, prepStmt, rs);
        }
        System.out.println("Retornando gêneros não cadastrados");
        return genderList;
    }
    
    @Override
    public List<Genre> getRegisteredGenres(String pId) throws EpiousionException{
    	Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        List<Genre> genderList = new ArrayList<Genre>();
        try {
        	conn = DataSourceConnection.getConexao();
            prepStmt = conn.prepareStatement(GET_REGISTERED_GENDERS);
            prepStmt.setString(1, pId);
            
            rs = prepStmt.executeQuery();
            while (rs.next()) {
            	
            	int id = rs.getInt("idGender");
    			String name = rs.getString("name");

    			Genre b = new Genre(id,name);
    			genderList.add(b);
            }
        } 
        catch (SQLException e) {
            String msg = "[ProdutosDB][getProdutoById()]: " + e.getMessage();
            EpiousionException ge = new EpiousionException(msg, e);
            throw ge;
        } finally {
        	DataSourceConnection.closeAll(conn, prepStmt, rs);
        }
        System.out.println("Retornando gêneros cadastrados");
        return genderList;
    }
    
    public void linkGender(String tombo, String idGenre) throws EpiousionException{
    	Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
        	conn = DataSourceConnection.getConexao();
            prepStmt = conn.prepareStatement(LINK_GENDER);
            prepStmt.setString(1, tombo);
            prepStmt.setString(2, idGenre);

            prepStmt.executeQuery();
        } 
        catch (SQLException e) {
            String msg = "[ProdutosDB][getProdutoById()]: " + e.getMessage();
            EpiousionException ge = new EpiousionException(msg, e);
            throw ge;
        } finally {
        	DataSourceConnection.closeAll(conn, prepStmt);
        }
        System.out.println("Gênero cadastrado");
    }
    
    public void unlinkGender(String tombo, String idGenre) throws EpiousionException{
    	Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
        	conn = DataSourceConnection.getConexao();
            prepStmt = conn.prepareStatement(UNLINK_GENDER);
            prepStmt.setString(1, tombo);
            prepStmt.setString(2, idGenre);

            prepStmt.executeQuery();
        } 
        catch (SQLException e) {
            String msg = "[ProdutosDB][getProdutoById()]: " + e.getMessage();
            EpiousionException ge = new EpiousionException(msg, e);
            throw ge;
        } finally {
        	DataSourceConnection.closeAll(conn, prepStmt);
        }
        System.out.println("Gênero removido");
    }
}
