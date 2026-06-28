package com.athaul.portfolio.dto;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Transport-friendly wrapper around a {@link Page}, decoupling the API
 * contract from Spring Data's internal serialization format.
 */
public record PageResponse<T>(
        List<T> content,
        int page,
        int size,
        long totalElements,
        int totalPages,
        boolean first,
        boolean last
) {

    public static <T> PageResponse<T> from(Page<T> page) {
        return new PageResponse<>(
                page.getContent(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isFirst(),
                page.isLast()
        );
    }
}
