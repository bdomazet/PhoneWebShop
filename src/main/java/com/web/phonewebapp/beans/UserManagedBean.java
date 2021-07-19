/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.phonewebapp.beans;

import com.web.phonewebapp.entity.User;
import com.web.phonewebapp.entity.facade.UserFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author borisdom
 */
@Named(value = "UserManagedBean")
@RequestScoped
public class UserManagedBean implements Serializable{
    
    private List<User> _userList;
    
    @Inject
    UserFacadeLocal userFacadeLocal;
    
    @PostConstruct
    private void init(){
        _userList = userFacadeLocal.findAll();
    }
    
    public UserManagedBean(){
        
    }
    
}
