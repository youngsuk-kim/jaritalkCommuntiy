package com.callbus.jaritalkcommunity.post.mapper;

import com.callbus.jaritalkcommunity.member.Member;
import com.callbus.jaritalkcommunity.post.Post;
import com.callbus.jaritalkcommunity.post.ReadPostDto;

public class PostMapper {

    private PostMapper() {
    }

    public static ReadPostDto toReadPostDto(Post post, Member member) {

        Long memberId = null;

        if (member != null) {
            memberId = member.getId();
        }

        return ReadPostDto
            .builder()
            .author(post.getAuthor().getNickname().getValue())
            .memberType(post.getAuthor().getAccountType().getName())
            .isMemberLikePost(post.isMemberLikePost(memberId))
            .title(post.getTitle())
            .content(post.getContent())
            .likeCount(post.getMemberLikeCount())
            .createdAt(post.getCreatedAt())
            .updatedAt(post.getUpdatedAt())
            .deletedAt(post.getDeletedAt())
            .build();
    }
}
