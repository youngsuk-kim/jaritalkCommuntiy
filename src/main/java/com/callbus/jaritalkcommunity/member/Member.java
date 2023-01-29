package com.callbus.jaritalkcommunity.member;

import com.callbus.jaritalkcommunity.common.BaseEntity;
import java.time.LocalDateTime;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Nickname nickname;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Embedded
    private AccountId accountId;
    private boolean quit;
    private LocalDateTime deletedAt;

    public void deleteMember() {
        this.quit = true;
        this.deletedAt = LocalDateTime.now();
    }
}
