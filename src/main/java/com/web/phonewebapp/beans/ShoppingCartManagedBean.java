package com.web.phonewebapp.beans;

import com.web.phonewebapp.entity.Articles;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "shoppingCartManagedBean")
@SessionScoped
public class ShoppingCartManagedBean implements Serializable{
    
    private List<Articles> cart = new ArrayList<>();
    private int amount;
    
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
    
    
    
}
