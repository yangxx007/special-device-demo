package com.example.demo.service;

import com.example.demo.entity.data.ApplyInfo;
import org.apache.shiro.session.Session;

/**
 * @author yang
 * @create_at 2017/10/17
 **/
public interface ValidateService {

    public boolean validateForm ();


   // public boolean isApplyOwner(Subject currSubject,long apply_id);

    public void isPermission(Session session, Validatable validate);
//    public boolean isApplyAuditor (Subject currSubject,long apply_id);
//
//    public boolean isApplyAcceptor(Subject currSubject,long apply_id);
}
