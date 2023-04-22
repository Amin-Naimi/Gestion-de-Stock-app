package com.example.versuion.services.strategy;

import com.example.versuion.Dto.ArticleDto;
import com.example.versuion.exception.FlickrException;
import com.example.versuion.models.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@Slf4j
public class SaveArticlePhoto implements Strategy<Article>{

    @Override
    public Article savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
        return null;
    }
}
