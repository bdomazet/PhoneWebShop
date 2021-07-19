/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.phonewebapp.beans;

import com.web.phonewebapp.entity.Articles;
import com.web.phonewebapp.entity.facade.ArticlesFacadeLocal;
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
@Named(value = "articlesManagedBean")
@RequestScoped
public class ArticlesManagedBean implements Serializable {
    
    private List<Articles> _articlesList;
    
    @Inject
    ArticlesFacadeLocal articlesFacadeLocal;
    
    @PostConstruct
    private void init(){
        _articlesList = articlesFacadeLocal.findAll();
    }
    
    public ArticlesManagedBean(){
        
    }

    public List<Articles> getArticlesList() {
        return _articlesList;
    }

    public void setArticlesList(List<Articles> _articlesList) {
        this._articlesList = _articlesList;
    }
    
    
}
