package com.example.cupcakeBackend.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.cupcakeBackend.exception.ResourceNotFoundException;
import com.example.cupcakeBackend.model.Comment;
import com.example.cupcakeBackend.repository.CommentRepository;

@RestController
@RequestMapping("/cupcakeShop/v1")

public class CommentController {

    @Autowired
    private CommentRepository commentRepository;



    //get all comments

    @GetMapping("/comments")
    public List<Comment> getAllComments(Model model){
        return commentRepository.findAll();
    }
    //get all Comments by id

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Comment not found for this id ::" + id ));
        return ResponseEntity.ok().body(comment);
    }
    //save Comment

    @PostMapping("/comments")
    public Comment createComment(@Valid @RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    //Update comment

    @PutMapping("/comments/{id}")
    public ResponseEntity<Comment> updateCommentById(@PathVariable(value = "id") Long id, @Valid @RequestBody Comment commentDetails)
            throws ResourceNotFoundException {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Comment not found for this id :: " + id));

        comment.setComment(commentDetails.getComment());


        final Comment updatedComment = commentRepository.save(comment);

        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/comments/{id}")
    public Map<String, Boolean> deletedComment(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Comment not found for this id :: " + id));


        commentRepository.delete(comment);
        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted Comment", Boolean.TRUE);

        return response;
    }
}
