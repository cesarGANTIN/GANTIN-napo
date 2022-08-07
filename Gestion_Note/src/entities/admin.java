/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;
import java.util.Scanner;
import services.UEService;
import services.enseignantService;
import services.etudiantService;

/**
 *
 * @author CESAR
 */
public class admin {
    private String username;
	private String password;
  	private Scanner scan;
	private enseignant enseignant;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		username = username ;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		password = password;
	}
	
	
	public void ManageEntityNamed(String entite) {
		scan = new Scanner(System.in);
		admin admin = new admin();
		admin.setUsername("GANTIN");
		admin.setPassword("cesarSeb");
		String username;
                String password;
		int choice;
		switch(entite) {
		case "enseignant":
			setEnseignant(new enseignant());
			
			
			System.out.println("------------------    Bienvenu(e)--------------------- ");
			System.out.println(" \n \n  ");
			
			System.out.println("------------------  Veuillez vous Identifier pour la suite  -----------------");
			System.out.println(" Entrez votre Nom d'utlisateur : \n");
			username = scan.nextLine();
			System.out.println("Saisir le mot de passe : \n");
			password = scan.nextLine();
			if(admin.authentification( username , password)) {
				System.out.println("-----------  MENU -------------");
				System.out.println("1-Ajouter nouveau compte Enseignant \n2-Modifier un compte Enseignant\n");
				choice = scan.nextInt();
				switch(choice) {
				case 1:
					String valeur;
					int reponse = 0;
					
					enseignant enseign = new enseignant();
					enseignantService Enser = new enseignantService();
					UEService us = new UEService();
					do {
						System.out.println("Nom du nouveau enseignant: ");
						valeur = scan.nextLine();
						valeur = scan.nextLine();
						enseignant.setNom(valeur);
						System.out.println("le prenom de l'enseignant : ");
						valeur = scan.nextLine();
						enseignant.setPrenom(valeur);
						System.out.println("le sexe de l'enseignant: ");
						valeur = scan.nextLine();
						enseignant.setSexe(valeur);
						System.out.println("Donner un nom d'utilisateur pour cet enseignant: ");
						valeur = scan.nextLine();
						enseignant.setUsername(valeur);
						System.out.println("Donner lui un mot de passe :");
						valeur = scan.nextLine();
						enseignant.setPassword(valeur);
						System.out.println("Indiquer le nom de l'ue a attribuer a l'enseignant : ");
						valeur = scan.nextLine();
						UE u = us.getByNom(valeur);
						enseignant.setUe(u);
						
						Enser.AddEnseignant(enseignant);
						
						System.out.println("Voulez vous poursuivre?: ");
						reponse = scan.nextInt();
						
					}while(reponse == 0);
					
					break;
				case 2:
					break;
				default:
					System.out.println("Pas d'action choisie") ;
				}
				
			}else {
				System.out.println("Authentification failed!!!!! ") ;
			}
			break;
		case "UE":
			
			System.out.println("------------------    Bienvenu(e)--------------------- ");
			System.out.println("\\n ");
			System.out.println("------------------   Veuillez vous Identifier pour continuer -----------------");
			System.out.println("votre nom d'utilisateur: \n");
			username = scan.nextLine();
			System.out.println("votre mot de passe : \n");
			password = scan.nextLine();
			if(admin.authentification(username, password)) {
				System.out.println("--------------- MENU ----------\n");
				System.out.println("1-Ajouter nouvel UE \n2-Modifier une unit� d'enseignant\n");
				choice = scan.nextInt();
				switch(choice) {
				case 1:
					String valeur;
					int reponse = 0, credit;
					UE ue = new UE();
					UEService us = new UEService();
					do {
						System.out.println("Veuillez specifier le code pour cette UE: ");
						valeur = scan.nextLine();
						valeur = scan.nextLine();
						ue.setCode_UE(valeur) ;
						System.out.println("Donner le libelle de L'unite d'enseignement : ");
						valeur = scan.nextLine();
						ue.setNom_UE(valeur);
						System.out.println("Indiquer le nombre de credits : ");
						credit = scan.nextInt();
						ue.setCredit(credit);
						
						us.AddUe(ue);
						
						System.out.println("Voulez vous continuer ?: ");
						reponse = scan.nextInt();
						
					}while(reponse == 0);
					break;
				case 2:
					break;
				default:
					System.out.println("Aucune action encours");
				}
				
			}else {
				System.out.println("Authentification failed");
			}
			break;
		case " etudiant ":
			etudiant etudi = new etudiant();
			System.out.println("------------------    Bienvenu(e) ADMIN --------------------- ");
			System.out.println("------------------   Veuillez vous Indentifier SVP pour continuer -----------------");
			System.out.println("votre nom d'utilisateur: \n");
			username = scan.nextLine();
			System.out.println("votre mot de passe : \n");
			password = scan.nextLine();
			
			if(admin.authentification(username, password)) {
				System.out.println("Ajout compte etudiant: \n");
				String valeur;
				int reponse = 0;
				etudiantService etudser = new etudiantService();
				do {
					System.out.println("Veuillez indiquer le nom du nouvel etudiant : ");
					valeur = scan.nextLine();
					valeur = scan.nextLine();
					etudi.setNom(valeur);
					System.out.println("Renseigner son prenom : ");
					valeur = scan.nextLine();
					etudi.setPrenom(valeur);
					System.out.println("Quel est le sexe de cet etudiant? : ");
					valeur= scan.nextLine();
					etudi.setSexe(valeur);
					System.out.println("Donner un nom d'utilisateur pour le compte de l'etudiant : ");
					valeur = scan.nextLine();
					etudi.setUsername(valeur);
					System.out.println("Attribuer lui un mot de passe : ");
					valeur = scan.nextLine();
					etudi.setPassword(valeur);
					
					etudser.EnregistrerEtudiant(etudi);
					
					System.out.println("Voulez vous continuer?: ");
					reponse = scan.nextInt();
				}while(reponse == 0);
			}else {
				System.out.println("Authentification failed");
			}
			
			
		default:
			System.out.println("Aucune action possible");
		}
	}
	
	public boolean authentification(String username, String password) {
		if(username.equals(getUsername()) && password.equals( getPassword ())) {
			return true;
		}else {
			return false;
		}
		
	}
	public enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(enseignant enseignant) {
		this.enseignant = enseignant;
	}	
 
}
