/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.phonewebapp.beans;

import com.web.phonewebapp.entity.Privilege;
import com.web.phonewebapp.entity.User;
import com.web.phonewebapp.entity.facade.PrivilegeFacadeLocal;
import com.web.phonewebapp.entity.facade.UserFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author borisdom
 */
@Named(value = "userManagedBean")
@SessionScoped
public class UserManagedBean implements Serializable {

    private List<User> _userList;
    private String usernameInput;
    private String passwordInput;
    private int roleId;
    private int privilegeTemp;

    @Inject
    UserFacadeLocal userFacadeLocal;

    @PostConstruct
    private void init() {
        _userList = userFacadeLocal.findAll();
    }
    
    @Inject
    PrivilegeFacadeLocal privilegeFacadeLocal;

    public UserManagedBean() {

    }

    public String getUsernameInput() {
        return usernameInput;
    }

    public void setUsernameInput(String usernameInput) {
        this.usernameInput = usernameInput;
    }

    public String getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(String passwordInput) {
        this.passwordInput = passwordInput;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPrivilegeTemp() {
        return privilegeTemp;
    }
    
    public String login() {
        User user = userFacadeLocal.findByUsername(usernameInput);
        if(user==null){
            return "login";
        }
        if (usernameInput != null && passwordInput != null) {
            if (user.getUsername() != null && user.getPassword() != null) {
                if (usernameInput.equals(user.getUsername()) && passwordInput.equals(user.getPassword())) {
                    privilegeTemp = user.getIdPrivilege().getId();
                }
            }
        }
        if (privilegeTemp == 1) {
            return "admin";
        } else if (privilegeTemp == 2) {
            return "editor";
        } else {
            return "";
        }
    }
    
        public String register() {
        User user = new User();
        Privilege privilege = privilegeFacadeLocal.find(roleId);
        user.setIdPrivilege(privilege);
        user.setUsername(usernameInput);
        user.setPassword(passwordInput);
        userFacadeLocal.create(user);
        return "login";
    }

}
