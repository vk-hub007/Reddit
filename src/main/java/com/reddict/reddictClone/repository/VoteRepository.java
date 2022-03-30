package com.reddict.reddictClone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reddict.reddictClone.model.Post;
import com.reddict.reddictClone.model.User;
import com.reddict.reddictClone.model.Vote;


@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}