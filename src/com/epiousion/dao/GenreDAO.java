package com.epiousion.dao;

import java.util.List;

import com.epiousion.exception.EpiousionException;

import com.epiousion.model.Genre;


public interface GenreDAO {

    public void register(Genre p) throws EpiousionException;
    
    public List<Genre> getAllGenders() throws EpiousionException;

    public List<Genre> getUnregisteredGenres(String id) throws EpiousionException;

    public List<Genre> getRegisteredGenres(String id) throws EpiousionException;

}