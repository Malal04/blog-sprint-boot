package postes.angular.md.service;

import postes.angular.md.entity.Comment;

import java.util.List;

public interface CommentService {

    Comment createComment(Integer postId, String postedBy, String content);

    List<Comment> getCommentsByPostId(Integer postId);

}
