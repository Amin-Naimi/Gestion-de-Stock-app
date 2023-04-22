package com.example.versuion.services.strategy;

import com.example.versuion.exception.FlickrException;
import com.example.versuion.models.Entreprise;

import java.io.InputStream;

public class SaveEntreprisePhoto implements Strategy<Entreprise>{
    @Override
    public Entreprise savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
        return null;
    }
}
