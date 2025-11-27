package com.appdev.contractors.contractorsg5.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "favorites")
public class FavoritesEntity{

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long favoriteId;

       private int user_id;
       private int post_id;
       private String dateAdded;


       public FavoritesEntity(){}

       public FavoritesEntity(int user_id, int post_id, String dateAdded){
        this.user_id = user_id;
        this.post_id = post_id;
        this.dateAdded = dateAdded;
       }

       public void setFavoriteId(Long favoriteId){
        this.favoriteId = favoriteId;
       }

       public Long getFavoriteId(){
        return favoriteId;
       }

       public void setUser_id(int user_id){
        this.user_id = user_id;
       }
       public int getUser_id(){
        return user_id;
       }

       public void setPost_id(int post_id){
        this.post_id = post_id;
       }
       
       public int getPost_id(){
        return post_id;
       }

       public void setDateAdded(String dateAdded){
        this.dateAdded = dateAdded;
       }
       public String getDateAdded(){
        return dateAdded;
       }
}