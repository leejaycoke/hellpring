package com.hellpring.command;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class WriteForm {

    @NotEmpty(message = "제목을 입력해주세요.")
    @Size(min = 2, max = 30, message = "제목은 2~30자로 해주세요.")
    private String title;

    @NotEmpty(message = "내용을 입력해주세요.")
    @Size(min = 1, max = 1000, message = "내용은 1000자 까지 입력 가능합니다.")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
