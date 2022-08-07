/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entities.reclamation;
import principal.connexion;
/**
 *
 * @author CESAR
 */
public class reclamService {
    	public boolean Addreclamation(reclamation reclam, int enseignant_id, String text) {
	connexion connect = new connexion("jdbc:mysql://localhost:3306/gestion_note", "root", "", "con.mysql.jdbc.Driver");
		Connection con = connect.connectToDB();
		if(con != null) {
			try {
				String sql = "INSERT INTO reclamations(id_etudiant, Code_UE,NoteConteste) VALUES('"+reclam.getEtudiant().getId()+"','"+reclam.getUe().getCode_UE()+"','"+reclam.getNoteConteste()+"')";
				String sql1 = "INSERT INTO inbox (Id_enseignant, Contenu) VALUES('"+enseignant_id+"','"+text+"')";
				Statement stat = con.createStatement();
				Statement stat1 = con.createStatement();
				System.out.println("Votre reclamation a ete recu avec succes !!");
				stat.executeUpdate(sql);
				stat1.executeUpdate(sql1);
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
		
		
	}
	public reclamation getById(int id) {
	connexion connect = new connexion("jdbc:mysql://localhost:3306/gestion_note", "root", "", "con.mysql.jdbc.Driver");
		Connection con = connect.connectToDB();
		if(con != null) {
			try {
				Statement stat = con.createStatement();
				String sql = "SELECT * FROM reclamations WHERE id_etudiant="+id;
				ResultSet data = stat.executeQuery(sql);
				while(data.next()){
					String Unite_Enseignement = data.getString("Code_UE");
					float Note_obtenue = data.getFloat("NoteConteste");
					
					System.out.println("Unite d'enseignement \t: " +Unite_Enseignement);
					System.out.println("Votre note que contest� \t:" + Note_obtenue);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
		
	}
}
