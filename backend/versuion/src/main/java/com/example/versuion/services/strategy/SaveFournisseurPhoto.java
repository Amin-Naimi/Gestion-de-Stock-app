package com.example.versuion.services.strategy;

import com.example.versuion.exception.FlickrException;
import com.example.versuion.models.Article;
import com.example.versuion.models.Fournisseur;

import java.io.InputStream;

public class SaveFournisseurPhoto implements Strategy<Fournisseur>{
    @Override
    public Fournisseur savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
        return null;
    }
}
