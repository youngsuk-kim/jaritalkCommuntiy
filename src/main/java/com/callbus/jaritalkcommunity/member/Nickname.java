package com.callbus.jaritalkcommunity.member;

import com.callbus.jaritalkcommunity.annotation.ValueObject;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@ValueObject
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Nickname {
    @Column(name = "nickname")
    private String value;
}
