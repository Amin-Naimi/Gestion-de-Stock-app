package com.example.versuion.services.strategy;

import com.example.versuion.exception.FlickrException;

import java.io.InputStream;

public interface Strategy <T>{

    T savePhoto(Integer id, InputStream photo, String titre) throws FlickrException;

}
