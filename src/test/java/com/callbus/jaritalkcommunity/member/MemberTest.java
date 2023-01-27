package com.callbus.jaritalkcommunity.member;

import static com.callbus.jaritalkcommunity.member.AccountType.LESSEE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MemberTest {

    @Test
    void create_member() {
        Member member = Member.builder()
            .nickname(new Nickname("testNickname"))
            .accountId(new AccountId("testAccountId"))
            .accountType(LESSEE)
            .quit(false)
            .build();

        assertThat(member.getNickname()).isEqualTo(new Nickname("testNickname"));
        assertThat(member.getAccountId()).isEqualTo(new AccountId("testAccountId"));
        assertThat(member.getAccountType()).isEqualTo(LESSEE);
    }
}
