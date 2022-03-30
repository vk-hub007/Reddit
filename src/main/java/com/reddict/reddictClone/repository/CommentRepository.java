package com.reddict.reddictClone.repository;



import com.reddict.reddictClone.model.Comment;
import com.reddict.reddictClone.model.Post;
import com.reddict.reddictClone.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
