package com.example.demo.service;

import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.ApplyStatus;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by yang on 2017/7/27.
 */
public interface ApplyService {
    public ApplyInfo findByApplyID(Long ID);
    public Page<ApplyInfo> findApplyInfosForUser(long user_id, long device_id, long before, long after, Pageable pageable);
    public List<ApplyStatus> findByApplierName(String username);
    public List<ApplyStatus> findAllApply();
    public void createApply(ApplyInfo apply);
    public Page<ApplyInfo> findstream(long id,long start,long end,Pageable pageable);
    public ApplyStatus findApplyStatusByApplyId(long apply_id);
    void delApply(ApplyInfo applyInfo);
}
