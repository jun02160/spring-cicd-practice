package com.example.seminar.service;


import com.example.seminar.common.exception.BusinessException;
import com.example.seminar.domain.Category;
import com.example.seminar.domain.CategoryId;
import com.example.seminar.repository.CategoryJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryJpaRepository categoryJpaRepository;

    public Category getById(CategoryId categoryId) {
        return categoryJpaRepository.findById(Short.valueOf(categoryId.getId())).orElseThrow(
                () -> new EntityNotFoundException("해당하는 카테고리가 없습니다."));
    }
}
