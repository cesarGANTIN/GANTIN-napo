/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author CESAR
 */
public class evaluation {
    private float note;
	
	private etudiant etudiants;
	private UE ues;
	
	public float getNote() {
		return note;
	}
	public void setNote(float note) {
		note = note;
	}
	public etudiant getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(etudiant etudiants) {
		this.etudiants = etudiants;
	}
	public UE getUes() {
		return ues;
	}
	public void setUes(UE ues) {
		this.ues = ues;
	}
}
