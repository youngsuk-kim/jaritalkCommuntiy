package com.callbus.jaritalkcommunity.post;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadPostDto {
    public String author;
    public String memberType;
    public Boolean isMemberLikePost;
    public String title;
    public String content;
    public int likeCount;

    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public LocalDateTime deletedAt;
}
