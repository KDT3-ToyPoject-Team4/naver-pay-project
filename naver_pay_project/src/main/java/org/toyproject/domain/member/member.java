package org.toyproject.domain.member;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class member {

    private Long id;
    @NotEmpty
    private String loginId; // 로그인 ID
    @NotEmpty
    private String name; // 사용자 이름
    @NotEmpty
    private String password;
}
