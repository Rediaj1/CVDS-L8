package com.game.beans;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.springframework.stereotype.Component;

@Component
@ManagedBean
@ApplicationScoped
public class userBean {
   private String name;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}