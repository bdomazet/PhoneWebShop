/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.phonewebapp.entity.facade;

import com.web.phonewebapp.entity.Articles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author borisdom
 */
@Stateless
public class ArticlesFacade extends AbstractFacade<Articles> implements ArticlesFacadeLocal {

    @PersistenceContext(unitName = "WAP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticlesFacade() {
        super(Articles.class);
    }
    
}
