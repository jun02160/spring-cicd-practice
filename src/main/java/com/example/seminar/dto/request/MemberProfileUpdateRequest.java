package com.example.seminar.dto.request;

import com.example.seminar.domain.Part;
import lombok.Data;

@Data
public class MemberProfileUpdateRequest {
    private int generation;
    private Part part;
}

