package com.example.seminar.dto.request;

public record MemberProfileUpdateRequest(
        String name,
        String nickname,
        int age
) {
}
