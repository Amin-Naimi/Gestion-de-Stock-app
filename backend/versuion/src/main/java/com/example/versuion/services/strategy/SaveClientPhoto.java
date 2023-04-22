package com.example.versuion.services.strategy;

import com.example.versuion.exception.FlickrException;
import com.example.versuion.models.Client;

import java.io.InputStream;

public class SaveClientPhoto implements Strategy<Client>{
    @Override
    public Client savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
        return null;
    }
}
