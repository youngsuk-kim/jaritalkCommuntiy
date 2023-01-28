package com.callbus.jaritalkcommunity.interceptor;

import com.callbus.jaritalkcommunity.MemberRepository;
import com.callbus.jaritalkcommunity.exception.NoAuthorizedException;
import com.callbus.jaritalkcommunity.member.AccountId;
import com.callbus.jaritalkcommunity.member.Member;
import com.callbus.jaritalkcommunity.utils.AuthHeaderParser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class CheckWriteAuthorityInterceptor implements HandlerInterceptor {

    private final MemberRepository memberRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) {

        if (request.getMethod().equals(HttpMethod.GET.name())) {
            return true;
        }

        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader == null) {
            throw new NoAuthorizedException();
        }

        AccountId accountId = AuthHeaderParser.execute(authHeader)
            .orElseThrow(NoAuthorizedException::new);

        Member member = memberRepository.findByAccountId(accountId)
            .orElseThrow(NoAuthorizedException::new);

        return member != null;
    }
}
