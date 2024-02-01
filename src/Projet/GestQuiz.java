package Projet;

import java.util.ArrayList;
import java.util.Scanner;

public class GestQuiz {

	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int c,i,choix;
		ArrayList<quiz>lquiz=new ArrayList<quiz>();
		ArrayList<Prof>LP=new ArrayList<Prof>();
		ArrayList<Etudiant>LE=new ArrayList<Etudiant>();
		
	do
	{
		do {
		System.out.println("1-Etudiant");
		System.out.println("2-Enseignant");
		System.out.println("3:Quitter");
		System.out.println("Donnez votre choix");	
		c=s.nextInt();
		}while((c!=1)&& (c!=2)&&(c!=3));
		
		switch(c)
		{
		case 1:
			int score=0;
			Etudiant E=new Etudiant();
			E.saisir();
			int pos=0;
			/*Menu etudiant*/
			do
			{
				System.out.println("1:Visualiser la liste des Quiz disponibles");
				System.out.println("2:Passer un Quiz");
				System.out.println("3:Consulter les scores obtenus pour les Quiz déjà passés");
				System.out.println("4:Consulter la correction d’un Quiz");
				System.out.println("5:Quitter");
				choix=s.nextInt();
				
			switch(choix)
			{
			
			case 1:
				boolean trouve=false;
				i=0;
				
				while((i<LE.size())&&(!trouve))
				{
					if(E.equals(LE.get(i)))
						trouve=true;
					else
						i++;
				}
				if(!trouve)
				{
					LE.add(E);
					pos=LE.size()-1;		
				}
				else
					pos=i;
				System.out.println("la liste des quiz déjà passés\n");
				for(int j=0;j<lquiz.size();j++)
				{
					for(i=0;i<LE.get(pos).getModule().size();i++)
					{
						if(LE.get(pos).getModule().get(i).equals(lquiz.get(j).getModule()))
							System.out.println(lquiz.get(j)); 
					}
				}
				
				System.out.println("la liste des quiz que vous n'avez pas passés\n");
				for(int j=0;j<lquiz.size();j++)
				{
					if(LE.get(pos).getModule().isEmpty())
						System.out.println(lquiz.get(j));
					else
					{
						for(i=0;i<LE.get(pos).getModule().size();i++)
						{
							if((LE.get(pos).getModule().get(i).equals(lquiz.get(j).getModule()))==false)
								System.out.println(lquiz.get(j)); 
						}
					}
					
				}
				break;
			case 2:
				System.out.println("Donner un module");
				Scanner s1=new Scanner(System.in);
				String ch=s1.nextLine();
				boolean trouve2=false;
				i=0;
				while((!trouve2)&&(i<E.getModule().size()))
				{
					if(E.getModule().get(i).equals(ch))
					{
						System.out.println("Vous avez déjà passer le quiz de ce module");
						trouve2=true;
					}
					else
						i++;
				}
				if(!trouve2)
				{
					int j=0;
					boolean trouve3=false;
					
					while((j<lquiz.size())&&(!trouve3))
					{
						if((ch.equals(lquiz.get(j).getModule())))
							trouve3=true; 
						else
							j++;
					}
					if(!trouve3)
					{
						System.out.println("Le module n'existe pas");
						
					}
					
					else
					{
						reponse r=new reponse();
						r.setNomModule(ch);
						ArrayList<Integer>Lreponses=new ArrayList<Integer>();
						ArrayList<reponse>LR=new ArrayList<reponse>();
						for(i=0;i<lquiz.get(j).getLq().size();i++)
						{
							System.out.println(lquiz.get(j).getLq().get(i));
							int reponse;
							do
							{
								System.out.println("Donner le numero de l'option exacte");
								reponse=s.nextInt();
							}while((reponse<1)&&(reponse>lquiz.get(j).getLq().get(i).getNbrO()));
							Lreponses.add(reponse);
							if(reponse==lquiz.get(j).getLq().get(i).getValide())
								score+=1;
							
						}
						r.setScore(score);
						r.setLreponse(Lreponses);
						E.getLreponseEtudiant().add(r);
					}
					E.getModule().add(ch);
				}
				break;
			case 3:
				if(E.getLreponseEtudiant().isEmpty())
					System.out.println("Vous n'avez repondu a aucun quiz");
				else
				{
					for(i=0;i<E.getLreponseEtudiant().size();i++)
					{
						System.out.println(E.getLreponseEtudiant().get(i).getNomModule()+"\n"+E.getLreponseEtudiant().get(i).getScore()+" reponses exactes\n");
					}
					
				}
				break;
			case 4:
				if(E.getModule().isEmpty())
					System.out.println("Vous n'avez pas passer de quiz");
				else
				{
					System.out.println("Donner le nom du module");
					Scanner s2=new Scanner(System.in);
					ch=s2.nextLine();
					boolean trouve4=false;
					i=0;
					while((!trouve4)&&(i<E.getModule().size()))
					{
						if(E.getModule().get(i).equals(ch))
							trouve4=true;
						else
							i++;
					}
					if(!trouve4)
						System.out.println("le module n'existe pas dans la liste des modules que vous avez repondu a leurs quiz");
					else
					{
						int j=0;
						boolean trouve6=false;
						while((j<lquiz.size())&&(!trouve6))
						{
							if(lquiz.get(j).getModule().equals(E.getModule().get(i)))
							{
								for(int z=0;z<lquiz.get(j).getLq().size();z++)
								{
									System.out.println(lquiz.get(j).getLq().get(z));
									i=0;
									boolean trouve5=false;
									while((i<lquiz.get(j).getLq().get(z).getLo().size())&&(!trouve5))
										{	
											if(lquiz.get(j).getLq().get(z).getLo().get(i).getNumeroOption()==lquiz.get(j).getLq().get(z).getValide())
											{
												System.out.println("\nla reponse exacte est:"+lquiz.get(j).getLq().get(z).getLo().get(i).getCh());
												trouve5=true;
											}
											else
												i++;
										}
								}
								trouve6=true;
							}
							else
								j++;
								
						}
					}
					
				}
				
				break;
			case 5:
				System.out.println("Vous etes derigé vers le menu principal");
				break;
			}
			}while(choix!=5);
		break;
	
		case 2:
		/*Menu enseignant*/
		do
		{
			System.out.println("1:Creation Quiz");
			System.out.println("2:Suppression Quiz");
			System.out.println("3:modification Quiz");
			System.out.println("4:Visualisation de la liste des etudiants ayant repondu a un Quiz");
			System.out.println("5:Taux de reponses justes pour un quiz");
			System.out.println("6:Taux de reponses justes pour une question");
			System.out.println("7:Quitter");
			choix=s.nextInt();
			
			switch(choix)
			{
			case 1:
				/*creation d'un quiz*/
				boolean trouve=false;
				i=0;
				Prof P=new Prof();
				P.saisir();
				while((i<LP.size())&&(!trouve))
				{
					if(P.getNomModule().equals(LP.get(i).getNomModule()))
						trouve=true;
					else
						i++;
				}
				if(trouve)
					System.out.println("le nom du module existe déjà");
				else
				{
					LP.add(P);
					quiz q=new quiz();
					String ch=P.getNom()+" "+P.getPrenom();
					q.setAuteur(ch);
					q.setModule(P.getNomModule());
					q.saisir();
					lquiz.add(q);
				}
			break;
			case 2:
				/*suppression d'un quiz*/
				if(lquiz.isEmpty())
					System.out.println("Liste de quiz vide");
				else
				{System.out.println(lquiz.size());
					for(int j=0;j<lquiz.size();j++)
					{
						System.out.println("Quiz n°:"+(j+1)+"\n");
						System.out.println(lquiz.get(j));
					}
					int rang;
					do
					{
						System.out.println("Donner le numero du quiz à supprimer");
						rang=s.nextInt();
					}while((rang<1)&&(rang>lquiz.size()));
					lquiz.remove(rang-1);
					LP.remove(rang-1);
				}
				
				break;
			case 3:
				boolean trouve7=false;
				i=0;
				System.out.println("Donner un module");
				Scanner s1=new Scanner(System.in);
				String ch=s1.nextLine();
				
				while((i<LP.size())&&(!trouve7))
				{
					if(ch.equals(LP.get(i).getNomModule()))
						trouve7=true;
					else
						i++;
				}
				if(!trouve7)
					System.out.println("le nom du module n'existe pas");
				else
				{
					System.out.println(lquiz.get(i));
					System.out.println("Donnez le numero de la question a modifier");
					Scanner s2=new Scanner(System.in);
					int num=s2.nextInt();
					if((num>lquiz.get(i).getLq().size())&&(num<1))
						System.out.println("le numero de la question n'existe pas");
					else
					{
						System.out.println(lquiz.get(i).getLq().get(num-1)); 
						System.out.println("Donner le numero de l'option a supprimer");
						int numO=s2.nextInt();
						if((numO<1)&&(numO>lquiz.get(i).getLq().get(num-1).getLo().size()))
							System.out.println("le numero de l'option n'existe pas");
						else
						{
							lquiz.get(i).getLq().get(num-1).getLo().remove(lquiz.get(i).getLq().get(num-1).getLo().get(numO-1));
							option Op=new option();
							Op.saisir();
							Op.setNumeroOption(numO);
							boolean ins=false;
							int k=0;
							while((k<lquiz.get(i).getLq().get(num-1).getLo().size())&&(!ins))
							{
								if(k==numO-1)
								{
									lquiz.get(i).getLq().get(num-1).getLo().add(Op);
										ins=true;
								}
								else
									k++;
							}
						}
					}
				}
				break;
			case 4:
				/*Visualisation de la liste des etudiants*/
				if(LE.isEmpty())
					System.out.println("Aucun etudiant n'a repondu a un quiz");
				else
				{
					String ch2;
					System.out.println("Donner un module");
					Scanner s3=new Scanner(System.in);
					ch2=s3.nextLine();
					for(i=0;i<LE.size();i++)
					{
						for(int j=0;j<LE.get(i).getModule().size();j++)
						{
							if(ch2.equals(LE.get(i).getModule().get(j)))
								System.out.println(LE.get(i));
							
						}
					}
				}
				break;
			case 5:
				String ch2;
				System.out.println("Donner un module");
				Scanner s3=new Scanner(System.in);
				ch2=s3.nextLine();
				if(LE.isEmpty())
					System.out.println("Liste vide");
				else
				{
					int scoretotal=0;
					double taux=0;
					for(i=0;i<LE.size();i++)
					{
						for(int j=0;j<LE.get(i).getModule().size();j++)
						{
							if(LE.get(i).getModule().get(j).equals(ch2))
							{
								for(int t=0;t<LE.get(i).getLreponseEtudiant().size();t++)
									scoretotal+=LE.get(i).getLreponseEtudiant().get(t).getScore();
							}
						}
						System.out.println(scoretotal);
					}
				}
				
				break;
			case 7:
				System.out.println("Vous etes derigé vers le menu principal");
				break;
			default:System.out.println("Choix invalide");
			break;
			}
		}while(choix!=7);
		break;
		case 3:System.out.println("Au revoir!");
		break;
		default:System.out.println("Choix invalide");
		break;
		}
	}while(c!=3);

}
}
