package com.example.demo.entity.userModel;

import com.example.demo.enums.UserSexEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
//entity标识了这个类是一个实体类，这样hidernate就能够找到这个类，并将这个表与数据库的表进行映射或者创建。
@Entity

public class UserInfo implements  Serializable{
    //id标识标识uid变量是这个UserInfo表的key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uid;
    //这里表示设定username列为不重复的列
    @Column(unique =true)
    private String username;//帐号
    private String name;//名称（昵称或者真实姓名，不同系统不同定义）
    private String password; //密码;
    private String salt;//加密密码的盐
    private byte state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
    @ManyToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<SysRole> roleList;// 一个用户具有多个角色
    private long createtime;
    private long agencyId;
    private UserSexEnum sex;

    public long getCreatetime() {
        return createtime;
    }
    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }


    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    /**
     * 密码盐.
     * @return
     */
//    public String getCredentialsSalt(){
//        return this.username+this.salt;
//    }

    public long getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(long agencyId) {
        this.agencyId = agencyId;
    }

    public UserSexEnum getSex() {
        return sex;
    }

    public void setSex(UserSexEnum sex) {
        this.sex = sex;
    }

    //重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解
}