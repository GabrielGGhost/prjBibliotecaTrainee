package com.epiousion.dao;

import java.util.List;

import com.epiousion.exception.EpiousionException;
import com.epiousion.exception.LoginFailedException;
import com.epiousion.model.Book;


public interface BookDAO {

    public void register(Book p) throws EpiousionException;

    public Book getBookByTombo(int tombo) throws EpiousionException ;

    public Book getBookByTomboAjax(int tombo) throws EpiousionException ;

    public List<Book> getAllBooks() throws EpiousionException ;
    
    public void des_active(int idBook, boolean status) throws EpiousionException;
}