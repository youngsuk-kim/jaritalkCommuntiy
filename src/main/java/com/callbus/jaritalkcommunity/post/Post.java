package com.callbus.jaritalkcommunity.post;

import com.callbus.jaritalkcommunity.common.BaseEntity;
import com.callbus.jaritalkcommunity.member.Member;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {

    @Builder
    public Post(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.author = member;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "board_member_like", joinColumns =
        @JoinColumn(name = "id"))
    private Set<Long> memberLike = new HashSet<>();

    private LocalDateTime deletedAt;

    public void deleteContent() {
        this.deletedAt = LocalDateTime.now();
    }

    public void setMemberIdOfLike(Long memberId) {
        this.memberLike.add(memberId);
    }

    public int getMemberLikeCount() {
        return memberLike.size();
    }

    public boolean isMemberLikePost(Long memberId) {
        if (memberId == null) {
            return false;
        }
        return memberLike.contains(memberId);
    }
}
