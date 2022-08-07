package principal;

import java.sql.Connection;
import java.util.Scanner;

import entities.enseignant;
import entities.etudiant;
import entities.admin;

public class gestion_noteApplication {


	private static Scanner scan;

	public static void main(String[] args) {
			
		String URL = "jdbc:mysql://localhost:3306/gestion_note";
		String ClassName = "con.mysql.jdbc.Driver";
		connexion con = new connexion(URL, "root", "", ClassName);
        Connection connexion = con.connectToDB();
        if(connexion == null) {
        	System.out.println("Connexion timed out");
        }else {
        	System.out.println("CONNECTED");
        }
	
		int choix;
		scan = new Scanner(System.in);
		
		System.out.println(" -----------------------  Bienvenu(e) sur votre Gestionnaire de notes -----------------------\n");
									
		System.out.println("Veuillez faire un choix d'action pour continuer");
									
		System.out.println("1-Action sur les Etudiants \n2-Action sur les Enseignants \n3-Actions sur les UE\n4-Page Etudiant \n5-Page Enseignant \n");
		
		choix = scan.nextInt();
		
		switch(choix) {
		case 1:
			admin admin = new admin();
			admin.ManageEntityNamed("etudiant");
			break;
		case 2:
			admin administrator = new admin();
			administrator.ManageEntityNamed("enseignant");
			break;
		case 3:
			admin mananger = new admin();
			mananger.ManageEntityNamed("UE");
			break;
		case 4:
			int action;
			etudiant etudiant = new etudiant();
		    Scanner sc = new Scanner(System.in);
			System.out.println("-------------------------------- Bienvenu(e) sur la page etudiant  ----------------\n");
			System.out.println("Que voulez vous faire: \n");
			System.out.println("1-Consultation \n2-Reclamation\n");
			action = sc.nextInt();
			etudiant.actions(action);
			break;
		case 5:
			enseignant enseignant = new enseignant();
			enseignant.Manage("etudiant");
			break;
			
		default:
			 
			System.out.println("Aucune action choisie!");
		}
	}

}
