package Projet;

import java.util.Scanner;

public class Prof {
	private String nom,prenom,nomModule;
	
	public Prof()
	{
		nom="";
		prenom="";
		nomModule="";
	}

	public void saisir () 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Donner votre nom");
		nom=s.nextLine();
		System.out.println("Donner votre prenom");
		prenom=s.nextLine();
		System.out.println("Donner le nom de module");
		nomModule=s.nextLine();
		
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
	
	
	public String getNomModule() {
		return nomModule;
	}

	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
	}

	public String toString() {
		return ("\nnom:" + nom + "\nprenom=" + prenom + "\nCIN=") ;
	}


}
