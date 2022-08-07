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
import entities.etudiant;
import principal.connexion;
/**
 *
 * @author CESAR
 */
public class etudiantService {
   	public boolean EnregistrerEtudiant(etudiant etudiant) {
		connexion connect = new connexion("jdbc:mysql://localhost:3306/gestion_note", "root", "", "con.mysql.jdbc.Driver");
		Connection con = connect.connectToDB();
		if(con != null) {
			try {
				String sql = "INSERT INTO etudiants(nom, prenom, sexe, username, password) VALUES ('"+etudiant.getNom()+"','"+etudiant.getPrenom()+"','"+etudiant.getSexe()+"','"+etudiant.getUsername()+"','"+etudiant.getPassword()+"')";
				Statement stat = con.createStatement();
				System.out.println("Ajout effectué avec succes!!");
				stat.executeUpdate(sql);
				return true;
					
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		return false;	
	}
    public etudiant getId() {
	connexion connect = new connexion("jdbc:mysql://localhost:3306/gestion_note", "root", "", "con.mysql.jdbc.Driver");
		Connection con = connect.connectToDB();
			try {
				Statement stat = con.createStatement();
				String sql = "SELECT * FROM etudiants";
				ResultSet resultat = stat.executeQuery(sql);
				List<etudiant> etudiant = new ArrayList<etudiant>();
				etudiant etud = null;
				while(resultat.next()) {
					etud = new etudiant();
					etud.setId(resultat.getInt("id"));
					etud.setNom(resultat.getString("nom"));
					etud.setPrenom(resultat.getString("prenom"));
					etudiant.add(etud);
					System.out.println(etud);
				}			
			}catch(Exception e) {
				e.printStackTrace();
			}
			return null;
	}
    public etudiant getById(int id) {
		connexion connect = new connexion("jdbc:mysql://localhost:3306/gestion_note", "root", "", "con.mysql.jdbc.Driver");
		Connection con = connect.connectToDB();
		try {
			Statement stat = con.createStatement();
			String sql = "SELECT id, nom, prenom FROM etudiants WHERE id="+id;
			ResultSet resultat = stat.executeQuery(sql);
			etudiant etud = null; 
			while(resultat.next()) {
				etud = new etudiant();
				etud.setId(resultat.getInt("id"));
				etud.setNom(resultat.getString("nom"));
				etud.setPrenom(resultat.getString("prenom"));
			}
			return etud;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
    	
    }
	public etudiant verifUser(int id) {
		connexion connect = new connexion("jdbc:mysql://localhost:3306/gestion_note", "root", "", "con.mysql.jdbc.Driver");
		Connection con = connect.connectToDB();
		try {
			Statement stat = con.createStatement();
			String sql = "SELECT username, password FROM etudiants WHERE id="+id;
			ResultSet resultat = stat.executeQuery(sql);
			etudiant etud = null;
			System.out.println(resultat);
			while(resultat.next()) {
				etud = new etudiant();
				etud.setUsername(resultat.getString("username"));
				etud.setPassword(resultat.getString("password"));
			}
            return etud;
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return null;
    	
    } 
    
    
    
}
