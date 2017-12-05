package com.example.demo.web;

import com.example.demo.config.annotation.InfoMsg;
import com.example.demo.connector.conditions.ApplyConditions;
import com.example.demo.connector.responser.WorkFlowInfo;
import com.example.demo.connector.updater.ApplyHandler;
import com.example.demo.dao.apply.ApplySearchCondition;
import com.example.demo.dao.user.UserDao;
import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.entity.form.Form;
import com.example.demo.entity.form.SubForm;
import com.example.demo.entity.messager.BaseMessager;
import com.example.demo.entity.user.UserInfo;
import com.example.demo.enums.*;
import com.example.demo.service.*;
import com.example.demo.service.exception.CustomException;
import com.example.demo.service.utils.UtilServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author yang
 * @create_at 2017/10/17
 **/
//controller标识这个程序是controller
//requestMapping 标识url路径如http://***.com/admin
// requirespermissions 标识当前用户需要怎样的权限才能访问这个url
@Controller
@RequestMapping("/admin")
@RequiresPermissions(value = {"user:acceptor","user:approver"},logical = Logical.OR)
public class AdminController extends BaseController {
    //autowired 标识这个变量是一个接口变量，并且会自动在标识有service的实现类中自动继承
    @Autowired
    private UserService userSevice;

    @RequestMapping("/websocket")
    public String websocket() {
        return "websocket2";
    }

    @RequestMapping("/async")
    @ResponseBody
    public Callable<String> callable() {
        return () -> {
            Thread.sleep(1000);
            return "hello";
        };
    }



    // @InfoMsg(msgType = MsgType.申请通过通知)
    @RequestMapping("/test")
    @ResponseBody
    public ApplyInfo test(@RequestParam("test") String test) throws Exception {
        ApplyInfo applyInfo = new ApplyInfo();
        applyInfo.setId(1000);
        applyInfo.setOwnerId(1);
        System.out.println(getSession().getId());
        getSession().setAttribute(Constants.PROCESSING_APPLY_ID, Long.parseLong(test));

        //  ((AdminController)AopContext.currentProxy()).approveApply(applyInfo);
        //template.convertAndSend("/topic/aaa",new BaseMessager("bomb","bomb","07-11"));
        return applyInfo;
    }

    @RequestMapping("/user/all")
    //responsebody标识是直接返回字符串，没有标识返回对应名字的html
    public @ResponseBody
    List<UserInfo> getUserList() {
        return userSevice.findAll();
    }


    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public @ResponseBody
    UserInfo getUserByUsername(@PathVariable("username") String username) {
        return userSevice.findByUsername(username);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody
    List<UserInfo> getUserBysex(@RequestParam(name = "sex") UserSexEnum sex) {
        return null;
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public @ResponseBody
    Integer deleteUserByUidandUsername(@RequestParam(name = "username", required = false) String username,
                                       @RequestParam(name = "uid", defaultValue = "0", required = false) Long uid) {

        return userSevice.deleteUserByUsernameOrUid(username, uid);
    }

    //requestbody标识是指请求体，如果请求体是json数据直接就将其赋给userinfo或其他类如下，直接就可以转化为类了
    @RequestMapping(value = "/userlist", method = RequestMethod.PUT)
    public @ResponseBody
    boolean createUserList(@RequestBody List<UserInfo> userInfos) {
        try {
            userSevice.createUserList(userInfos);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public @ResponseBody
    boolean updateUser(@RequestBody UserInfo userInfo) {
        try {
            userSevice.updateUser(userInfo);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @RequestMapping(value = "/user/page", method = RequestMethod.GET)
    public @ResponseBody
    Page<UserInfo> getUserByUidandUsernameInpage(@RequestParam(name = "page", defaultValue = "0") Integer
                                                         page,
                                                 @RequestParam(name = "size", defaultValue = "0") Integer size) {
        Sort sort = new Sort(Sort.Direction.ASC, "uid");
        Pageable pageable = new PageRequest(page, size, sort);
        return userSevice.findAllInPage(pageable);

    }


    @RequestMapping("/logout")
    public @ResponseBody
    String logout() {
        SecurityUtils.getSubject().logout();
        return "0";
    }


//    @RequestMapping("/usertest")
//    public @ResponseBody
//    List<UserInfo> getUsers(@RequestParam(name = "name") String name, @RequestParam(name = "start")
//            JSONArray json)throws Exception {
//        return userSevice.finduserfortest(name, json.getLong(0), json.getLong(1));
//    }

    @Autowired
    private UserStatusService statusService;
    @Autowired
    @Qualifier(value = "productEntityManager")
    private EntityManager em;


    public JsonResponse getApplies(@RequestBody ApplyConditions applyConditions) throws Exception {
        UserInfo user = statusService.getCurrUser(getSession());
        applyConditions.setAgencyId(user.getAgencyId());
        ApplySearchCondition searchCondition = new ApplySearchCondition(applyConditions);
        Pageable pageable = new PageRequest(applyConditions.getPage(), applyConditions.getSize(), applyConditions.getSort());
        CustomePage<WorkFlowInfo> applyInfos = searchCondition.result(searchCondition.convert2Workflow(em), pageable);
        return new JsonResponse(200, null, applyInfos);
    }

    @RequestMapping(value = "/unacceptedApplies/get", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse getUnacceptedApplies(@RequestBody ApplyConditions applyConditions) throws Exception {
        int[] a = {1};
        applyConditions.setStates(a);
        applyConditions.setRole(RoleTypeEnum.受理人员);
        return getApplies(applyConditions);
    }

    @RequestMapping(value = "/acceptedApplies/get", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse getAcceptedApplies(@RequestBody ApplyConditions applyConditions) throws Exception {
        int[] a = {2, 4};
        applyConditions.setStates(a);
        applyConditions.setRole(RoleTypeEnum.受理人员);
        return getApplies(applyConditions);
    }

    @RequestMapping(value = "/unapprovedApplies/get", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse getUnapprovedApplies(@RequestBody ApplyConditions applyConditions) throws Exception {
        int[] a = {2};
        applyConditions.setStates(a);
        applyConditions.setRole(RoleTypeEnum.审批人员);
        return getApplies(applyConditions);
    }

    @RequestMapping(value = "/approvedApplies/get", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse getapprovedApplies(@RequestBody ApplyConditions applyConditions) throws Exception {
        int[] a = {3, 5};
        applyConditions.setStates(a);
        applyConditions.setRole(RoleTypeEnum.审批人员);
        return getApplies(applyConditions);
    }

    @Autowired
    private ApplyService applyService;

    @RequestMapping("/apply/get")
    @Transactional
    public @ResponseBody
    JsonResponse getApply(@RequestParam("applyId") long applyId) {
        ApplyInfo applyInfo = applyService.findByApplyID(applyId, getSession());
        if (applyInfo == null || applyInfo.isProcessing() == true) {
            throw new CustomException("Apply Not found,please refresh the browser");
        }
        getSession().setAttribute(Constants.PROCESSING_APPLY_ID, applyId);
        for (Form form : applyInfo.getFormList()) {
            new JSONObject(form).toString();
        }
        return new JsonResponse(200, null, applyInfo);
    }
    @RequiresPermissions("user:acceptor")
    @RequestMapping("/apply/accept")
    @Transactional
    @InfoMsg(msgType = ReminderTypeEnum.申请通过受理)
    public @ResponseBody
    JsonResponse acceptApply(@RequestBody ApplyHandler handler) throws Exception {

        if (getSession().getAttribute(Constants.PROCESSING_APPLY_ID) != null) {
            handler.setApplyId((long) getSession().getAttribute(Constants.PROCESSING_APPLY_ID));
            getSession().removeAttribute(Constants.PROCESSING_APPLY_ID);

        }
        System.out.println(handler.getPass());
        ApplyInfo applyInfo = applyService.findByApplyID(handler.getApplyId(), SecurityUtils.getSubject().getSession());
        for (Form form : applyInfo.getFormList()) {
            for (SubForm subForm : form.getSubList()) {
                new JSONObject(subForm).toString();
            }
        }
        if (applyInfo.isProcessing()) {

            if (handler.getPass()) {
                applyInfo = ((AdminController) AopContext.currentProxy()).acceptApply(applyInfo);
            } else {
                applyInfo = ((AdminController) AopContext.currentProxy()).rejectAcceptApply(applyInfo, handler);
            }
        }
        if(!applyInfo.isProcessing()){
            throw new CustomException("please refresh your browser");
        }
        applyInfo.getStatus().setAcceptorName(statusService.getCurrUsername(getSession()));
        System.out.println(new JSONObject(applyInfo));
        applyService.saveApply(applyInfo, SecurityUtils.getSubject().getSession());
        return new JsonResponse();
    }

    @Autowired
    private Apply2DeviceService apply2DeviceService;
    @RequiresPermissions("user:approver")
    @RequestMapping("/apply/approve")
    @Transactional
    public @ResponseBody
    JsonResponse approveApply(@RequestBody ApplyHandler handler) throws Exception {

        if (getSession().getAttribute(Constants.PROCESSING_APPLY_ID) != null) {
            handler.setApplyId((long) getSession().getAttribute(Constants.PROCESSING_APPLY_ID));
            getSession().removeAttribute(Constants.PROCESSING_APPLY_ID);
        }
        System.out.println(new JSONObject(handler).toString());
        ApplyInfo applyInfo = applyService.findByApplyID(handler.getApplyId(), getSession());
        for (Form form : applyInfo.getFormList()) {
            for (SubForm subForm : form.getSubList()) {
                new JSONObject(subForm).toString();
            }
        }
        if (applyInfo.isProcessing()) {
            if (handler.getPass()) {
                applyInfo = ((AdminController) AopContext.currentProxy()).approveApply(applyInfo);
            } else {
                applyInfo = ((AdminController) AopContext.currentProxy()).rejectApproveApply(applyInfo, handler);
            }
        } else {
            throw new CustomException("please refresh your browser");
        }
        applyInfo.getStatus().setApproverName(statusService.getCurrUsername(getSession()));
        System.out.println(new JSONObject(applyInfo));
        applyService.saveApply(applyInfo, getSession());
        return new JsonResponse();
    }

    @InfoMsg(msgType = ReminderTypeEnum.申请审批驳回)
    public ApplyInfo rejectApproveApply(ApplyInfo applyInfo, ApplyHandler handler) throws Exception {
        applyInfo.getStatus().setStates(ApplyStatesEnum.审批驳回);
        applyInfo.getStatus().setUnApprovalDate(UtilServiceImpl.getLongCurrTime());
        apply2DeviceService.apply2Device(applyInfo, false, getSession());
        applyInfo.getStatus().setUnApprovalReason(handler.getReason());
        applyInfo.getStatus().setUnApprovalDetailReason(handler.getDetailReason());
        return applyInfo;
    }

    @InfoMsg(msgType = ReminderTypeEnum.申请通过审批)
    public ApplyInfo approveApply(ApplyInfo applyInfo) throws Exception {
        applyInfo.getStatus().setStates(ApplyStatesEnum.已审批通过);
        applyInfo.getStatus().setApprovalDate(UtilServiceImpl.getLongCurrTime());
        apply2DeviceService.apply2Device(applyInfo, true, getSession());
        return applyInfo;
    }

    public ApplyInfo acceptApply(ApplyInfo applyInfo) {
        applyInfo.getStatus().setStates(ApplyStatesEnum.已受理待审批);
        applyInfo.getStatus().setAcceptTellDate(UtilServiceImpl.getLongCurrTime());
        return applyInfo;
    }

    @InfoMsg(msgType = ReminderTypeEnum.申请受理驳回)
    public ApplyInfo rejectAcceptApply(ApplyInfo applyInfo, ApplyHandler handler) throws Exception {
        applyInfo.getStatus().setStates(ApplyStatesEnum.受理驳回);
        applyInfo.getStatus().setUnAcceptTellDate(UtilServiceImpl.getLongCurrTime());
        apply2DeviceService.apply2Device(applyInfo, false, getSession());
        applyInfo.getStatus().setUnAcceptedReason(handler.getReason());
        applyInfo.getStatus().setUnAcceptedDetailReason(handler.getDetailReason());
        return applyInfo;
    }
    @InfoMsg(msgType = ReminderTypeEnum.已发证)
    @RequestMapping("/apply/sendRegistration")
    public @ResponseBody JsonResponse sendRegistration(@RequestParam("applyId")long applyId){
        applyService.sendRegist(applyId,getSession());
        return new JsonResponse();
    }
    @RequestMapping("/RegistedApplies/get")
    public @ResponseBody JsonResponse getRegistedApplies(@RequestBody ApplyConditions conditions)throws Exception{
        conditions.setSendRegist(true);
        return getapprovedApplies(conditions);
    }


}
