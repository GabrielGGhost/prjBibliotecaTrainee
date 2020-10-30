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

    private final String INSERT_QUERY = "insert into produtos (nome,preco,marca) values (?,?,?)";
    private final String SELECT_BY_LOGIN = "select * from users where username = ? AND password = ?";
    private final String SELECT_ALL_USERS= "select * from users";

    @Override
    public void save(User user) throws EpiousionException {
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
    public User getUserByLogin(String givenUsername, String givenPassword) throws EpiousionException {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = ConnectionManager.getConexao();
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
            String msg = "[ProdutosDB][getProdutoById()]: " + e.getMessage();
            EpiousionException ge = new EpiousionException(msg, e);
            throw ge;
        } finally {
            ConnectionManager.closeAll(conn, prepStmt, rs);
        }
        return user;
    }
    
    public List<User> getAllUsers() throws EpiousionException{
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	List<User> listaUsuarios = new ArrayList<User>();
    	
    	try{
    		conn = ConnectionManager.getConexao();
    		stmt = conn.createStatement();
    		rs = stmt.executeQuery(SELECT_ALL_USERS);
    		while(rs.next()){
    			int id = rs.getInt("idUser");
    			String name = rs.getString("name");
    			String username = rs.getString("username");
    			String password = rs.getString("password");
    			boolean admin = rs.getBoolean("admin");
    			boolean active = rs.getBoolean("active");
    			String phone = rs.getString("phone");
    			String email = rs.getString("email");
    			Date dataCadastro = rs.getDate("registrationDate");
    			
    			User u = new User(id, name, username, password, admin, email, phone,
    					active, dataCadastro);
    			listaUsuarios.add(u);
    		}
    	} catch (SQLException e) {
            e.printStackTrace();
            throw new EpiousionException("Erro ao criar a tabela de produtos", e);
        } finally {
            ConnectionManager.closeAll(conn, stmt);
        }
    	return listaUsuarios;
    }
   
}
