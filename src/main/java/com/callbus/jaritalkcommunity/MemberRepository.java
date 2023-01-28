package com.callbus.jaritalkcommunity;

import com.callbus.jaritalkcommunity.member.AccountId;
import com.callbus.jaritalkcommunity.member.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByAccountId(AccountId accountId);
}
