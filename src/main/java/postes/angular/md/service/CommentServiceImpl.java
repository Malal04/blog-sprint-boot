package postes.angular.md.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import postes.angular.md.entity.Comment;
import postes.angular.md.entity.Post;
import postes.angular.md.repository.CommentRepository;
import postes.angular.md.repository.PostRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    public Comment createComment(Integer postId, String postedBy, String content) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Comment comment = new Comment();

            comment.setPost(optionalPost.get());
            comment.setContent(content);
            comment.setCreatedAt(new Date());


            return commentRepository.save(comment);
        }
        throw new RuntimeException("Post not found");
    }

    public List<Comment> getCommentsByPostId(Integer postId) {
        return commentRepository.findByPostId(postId);
    }
}
