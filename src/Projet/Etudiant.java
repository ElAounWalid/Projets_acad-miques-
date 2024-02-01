package Projet;

import java.util.ArrayList;
import java.util.Scanner;

public class Etudiant {
	
	private String nom,prenom;
	private long CIN;
	private ArrayList<String> module;
	private ArrayList<reponse> lreponseEtudiant;
	
	
	/*Constructeur non parametre*/
	public Etudiant()
	{
		
		module=new ArrayList<String>();
		lreponseEtudiant=new ArrayList<reponse>();
		nom="";
		prenom="";
		CIN=0;
	}
	/*methode de saisie */
	public void saisir () {
		Scanner s=new Scanner(System.in);
		System.out.println("Donner votre nom");
		nom=s.nextLine();
		System.out.println("Donner votre prenom");
		prenom=s.nextLine();
		System.out.println("Donner le num CIN");
		CIN=s.nextLong();
	}
	public ArrayList<reponse> getLreponseEtudiant() {
		return lreponseEtudiant;
	}

	public void setLreponseEtudiant(ArrayList<reponse> lreponseEtudiant) {
		this.lreponseEtudiant = lreponseEtudiant;
	}
	/*methode ajout de module dans la liste de modules*/
	public void ajout(String module)
	{
		this.module.add(module);
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public long getCIN() {
		return CIN;
	}

	public void setCIN(long CIN) {
		this.CIN = CIN;
	}
	
	public ArrayList<String> getModule() {
		return module;
	}

	public void setModule(ArrayList<String> module) {
		this.module = module;
	}

	public String toString() {
		return ("\nnom:" + nom + "\nprenom=" + prenom + "\nCIN=" + CIN);
	}
	
	/*redefinition de la methode equals*/
	public boolean equals(Etudiant E)
	{
		return this.CIN==E.CIN;
	}
	
	
}
