/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import entities.evaluation;
import principal.connexion;
/**
 *
 * @author CESAR
 */
public class evaluationService {
    	public boolean Addnote(evaluation note ) {
		connexion connect = new connexion("jdbc:mysql://localhost:3306/gestion_note", "root", "", "con.mysql.jdbc.Driver");
		Connection con = connect.connectToDB();
		if(con != null) {
			try {
				String sql = "INSERT INTO evaluation(id_etudiant, code_UE, note_obtenue) VALUES('"+note.getEtudiants().getId()+"','"+note.getUes().getCode_UE()+"','"+note.getNote()+"')";
				Statement stat = con.createStatement();
				System.out.println("Effecutué avec succes");
				stat.executeUpdate(sql);
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
		
		
	}
	
	public List<evaluation> getAll(int id) {
		connexion connect = new connexion("jdbc:mysql://localhost:3306/gestion_note", "root", "", "con.mysql.jdbc.Driver");
		Connection con = connect.connectToDB();
		if(con != null) {
			try {
				Statement stat = con.createStatement();
				String sql = "SELECT * FROM evaluation WHERE id_etudiant="+id;
				ResultSet data = stat.executeQuery(sql);
				while(data.next()){
					String Unite_Enseignement = data.getString("code_UE");
					float Note_obtenue = data.getFloat("note");
					
					System.out.println("Unite d'enseignement \t: " +Unite_Enseignement);
					System.out.println("Votre note \t:" + Note_obtenue);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
		
	}
	public List<evaluation> getByCodeUE(int id, String code_UE) {
		connexion connect = new connexion("jdbc:mysql://localhost:3306/gestion_note", "root", "", "con.mysql.jdbc.Driver");
		Connection con = connect.connectToDB();
		if(con != null) {
			try {
				Statement stat = con.createStatement();
				String sql = "SELECT * FROM evaluation WHERE id_etudiant="+id+" and code_UE='"+code_UE+"'";
				ResultSet data = stat.executeQuery(sql);
				while(data.next()){
					String Unite_Enseignement = data.getString("code_UE");
					float Note_obtenue = data.getFloat("note");
					
					System.out.println("Unite d'enseignement \t: " +Unite_Enseignement);
					System.out.println("Votre note \t:" + Note_obtenue);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
		
	}

    
}
