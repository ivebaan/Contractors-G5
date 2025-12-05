package com.appdev.contractors.contractorsg5.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "favorites")
public class FavoritesEntity{

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long favoriteId;

       private int userId;
       private int postId;
       private String dateAdded;


       public FavoritesEntity(){}

       public FavoritesEntity(int userId, int postId, String dateAdded){
        this.userId = userId;
        this.postId = postId;
        this.dateAdded = dateAdded;
       }

       public void setFavoriteId(Long favoriteId){
        this.favoriteId = favoriteId;
       }

       public Long getFavoriteId(){
        return favoriteId;
       }

       public void setUser_id(int userId){
        this.userId = userId;
       }
       public int getUser_id(){
        return userId;
       }

       public void setPost_id(int postId){
        this.postId = postId;
       }
       
       public int getPost_id(){
        return postId;
       }

       public void setDateAdded(String dateAdded){
        this.dateAdded = dateAdded;
       }
       public String getDateAdded(){
        return dateAdded;
       }
}