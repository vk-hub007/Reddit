package com.reddict.reddictClone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reddict.reddictClone.model.Post;
import com.reddict.reddictClone.model.Subreddit;
import com.reddict.reddictClone.model.User;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);
}