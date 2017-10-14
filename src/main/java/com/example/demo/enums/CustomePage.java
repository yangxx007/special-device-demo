package com.example.demo.enums;


import com.example.demo.service.view.View;
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
    @JsonView(View.ApplyForView.class)
    public int getTotalPages() {
        return super.getTotalPages();
    }
    @JsonView(View.ApplyForView.class)
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

    @JsonView(View.ApplyForView.class)
    @Override
    public int getNumber() {
        return super.getNumber();
    }
    @JsonView(View.ApplyForView.class)
    @Override
    public int getSize() {
        return super.getSize();
    }
    @JsonView(View.ApplyForView.class)
    @Override
    public int getNumberOfElements() {
        return super.getNumberOfElements();
    }

    @Override
    public boolean hasPrevious() {
        return super.hasPrevious();
    }

    @JsonView(View.ApplyForView.class)
    @Override
    public boolean isFirst() {
        return super.isFirst();
    }
    @JsonView(View.ApplyForView.class)
    @Override
    public List<T> getContent() {
        return super.getContent();
    }

    @Override
    public Sort getSort() {
        return super.getSort();
    }
}
