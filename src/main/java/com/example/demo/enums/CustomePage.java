package com.example.demo.enums;


import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class CustomePage<T> extends PageImpl<T> {

    public CustomePage(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);

    }

    public CustomePage(List<T> content) {
        super(content);
    }

    @Override
    public int getTotalPages() {
        return super.getTotalPages();
    }
    @Override
    public long getTotalElements() {
        return super.getTotalElements();
    }

    @Override
    public boolean hasNext() {
        return super.hasNext();
    }

    @Override
    public boolean isLast() {
        return super.isLast();
    }

    @Override
    public Pageable nextPageable() {
        return super.nextPageable();
    }

    @Override
    public Pageable previousPageable() {
        return super.previousPageable();
    }

    @Override
    public boolean hasContent() {
        return super.hasContent();
    }

    @Override
    public int getNumber() {
        return super.getNumber();
    }
    @Override
    public int getSize() {
        return super.getSize();
    }
    @Override
    public int getNumberOfElements() {
        return super.getNumberOfElements();
    }

    @Override
    public boolean hasPrevious() {
        return super.hasPrevious();
    }

    @Override
    public boolean isFirst() {
        return super.isFirst();
    }
    @Override
    public List<T> getContent() {
        return super.getContent();
    }

    @Override
    public Sort getSort() {
        return super.getSort();
    }
}
