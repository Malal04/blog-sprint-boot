package postes.angular.md.service;

import postes.angular.md.entity.Post;

import java.util.List;

public interface PostService {

    Post savePost(Post post);

    List<Post> getAllPosts();

    Post getPostById(Integer id);

    void likePost(Integer postId);

    List<Post> searchByName(String name);

}
