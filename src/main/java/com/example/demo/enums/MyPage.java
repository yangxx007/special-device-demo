package com.example.demo.enums;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Iterator;
import java.util.List;

public class MyPage<T> implements Page<T> {
    private  Page<T>    pageObj;
    public MyPage(Page<T> pageObj){
        this.pageObj=pageObj;
    }
    @Override
    public int getTotalPages() {
        return pageObj.getTotalPages();
    }
    @Override
    public long getTotalElements() {
        return pageObj.getTotalElements();
    }
    @Override
    public int getNumber() {
        return pageObj.getNumber();
    }

    @Override
    public int getSize() {
        return pageObj.getSize();
    }
    @Override
    public int getNumberOfElements() {
        return pageObj.getNumberOfElements();
    }
    @Override
    public List<T> getContent() {
        return pageObj.getContent();
    }

    @Override
    public boolean hasContent() {
        return pageObj.hasContent();
    }

    @Override
    public Sort getSort() {
        return pageObj.getSort();
    }
    @Override
    public boolean isFirst() {
        return pageObj.isFirst();
    }
    @Override
    public boolean isLast() {
        return pageObj.isLast();
    }

    @Override
    public boolean hasNext() {
        return pageObj.hasNext();
    }

    @Override
    public boolean hasPrevious() {
        return pageObj.hasPrevious();
    }

    @Override
    public Pageable nextPageable() {
        return pageObj.nextPageable();
    }

    @Override
    public Pageable previousPageable() {
        return pageObj.previousPageable();
    }

    @Override
    public <S> Page<S> map(Converter<? super T, ? extends S> converter) {
        return pageObj.map(converter);
    }

    @Override
    public Iterator<T> iterator() {
        return pageObj.iterator();
    }
}
