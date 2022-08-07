/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entities.UE;
import principal.connexion;
/**
 *

 * @author CESAR
 */
public class UEService {
    	public boolean AddUe(UE ue) {
		connexion con = new connexion ("jdbc:mysql://localhost:3306/gestion_note", "root", "", "con.mysql.jdbc.Driver");
		Connection connexion = con.connectToDB();
		if(connexion != null) {
			try {
				String sql = "INSERT INTO ue(code_UE, nom_UE, credit) VALUES('"+ue.getCode_UE()+"','"+ue.getNom_UE()+"','"+ue.getCredit()+"')";
				Statement stat = connexion.createStatement();;
				stat.executeUpdate(sql);
				return true;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
		return false;
	}
	public UE getByNom(String nom_UE){
		connexion con = new connexion ("jdbc:mysql://localhost:3306/gestion_note", "root", "", "con.mysql.jdbc.Driver");
		Connection connexion = con.connectToDB();
		try {
			Statement stat = connexion.createStatement();
			String sql ="SELECT * FROM ue WHERE nom_UE='"+nom_UE+"'";
			ResultSet resultat = stat.executeQuery(sql);
			List<UE> ues = new ArrayList<UE>();
			UE u = null;
			while(resultat.next()) {
				u = new UE();
				u.setCode_UE(resultat.getString("code_Ue"));
				u.setNom_UE(resultat.getString("nom_UE"));
				u.setCredit(resultat.getInt("credit"));
				ues.add(u);
			}
			if(!ues.isEmpty()) {
				int i;
				for(i=0; i<ues.size(); i++) {
					System.out.println(u);
					return u;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

   
}

    
