package com.callbus.jaritalkcommunity.post;

import com.callbus.jaritalkcommunity.member.Member;
import com.callbus.jaritalkcommunity.post.mapper.PostMapper;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final HttpServletRequest httpServletRequest;

    @PostMapping
    public ResponseEntity<ReadPostDto> write(
        @RequestBody final CreatePostDto createPostDto
    ) {
        final Member member = getMember();
        final Post post = postService.write(createPostDto, member);

        return new ResponseEntity<>(
            PostMapper.toReadPostDto(post, member),
            HttpStatus.CREATED
        );
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ReadPostDto> read(
        @PathVariable("postId") final Long postId
    ) {
        final Post post = postService.read(postId);

        return ResponseEntity.ok(PostMapper.toReadPostDto(post, getMember()));
    }

    @PostMapping("/{postId}/like")
    public ResponseEntity<Void> like(
        @PathVariable("postId") final Long postId
    ) {
        postService.like(postId, getMember());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Member getMember() {
        return (Member) httpServletRequest.getAttribute("member");
    }
}
