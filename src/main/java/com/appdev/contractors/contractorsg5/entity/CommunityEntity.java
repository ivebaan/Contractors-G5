package com.appdev.contractors.contractorsg5.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "community")
public class CommunityEntity{

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long communityId;

       private String name;
       private String description;
       private String createdBy;
       private String dateCreated;


       public CommunityEntity(){}

       public CommunityEntity(String name, String description, String createdBy, String dateCreated){
        this.name = name;
        this.description = description;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
       }

       public void setCommunityId(Long communityId){
        this.communityId = communityId;
       }

       public Long getCommunityId(){
        return communityId;
       }

       public void setName(String name){
        this.name = name;
       }
       public String getName(){
        return name;
       }

       public void setDescription(String description){
        this.description = description;
       }
       
       public String getDescription(){
        return description;
       }

       public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
       }
       public String getCreatedBy(){
        return createdBy;
       }

       public void setDateCreated(String dateCreated){
        this.dateCreated = dateCreated;
       }
       public String getDateCreated(){
        return dateCreated;
       }
}