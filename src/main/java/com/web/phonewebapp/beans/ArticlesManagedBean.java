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
    private Integer articleId = null;
    private String articleName = null;
    private int articleAmount = 0;
    private double articlePrice = 0.0;

    @Inject
    ArticlesFacadeLocal articlesFacadeLocal;

    @PostConstruct
    private void init() {
        _articlesList = articlesFacadeLocal.findAll();
    }

    public ArticlesManagedBean() {

    }

    public List<Articles> getArticlesList() {
        return _articlesList;
    }

    public void setArticlesList(List<Articles> _articlesList) {
        this._articlesList = _articlesList;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public int getArticleAmount() {
        return articleAmount;
    }

    public void setArticleAmount(int articleAmount) {
        this.articleAmount = articleAmount;
    }

    public double getArticlePrice() {
        return articlePrice;
    }

    public void setArticlePrice(double articlePrice) {
        this.articlePrice = articlePrice;
    }

    public String removeArticle(Integer articleId) {
        Articles articleTemp = articlesFacadeLocal.find(articleId);
        articlesFacadeLocal.remove(articleTemp);
        return "index";
    }

    public String updateArticle() {
        Articles articleTemp = articlesFacadeLocal.find(articleId);
        if (articleTemp != null) {
            articleTemp.setName(articleName);
            articleTemp.setAmount(articleAmount);
            articleTemp.setPricePerUnit(articlePrice);
            articlesFacadeLocal.edit(articleTemp);
            init();
        }
        return "index";
    }

        public String addArticle() {
        Articles articleTemp = new Articles(null, articleName, articleAmount, articlePrice);
        articlesFacadeLocal.create(articleTemp);
        init();
        return "admin";
    }
}
