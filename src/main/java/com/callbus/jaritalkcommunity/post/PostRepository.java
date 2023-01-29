package com.callbus.jaritalkcommunity.post;

import com.callbus.jaritalkcommunity.member.Member;

public interface PostRepository {
    Post save(Post post);
    Post findByPostId(Long postId);
}
