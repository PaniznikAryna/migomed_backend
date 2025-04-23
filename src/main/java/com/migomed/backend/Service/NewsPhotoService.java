package com.migomed.backend.Service;

import com.migomed.backend.Entity.NewsPhoto;
import com.migomed.backend.Repository.NewsPhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsPhotoService {
    private final NewsPhotoRepository newsPhotoReposytory;

    public List<NewsPhoto> getAllNewsPhoto(){
        return newsPhotoReposytory.findAll();
    }

    public NewsPhoto getNewsPhotoById(Long id){
        return newsPhotoReposytory.findById(id).orElse(null);
    }

    public NewsPhoto saveNewsPhoto(NewsPhoto newsPhoto){
        return newsPhotoReposytory.save(newsPhoto);
    }

    public void deleteNewsPhoto(Long id){
        newsPhotoReposytory.deleteById(id);
    }
}
