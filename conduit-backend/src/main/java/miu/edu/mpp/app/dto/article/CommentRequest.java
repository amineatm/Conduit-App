package miu.edu.mpp.app.dto.article;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CommentRequest {
    @NotBlank
    private String body;
}