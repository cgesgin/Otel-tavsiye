package com.cgesgin.OtelTavsiye.Controller;

import com.cgesgin.OtelTavsiye.Entity.Comment;
import com.cgesgin.OtelTavsiye.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @PostMapping("/save")
    public Comment saveComment(@RequestBody Comment comment){
        return commentRepository.save(comment);
    }
}
