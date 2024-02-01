package Projet;

import java.util.Scanner;


public class option {
 private String ch;
 int numeroOption;
 
 /*constructeur non parametre*/
 public option() {ch="";numeroOption=0;}
 
 /*methode saisie*/
 public void saisir()
 {
	 Scanner s=new Scanner(System.in);
	 Scanner s1=new Scanner(System.in);
	 System.out.println("Donner un choix: ");
	 ch=s.nextLine();
 }
 
public String getCh() {
	return ch;
}
public void setCh(String ch) {
	this.ch = ch;
}

public int getNumeroOption() {
	return numeroOption;
}

public void setNumeroOption(int numeroOption) {
	this.numeroOption = numeroOption;
}

public String toString() {
	return numeroOption+")"+ch;
}

}
