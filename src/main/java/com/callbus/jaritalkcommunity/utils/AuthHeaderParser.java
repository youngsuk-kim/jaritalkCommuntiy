package com.callbus.jaritalkcommunity.utils;

import com.callbus.jaritalkcommunity.member.AccountId;
import com.callbus.jaritalkcommunity.member.AccountType;
import java.util.Optional;
import java.util.regex.Pattern;

public class AuthHeaderParser {

    private AuthHeaderParser() {}

    public static Optional<AccountId> execute(final String authHeader) {
        AccountId accountId = null;
        for (AccountType value : AccountType.values()) {
            final boolean matches = Pattern.matches("^" + value.name() + ".*", authHeader);
            if (matches) {
                accountId = new AccountId(authHeader.replaceAll("^" + value.name() + "( )*", ""));
                break;
            }
        }
        return Optional.ofNullable(accountId);
    }
}
