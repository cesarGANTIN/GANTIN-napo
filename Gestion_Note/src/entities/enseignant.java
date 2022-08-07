/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;
import java.util.Scanner;

import services.enseignantService;
import services.etudiantService;
import services.evaluationService;
import services.UEService;
/**
 *
 * @author CESAR
 */
public class enseignant  extends users {
   
    private UE ue;
	
	Scanner scan = new Scanner(System.in);
	public void Manage(String entity) {
		enseignantService enser = new enseignantService();
		String username, password;
		int choix,id;
		System.out.println("-------------- Bienvenu Professeur --------------------\n");
		
		System.out.println("-------------- Veuillez vous authentifier pour continuer -------\n");
		System.out.println("Renseigner votre identifiant svp (Nombre entier) : ");
		id = scan.nextInt();
		System.out.println("Renseigner votre nom d'utilisateur svp:");
		username = scan.nextLine();
		
		System.out.println("Indiquer votre mot de passe svp: ");
		password = scan.nextLine();
		
		enseignant ens = enser.verifUser(id);
		
		if(ens.getUsername().equals(username) && ens.getPassword().equals(password)) {
			
			System.out.println("Connected ::: [Profil] ::: " +ens.getUsername());

		System.out.println("------------- MENU -------------\n");
		System.out.println("1- Enregistrer Notes \n 2- Afficher les Notes attribuer\n 3- Consulter son inbox\n 4- Action sur une reclamation");
		choix = scan.nextInt();
		switch(choix) {
		case 1:
			int reponse,id1;
			String valeur;
			float note;
			etudiantService eser = new etudiantService();
			UEService usr = new UEService();
			evaluationService ns = new evaluationService();
			evaluation E = new evaluation();
			eser.getId();
			do {
				System.out.println("Veuillez saisir 'identifiant de l'etudiant : ");
				id1 = scan.nextInt();
				etudiant etudiant = eser.getById(id1);
				
				System.out.println(etudiant);
				
				E.setEtudiants(etudiant);
				
				System.out.println("specifier l'unite d'enseignement de preference le libelle de l'UE : ");
				
				valeur =scan.nextLine();
				valeur = scan.nextLine();
				UE ue = usr.getByNom(valeur);
				E.setUes(ue);
				
				System.out.println("Attribuer une note : ");
				note = scan.nextFloat();
                                    E.setNote(note);
				
				ns.Addnote(E);
				
				System.out.println("Voulez vous ajouter une note? :");
				reponse = scan.nextInt();
				
			}while(reponse == 0);
				
			break;
		case 2:
			int identifiant;
			String code_UE;
			System.out.println("--------------------------- Pages des notes etudiants  --------------------");
			evaluationService Evaserv = new evaluationService();
			System.out.println("Renseigner identifiant de l'etudiant concerner: \n");
			identifiant = scan.nextInt();
			System.out.println("Le code de votre unit� d'enseignement: \n");
			code_UE = scan.nextLine();
			code_UE = scan.nextLine();
			Evaserv.getByCodeUE(identifiant, code_UE);
			break;
		case 3:
			System.out.println("Bienvenu Monsieur :::" +ens.getUsername());
			System.out.println("--------------------------   Page de lecture de message --------------\n");
			enser.consulterInbox(id);
			break;
		case 4:
			break;
		default:
			System.out.println("Impossible!!!!!");
		}
	}else {
		System.out.println("Athentification failed");
	}
}
		
	public UE getUE() {
		return ue;
	}
	public void setUe(UE ue) {
		this.ue = ue;
        }
}
        

