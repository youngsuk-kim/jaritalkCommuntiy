package com.callbus.jaritalkcommunity.persistence;

import com.callbus.jaritalkcommunity.post.Post;
import com.callbus.jaritalkcommunity.post.PostRepository;
import com.callbus.jaritalkcommunity.exception.NoContentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    private final PostJpaRepository postJpaRepository;

    @Override
    public Post save(final Post post) {
        if (post != null) {
            postJpaRepository.save(post);
        }
        return post;
    }

    @Override
    public Post findByPostId(final Long boardId) {
        return postJpaRepository.findById(boardId)
            .orElseThrow(NoContentException::new);
    }

}
