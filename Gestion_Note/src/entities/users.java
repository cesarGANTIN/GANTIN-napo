/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author CESAR
 */
public class users {
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String sexe;
    private String username;
    private String password ;
    
    
       public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNom(){
        return nom;
    }
    
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getPrenom(){
        return prenom;
    }
    public void setAge(int age){
        this.age = age;
    }
      public int  getAge(){
        return age;
    }
        public void setSexe(String sexe){
        this.sexe = sexe;
    }
          public String  getSexe(){
        return sexe;
    }
            
    public void setUsername(String username){
        this.username = username;
    }
    
     public String getUsername(){
         return username;
     }
     
     public void setPassword(String password){
         this.password= password;
     }
     public String getPassword(){
         return password;
     }
     public String toString(){
		return "User [id ="+ id +", Nom="+ nom+",Prenom="+ prenom+"]";				
    }
	
    
}
