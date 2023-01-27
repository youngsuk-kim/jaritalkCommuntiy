package com.callbus.jaritalkcommunity.member;

import com.callbus.jaritalkcommunity.annotation.ValueObject;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@ValueObject
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Nickname {
    @Column(name = "nickname")
    private String value;
}
