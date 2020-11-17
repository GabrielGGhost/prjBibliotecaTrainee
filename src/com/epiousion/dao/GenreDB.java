package com.epiousion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import com.epiousion.exception.EpiousionException;
import com.epiousion.model.Genre;

public class GenreDB implements GenreDAO {

    private final String INSERT_QUERY = "INSERT INTO GENDERS(name) VALUES(?)";
    private final String GET_ALL_GENDERS = "SELECT * FROM GENDERS order by idGender desc";

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
}
