package com.epiousion.dao;

import java.util.List;

import com.epiousion.exception.EpiousionException;
import com.epiousion.exception.LoginFailedException;
import com.epiousion.model.User;


public interface UserDAO {

    public void save(User p) throws EpiousionException;

    public User getUserByLogin(String username, String password) throws EpiousionException ;
    
    public List<User> getAllUsers() throws EpiousionException ;
    
    public void des_active(int idUser, boolean status) throws EpiousionException;
}