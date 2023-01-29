package com.callbus.jaritalkcommunity.post;

import com.callbus.jaritalkcommunity.member.Member;

public interface PostService {
    Post write(CreatePostDto createPostDto, Member member);
    Post read (Long postId);
    void like(Long postId, Member member);
}
