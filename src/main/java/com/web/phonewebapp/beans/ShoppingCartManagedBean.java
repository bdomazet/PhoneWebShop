package com.web.phonewebapp.beans;

import com.web.phonewebapp.entity.Articles;
import com.web.phonewebapp.entity.Bill;
import com.web.phonewebapp.entity.facade.ArticlesFacadeLocal;
import com.web.phonewebapp.entity.facade.BillFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "shoppingCartManagedBean")
@SessionScoped
public class ShoppingCartManagedBean implements Serializable{
    
    private List<Articles> cart = new ArrayList<>();
    private int amount;
    
    @Inject
    ArticlesFacadeLocal articlesFacadeLocal;
    
    @Inject
    BillFacadeLocal billFacadeLocal;
    
    public ShoppingCartManagedBean(){
        
    }

    public List<Articles> getCart() {
        return cart;
    }

    public void setCart(List<Articles> cart) {
        this.cart = cart;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public String addToCart(Articles article){
        cart.add(new Articles(article.getId(), article.getName(), amount, article.getPricePerUnit()));
        return "index";
    }
    
    public String buy(){
        String billContent = "";
        Date date = new Date();
        Double totalPrice = 0.0;
        for(Articles article : cart){
            billContent += article.getId() + " " + article.getName() + " " + article.getAmount() + " " + article.getPricePerUnit() + " -: " + article.getAmount()*article.getPricePerUnit() + "\r\n";
            totalPrice += article.getAmount()*article.getPricePerUnit();
            Articles articleTemp = articlesFacadeLocal.find(article.getId());
            articleTemp.setAmount((articleTemp.getAmount()-article.getAmount()));
            articlesFacadeLocal.edit(articleTemp);
        }
        Bill bill = new Bill();
        bill.setBillContent(billContent);
        bill.setTotalPrice(totalPrice);
        bill.setCreatedAt(date);
        billFacadeLocal.create(bill);
        return "index";
    }
    
    
}
