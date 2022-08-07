/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author CESAR
 */
import java.util.Scanner;

import services.enseignantService;
import services.etudiantService;
import services.evaluationService;
import services.reclamService;
import services.UEService;
public class etudiant  extends users  {

    	private Scanner sc;

	public void actions(int action) {
		etudiantService etudserv = new etudiantService();
		evaluationService Noteser = new evaluationService();
		int id;
		String username;
		String password;
		sc = new Scanner(System.in);
		switch(action) {
		case 1:
			System.out.println("---------------------- Bienvenu(e) cher Etudiant --------");
			System.out.println("------------------------ Veuillez vous authentifier pour continuer---------------------\n");
			System.out.println("Votre identifiant : ");
			id = sc.nextInt();
			System.out.println("Ok entrez votre nom d'utilisateur :");
			username = sc.nextLine();
			username = sc.nextLine();
			System.out.println("Ok indiquer votre mot de passe : ");
			password = sc.nextLine();
			
			etudiant etud = etudserv.verifUser(id);
			
			if(etud.getUsername().equals(username) && etud.getPassword().equals(password)) {
				
				System.out.println("Connected:  \t  Profil "+etud.getUsername()+"\n");
				System.out.println(" ---------Affichage des notes et les ue ----------\n");
				Noteser.getAll(id);	
			}else {
				System.out.println("Authentification failed");
			}
			
			break;
		case 2:
			String mail;
			System.out.println("---------------------- Bienvenu(e) cher Etudiant --------");
			System.out.println("------------------------ Veuillez vous authentifier pour continuer---------------------\n");
			System.out.println("Votre identifiant svp (un entier entre 0 et plus) : ");
			id = sc.nextInt();
			System.out.println("Ok renseigner votre nom d'utilisateur :");
			username = sc.nextLine();
			username = sc.nextLine();
			System.out.println("Ok indiquer votre mot de passe : ");
			password = sc.nextLine();
			
			etudiant etud1 = etudserv.verifUser(id);
			
			if((etud1.getUsername().equals(username) && etud1.getPassword().equals(password))) {
				System.out.println("Connected:  \t  Profil "+etud1.getUsername()+"\n");
				System.out.println(" --------- Formulaire de Reclamation  ----------\n");
				reclamation rec = new reclamation();
				UEService uesr = new UEService();
				enseignantService enserv = new enseignantService();
				etudiant etu = etudserv.getById(id);
				rec.setEtudiant(etu);
				
				System.out.println("Indiquer  l'unite d'enseignement dans lequel vous souhaiter reclamer: ");
				String nom_UE = sc.nextLine();
				UE u = uesr.getByNom(nom_UE);
				rec.setUe(u);
				
				
				System.out.println(" veuillez indiquer la note que vous contester");
				float note = sc.nextFloat();
				rec.setNoteConteste(note);
				
				mail = "Bonjour Monsieur Je viens vers vous faire une reclamation ,Vous avez attribuer une note dont je suis pas sur [Nom :"+etu.getNom()+", Prenom:"+etu.getPrenom()+",Note:"+note+"]";
				
				reclamService rc = new reclamService();
				rc.Addreclamation(rec,enserv.getenseignantId(u.getNom_UE()),mail);

			}
			
			break;
		default:
			System.out.println("Aucune action encours");
		}
	}

  
}
