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
import com.epiousion.model.User;

public class UserDB implements UserDAO {

    private final String INSERT_QUERY = "CALL sp_saveUser(?, ?, ?, ?, ?, ?)";
    private final String SELECT_BY_LOGIN = "select * from users where username = ? AND password = ?";
    private final String SELECT_BY_ID = "select * from users where idUser = ? AND active = 1";
    private final String SELECT_ALL_USERS= "select * from users order by idUser desc";
    private final String DES_ACTIVE_USER= "update user set active = ? where id = ?";

    @Override
    public void save(User user) throws EpiousionException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement prepStmt = null;
        try {
        	conn = DataSourceConnection.getConexao();
            prepStmt = conn.prepareStatement(INSERT_QUERY);
            prepStmt.setString(1, user.getName());
            prepStmt.setString(2, user.getUsername());
            prepStmt.setString(3, user.getPassword());
            prepStmt.setBoolean(4, user.isAdmin());
            prepStmt.setString(5, user.getEmail());
            prepStmt.setString(6, user.getPhone());
            
            prepStmt.executeQuery();
        } catch (SQLException e) {
            String msg = "[UserDB][save(User u)]: " + e.getMessage();
            EpiousionException ge = new EpiousionException(msg, e);
            throw ge;
        } finally{
        	DataSourceConnection.closeAll(conn, prepStmt);
        }
    }

    @Override
    public User getUserByLogin(String givenUsername, String givenPassword) throws EpiousionException {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        User user = null;
        try {
        	conn = DataSourceConnection.getConexao();
            prepStmt = conn.prepareStatement(SELECT_BY_LOGIN);
            prepStmt.setString(1, givenUsername);
            prepStmt.setString(2, givenPassword);
            
            rs = prepStmt.executeQuery();
            if (rs.next()) {
            	int id = rs.getInt("idUser");
                String username = rs.getString("username");
                String password = rs.getString("password");
                boolean admin = rs.getBoolean("admin");
                user = new User(id, username, password, admin);
            }
        } catch (SQLException e) {
            String msg = "[UserDB][getUserByLogin()]: " + e.getMessage();
            EpiousionException ge = new EpiousionException(msg, e);
            throw ge;
        } finally{
        	DataSourceConnection.closeAll(conn, prepStmt, rs);
        }
        return user;
    }
    
    public User getUserByID(int id) throws EpiousionException {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = DataSourceConnection.getConexao();
            prepStmt = conn.prepareStatement(SELECT_BY_ID);
            prepStmt.setInt(1, id);
            
            rs = prepStmt.executeQuery();
            if (rs.next()) {
            	int idUser = rs.getInt("idUser");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String username = rs.getString("username");
                Date registrationDate = rs.getDate("registrationDate");
                boolean admin = rs.getBoolean("admin");
                boolean active = rs.getBoolean("active");
                
                user = new User(idUser, name, username, admin, email, phone, active, registrationDate);
            }
        } catch (SQLException e) {
            String msg = "[UserDB][getUserById()]: " + e.getMessage();
            EpiousionException ge = new EpiousionException(msg, e);
            throw ge;
        }finally{
        	DataSourceConnection.closeAll(conn, prepStmt, rs);
        }
        return user;
    }
    
    public List<User> getAllUsers() throws EpiousionException{
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	List<User> listaUsuarios = new ArrayList<User>();
    	
    	try{
    		conn = DataSourceConnection.getConexao();
    		stmt = conn.createStatement();
    		rs = stmt.executeQuery(SELECT_ALL_USERS);
    		while(rs.next()){
    			int id = rs.getInt("idUser");
    			String name = rs.getString("name");
    			String username = rs.getString("username");
    			boolean admin = rs.getBoolean("admin");
    			boolean active = rs.getBoolean("active");
    			String phone = rs.getString("phone");
    			String email = rs.getString("email");
    			Date dataCadastro = rs.getDate("registrationDate");
    			
    			User u = new User(id, name, username, admin, email, phone,
    					active, dataCadastro); 
    			listaUsuarios.add(u);
    		}

    	} catch (SQLException e) {
            e.printStackTrace();
            throw new EpiousionException("[UserDB][getAllUsers()]", e);
        } finally{
        	DataSourceConnection.closeAll(conn, stmt, rs);
        }
    	return listaUsuarios;
    }
    
    public void des_active(int idUser, boolean status) throws EpiousionException{
    	Connection conn = null;
    	PreparedStatement prepStmt = null;
    	
    	try{
    		conn = DataSourceConnection.getConexao();
    		prepStmt = conn.prepareStatement(DES_ACTIVE_USER);
    		
    		if(status) prepStmt.setBoolean(1, !status);
    		else prepStmt.setBoolean(1, status);
    		
    		prepStmt.setInt(2, idUser);
    		prepStmt.execute();
    	} catch(SQLException e){
    	    String msg = "[UserDB][des(Produto p)]: " + e.getMessage();
    	    EpiousionException ge = new EpiousionException(msg, e);
    	    throw ge;
    	} finally{
        	DataSourceConnection.closeAll(conn, prepStmt);
        }
    	
    }
}
