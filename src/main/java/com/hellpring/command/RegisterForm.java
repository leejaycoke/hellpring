package com.hellpring.command;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterForm {

    @NotEmpty(message = "이메일 주소를 입력해주세요.")
    @Size(min = 5, max = 50, message = "이메일 주소는 5~50자로 해주세요.")
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;

    @NotEmpty(message = "비밀번호를 입력해주세요.")
    @Size(min = 8, max = 50, message = "비밀번호는 8~50자로 입력해주세요.")
    @Pattern(regexp = "^[0-9a-zA-Z]*$", message = "비밀번호를 영어, 숫자만 가능합니다.")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
