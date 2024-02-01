package Projet;

import java.util.ArrayList;

public class reponse {
	private String nomModule;
	private ArrayList<Integer>Lreponse;
	private int score;
	
	public reponse()
	{
		
		nomModule="";
		Lreponse=new ArrayList<Integer>();
	}

	public String getNomModule() {
		return nomModule;
	}

	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
	}

	public ArrayList<Integer> getLreponse() {
		return Lreponse;
	}

	public void setLreponse(ArrayList<Integer> lreponse) {
		Lreponse = lreponse;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	

	
	

}
