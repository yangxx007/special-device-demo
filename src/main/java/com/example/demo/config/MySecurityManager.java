package com.example.demo.config;


import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.hibernate.annotations.Source;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by yang on 2017/9/9.
 */
public class MySecurityManager  extends DefaultWebSecurityManager{
    @Autowired
    private SessionDAO sessionDAO;


    @Override
    protected void onSuccessfulLogin(AuthenticationToken token, AuthenticationInfo info, Subject subject) {
        String username=(String)token.getPrincipal();
        Collection<Session> sessions = this.sessionDAO.getActiveSessions();//获取当前已登录的用户session列表
        //System.out.println("onsucessfullogin");
        Session currSession=subject.getSession();

            for(Session session:sessions){
//清除该用户以前登录时保存的session
            if((username.equals(String.valueOf(session.getAttribute(DefaultSubjectContext
                    .PRINCIPALS_SESSION_KEY))))&&(!currSession.getId().equals(session.getId()))
                    ) {
                sessionDAO.delete(session);
                break;
            }
        }
        super.onSuccessfulLogin(token, info, subject);
    }
}
