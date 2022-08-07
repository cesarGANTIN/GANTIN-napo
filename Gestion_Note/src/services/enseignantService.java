/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import entities.enseignant;
import principal.connexion;

/**
 *
 * @author CESAR
 */
public class enseignantService {
    
    public boolean AddEnseignant(enseignant enseignant) {
		connexion con = new connexion ("jdbc:mysql://localhost:3306/gestion_note", "root", "", "con.mysql.jdbc.Driver") ;
		Connection connectDB = con.connectToDB();
		if(connectDB != null) {
			try {
				String sql = "INSERT INTO enseignants(nom, prenom, sexe, username, password, code_ue) VALUES('"+enseignant.getNom()+"','"+enseignant.getPrenom()+"','"+enseignant.getSexe()+"','"+enseignant.getUsername()+"','"+enseignant.getPassword()+"','"+enseignant.getUE().getCode_UE()+"')";
				Statement stat = connectDB.createStatement();
				stat.executeUpdate(sql);
				System.out.println("Succesfull");
				return true;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
		return false;
	}
	
	public enseignant verifUser(int id) {
		connexion connect = new connexion("jdbc:mysql://localhost:3306/gestion_note", "root", "", "con.mysql.jdbc.Driver");
		Connection con = connect.connectToDB();
		try {
			Statement stat = con.createStatement();
			String sql = "SELECT username, password FROM enseignants WHERE id="+id;
			ResultSet resultat = stat.executeQuery(sql);
			enseignant enseignant = null;
			while(resultat.next()) {
				enseignant = new enseignant();
				enseignant.setUsername(resultat.getString("username"));
				enseignant.setPassword(resultat.getString("password"));
			}
            return enseignant;
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return null;
    	
    }
	public int getenseignantId(String refUE) {
		connexion connect = new connexion("jdbc:mysql://localhost:3306/gestion_note", "root", "", "con.mysql.jdbc.Driver");
		Connection con = connect.connectToDB();
		try {
			Statement stat = con.createStatement();
			String sql = "SELECT id FROM enseignants WHERE code_ue='"+refUE+"'";
			ResultSet resultat = stat.executeQuery(sql);
			while(resultat.next()) {
				int Identifiant = resultat.getInt("id");
				return Identifiant;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	return 0;
  }
	public void consulterInbox(int Id) {
	connexion connect = new connexion("jdbc:mysql://localhost:3306/gestion_note", "root", "", "con.mysql.jdbc.Driver");
		Connection con = connect.connectToDB();
		try {
			Statement stat = con.createStatement();
			String sql = "SELECT contenu FROM inbox WHERE Id_enseignant="+Id;
			ResultSet resultat = stat.executeQuery(sql);
			while(resultat.next()) {
				String Message = resultat.getString("contenu");
				System.out.println(Message);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
    
    
    
}
