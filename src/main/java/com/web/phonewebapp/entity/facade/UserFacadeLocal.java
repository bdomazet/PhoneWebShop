/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.phonewebapp.entity.facade;

import com.web.phonewebapp.entity.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author borisdom
 */
@Local
public interface UserFacadeLocal {

    void create(User user);

    void edit(User user);

    void remove(User user);

    User find(Object id);

    public User findByUsername(String username);

    List<User> findAll();

    List<User> findRange(int[] range);

    int count();

}
