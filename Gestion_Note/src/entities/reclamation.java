/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author CESAR
 */
public class reclamation {
    private float noteConteste;
	
	private etudiant etudiant;
	private UE ue;
	
	
	public float getNoteConteste() {
		return noteConteste;
	}
	public void setNoteConteste(float noteConteste) {
		this.noteConteste = noteConteste;
	}
	public etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public UE getUe() {
		return ue;
	}
	public void setUe(UE ue) {
		this.ue = ue;
	}
}
