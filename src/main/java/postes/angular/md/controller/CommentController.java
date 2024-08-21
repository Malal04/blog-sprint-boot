package postes.angular.md.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import postes.angular.md.service.CommentService;

@RestController
@RequestMapping("/api/v1/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comments/create")
    public ResponseEntity<?> createComment(@RequestParam Integer postId, @RequestParam String postedBy , @RequestBody String content) {
        try {
            return ResponseEntity.ok(commentService.createComment(postId, postedBy, content));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    @GetMapping("/comments/{postId}")
    public ResponseEntity<?> getCommentsPostId(@PathVariable Integer postId) {
        try {
            return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

}
