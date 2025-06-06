package com.migomed.backend.Service;

import com.migomed.backend.Entity.Comments;
import com.migomed.backend.Repository.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentsService {
    private final CommentsRepository commentsReposytory;

    public List<Comments> getAllComments(){
        return commentsReposytory.findAll();
    }

    public Comments getCommentsById(Long id){
        return commentsReposytory.findById(id).orElse(null);
    }

    public Comments saveComments(Comments comments){
        return commentsReposytory.save(comments);
    }

    public void deleteComments(Long id){
        commentsReposytory.deleteById(id);
    }
}
