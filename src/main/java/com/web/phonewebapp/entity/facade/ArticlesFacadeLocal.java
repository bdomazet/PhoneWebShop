/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.phonewebapp.entity.facade;

import com.web.phonewebapp.entity.Articles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author borisdom
 */
@Local
public interface ArticlesFacadeLocal {

    void create(Articles articles);

    void edit(Articles articles);

    void remove(Articles articles);

    Articles find(Object id);

    List<Articles> findAll();

    List<Articles> findRange(int[] range);

    int count();
    
}
