package com.example.demo.service.multiSearch;

import com.example.demo.enums.CustomePage;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class MultiSearch<T> {
    private Object conditions;

    public MultiSearch(Object conditions){
        this.conditions=conditions;
    }
//    public Pageable getPageable(Sort sort){
//        return new PageRequest(conditions.getPage(),conditions.getSize(),sort);
//    }
    public CustomePage<T> result(List<T> listObject, Pageable pageable)throws Exception{
        int start = pageable.getOffset();
        int end = (start + pageable.getPageSize()) > listObject.size() ? listObject.size() : (start + pageable.getPageSize());
        return new CustomePage<T>(listObject.subList(start,end),pageable,listObject.size());

    }

    public abstract List<T> searchByConditions(EntityManager em) throws Exception;
}
