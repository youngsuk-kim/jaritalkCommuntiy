package com.callbus.jaritalkcommunity.post;

import com.callbus.jaritalkcommunity.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post write(final CreatePostDto createPostDto, final Member member) {
        final Post post = Post.builder()
            .member(member)
            .title(createPostDto.title)
            .content(createPostDto.content)
            .build();

        return postRepository.save(post);
    }

    @Override
    @Transactional(readOnly = true)
    public Post read(final Long postId) {
        return postRepository.findByPostId(postId);
    }

    @Override
    public void like(final Long postId, final Member member) {
        final Post findPost = postRepository.findByPostId(postId);
        final boolean isMemberLikePost = findPost.isMemberLikePost(member.getId());

        if (!isMemberLikePost) {
            findPost.setMemberIdOfLike(member.getId());
        }
    }

}
