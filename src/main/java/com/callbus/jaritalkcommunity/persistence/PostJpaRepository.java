package com.callbus.jaritalkcommunity.persistence;

import com.callbus.jaritalkcommunity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
}
