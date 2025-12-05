package com.appdev.contractors.contractorsg5.controller;


import com.appdev.contractors.contractorsg5.entity.CommentsEntity;
import com.appdev.contractors.contractorsg5.service.CommentsService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    private final CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    // CREATE
    @PostMapping("/create")
    public CommentsEntity createComment(@RequestBody CommentsEntity comment) {
        return commentsService.createComment(comment);
    }

    // READ
    @GetMapping("/getAll")
    public List<CommentsEntity> getAllComments() {
        return commentsService.getAllComments();
    }

    // UPDATE
    @PutMapping("/{id}")
    public CommentsEntity updateComment(@PathVariable Long id, @RequestBody CommentsEntity comment) {
        return commentsService.updateComment(id, comment);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable Long id) {
        commentsService.deleteComment(id);
        return "Comment with ID " + id + " deleted successfully.";
    }
}
