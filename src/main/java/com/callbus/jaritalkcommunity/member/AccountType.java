package com.callbus.jaritalkcommunity.member;

import lombok.Getter;

@Getter
public enum AccountType {
    LESSOR("임대인"), REALTOR("공인 중개사"), LESSEE("임차인");

    final String name;

    AccountType(String name) {
        this.name = name;
    }
}
