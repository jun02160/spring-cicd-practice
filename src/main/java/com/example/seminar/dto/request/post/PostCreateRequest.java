package com.example.seminar.dto.request.post;

public record PostCreateRequest(
        Long memberId,
        String title,
        String content
) {
}
