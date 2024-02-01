package Projet;
import java.util.ArrayList;
import java.util.Scanner;


public class question {
	Scanner s=new Scanner(System.in);
	private String parag;
	private int numero;
	private ArrayList<option>lo;
	

	private int nbrO;
	private int valide;
	
	/*constructeur parametre*/
	public  question(String parag,ArrayList<option>lo,int numero,int nbrO,int valide) {
		this.parag=parag;
		this.numero=numero;
		this.lo=lo;
		this.nbrO=nbrO;
		this.valide=valide;
	}

	public int getNbrO() {
		return nbrO;
	}

	public void setNbrO(int nbrO) {
		this.nbrO = nbrO;
	}
	/*redefinition de la methode toString*/
	public String toString(){
		String ch=numero+"-"+parag+"\n";
		for(int i=0;i<lo.size();i++)
			ch+=lo.get(i).toString()+"\n";
		return ch;
	}

	public int getValide() {
		return valide;
	}

	public void setValide(int valide) {
		this.valide = valide;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getParag() {
		return parag;
	}

	public void setParag(String parag) {
		this.parag = parag;
	}
	
	/*methode ajouter de l'option dans la liste d'option*/
	public void ajout(option o)
	{
		lo.add(o);
	}
	
	public ArrayList<option> getLo() {
		return lo;
	}

	public void setLo(ArrayList<option> lo) {
		this.lo = lo;
	}
}
