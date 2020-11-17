package com.epiousion.dao;

import java.util.List;

import com.epiousion.exception.EpiousionException;

import com.epiousion.model.Gender;


public interface GenderDAO {

    public void register(Gender p) throws EpiousionException;
    
    public List<Gender> getAllGenders() throws EpiousionException;

}