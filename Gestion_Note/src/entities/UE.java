/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author CESAR
 */
public class UE {
    
    private String nom_UE;
    private String code_UE;
    private int credit;
    
    public void setNom_UE(String nom_UE){
        this.nom_UE = nom_UE;
    }
    
    
    public String getNom_UE(){
        return nom_UE;
    }
    
    
    public void setCode_UE(String code_UE){
        this.code_UE = code_UE;
    }  
    
    
    
    public String getCode_UE(){
        return code_UE;
    }
    
    
     public void setCredit(int credit){
        this.credit = credit;
    }
     
     

     public int getCredit(){
        return credit;
    }
     
    
	public String toString(){
		return "Ue [Code_Ue="+ code_UE +", nom_UE="+nom_UE+", Credits="+ credit+"]";				
    }


}
