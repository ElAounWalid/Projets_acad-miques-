package Projet;

import java.util.ArrayList;
import java.util.Scanner;

public class quiz {
	private ArrayList<question>Lq;
	private String module;
	private String auteur;
	private ArrayList<Integer>lrepvalide;
	
	/*constructeur non parametre*/
	public quiz()
	{
		Lq=new ArrayList<question>();
		lrepvalide=new ArrayList<Integer>();
		module="";
		auteur="";
	}
	
	/*methode saisie*/
	public void saisir()
	{
		Scanner s=new Scanner(System.in);
		Scanner s1=new Scanner(System.in);
		System.out.println("Donner le nombre de questions à saisir");
		int nbrQ=s.nextInt();
		int valide;
		for(int i=0;i<nbrQ;i++)
		{
			System.out.println("Donner la question n°:"+(i+1));
			String ch=s1.nextLine();
			System.out.println("Donner le nombre d'options");
			int nbrO=s.nextInt();
			ArrayList<option>lo=new ArrayList<option>();
			for(int j=0;j<nbrO;j++)
			{
				option o=new option();
				o.saisir();
				o.setNumeroOption(j+1);
				lo.add(o);
			}
			do
			{
				System.out.println("Donner le num de l'option valide");
				valide=s.nextInt();
			}while((valide<1)&&(valide>nbrO));
			lrepvalide.add(valide);
			question q=new question(ch,lo,(i+1),nbrO,valide);
			Lq.add(q);
		}
			
	}
	
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	/*methode ajout d'une question dans la liste des questions*/
	public void ajout(question q) {Lq.add(q);}
	
	public String toString()
	{
		String ch=auteur+": "+module+"\n";
		for(int i=0;i<Lq.size();i++)
			ch+=Lq.get(i).toString()+"\n";
		return ch;
	}

	
	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public ArrayList<question> getLq() {
		return Lq;
	}

	public void setLq(ArrayList<question> lq) {
		Lq = lq;
	}
	
	
	
	
	
	
	
	

}
