#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <time.h>
int n=0,n2=0,s,x,x2,scores_aux,scores[20],scores2[20],score,i,len,coups,Trouve,pos,help;
char choix,choix2;
time_t seconds,seconds2;
char pseudos_aux[8],pseudos[20][8],pseudos2[20][20],pseudo[8],liste[17][15]={"PAYS","PARIS","MAISON","CAMPAGNE","POINT","FLECHETTE","FAMILLE","NUAGE","MEDETERANIEN","ENTREPRISE","MATIERE","MONDIALISATION","LIVRE","ANESTHESIE","PUBLICITE","HERITAGE","PLANETE"};
void srand(unsigned int seed);
void affichage()
{
       do
        {
       printf("||------------------------------------------------------------------------------|| \n");
       printf("||------------------------------------------------------------------------------||\n");
       printf("||                                Bienvenu au jeu                               ||\n");
       printf("||------------------------------------------------------------------------------||\n");
       printf("||------------------------------------------------------------------------------||\n");
       printf("||------------------------------------------------------------------------------|| \n");
       printf("||------------------------------------------------------------------------------||\n");
       printf("||                             Veuillez choisir un jeu                          ||     \n");
       printf("||------------------------------------------------------------------------------|| \n");
       printf("||------------------------------------------------------------------------------||\n");
       printf("||                                    1:Le pendu                                || \n");
       printf("||                                    2:Motus                                   ||\n");
       printf("||------------------------------------------------------------------------------||\n");
       printf("||------------------------------------------------------------------------------||\n");
       printf("||                                   3:Quitter                                  ||\n");
       printf("||------------------------------------------------------------------------------||\n");
       printf("||------------------------------------------------------------------------------||\n");
       printf("Veuillez choisir une option\n");
       choix= getchar();
       fflush(stdin);
       system("cls");
    }while((choix!='1')&&(choix!='3')&&(choix!='2'));
}
void affichage2()
{
    do{
        printf("\n  |--------------------------------------------------------------------------------|\n");
        printf("  |                                     1:Rejouer                                  |\n");
        printf("  |                                     2:Verification score                       |\n");
        printf("  |                                     3:Classement                               |\n");
        printf("  |                                     4:Menu principal                           |\n");
        printf("  |                                     5:Quitter                                  |\n");
        printf("  |--------------------------------------------------------------------------------|\n");
        printf("Veuillez choisir une option\n");
        choix2=getchar();
        fflush(stdin);
        system("cls");
    }while((choix2!='1')&&(choix2!='3')&&(choix2!='2')&&(choix2!='4')&&(choix2!='5'));
}

int main()
{
    system("Color F4");
    do{
        affichage();
if(choix=='1')
   {
       choix2='1';
           do
           {
               srand(time(NULL));
               pos=rand()%17;
               len=strlen(liste[pos]);coups=7;
               char mot_masque[len],mot[len],lettre,j;
                mot_masque[len]='\0';
               if (choix2=='1')
               {
                score=0;
               s=70;
               i=0;
               strcpy(mot,liste[pos]);
               for (i=0;i<len;i++)
               mot_masque[i]='*';
               printf("Bienvenu au pendu! \n");
               help=0;
               seconds = time(NULL);
                    x = seconds;
               while((strcmp(mot,mot_masque)!= 0) && (coups>0) && (s>0))
               {
                 printf("Il vous reste %i coups a jouer et %i secondes \n",coups,s);
                 printf("Quel est le mot secret ? %s \n",mot_masque);

               for (j='A';j<='Z';j++)
               {
                   i=0;
                 Trouve=0;
                 do
                 {
                    if (j==mot_masque[i])
                    {
                        printf("_\t");
                        Trouve=1;
                    }
                    else
                        i++;
                 }
                 while((i<len)&&(!Trouve));

                 if(!Trouve)
                    printf("%c\t",j);
               }
               if (!help)
                printf("\nTaper '?' pour help(!Attetion Vous perdez un point de votre score)");
                  do
                   {
                       printf("\nTaper une lettre\n");
                       lettre=getchar();
                       fflush(stdin);
                       if(lettre=='?')
                        help++;
                   }while(((lettre<'A') || (lettre>'Z')) && ((lettre<'a') || (lettre>'z')) && ((lettre!='?') || (help!=1)));

                    seconds2 = time(NULL);
                    x2 = seconds2;
                    s=70-(x2-x);
               Trouve=0;
               if ((lettre=='?')&& (help==1))
                   {
                        do
                        {
                            pos=rand()%len;
                        }
                        while(mot_masque[pos]==mot[pos]);
                        mot_masque[pos]=mot[pos];
                        help++;
                        score=-1;
                   }

               else
               {
                   for (i=0;i<strlen(mot);i++)
                   {
                     lettre=toupper(lettre);
                     if (lettre==mot[i])
                     {
                        mot_masque[i]=lettre;Trouve=1;
                     }
                    }
                    if (!Trouve)
                    coups=coups-1;
               }
             }
             if (strcmp(mot, mot_masque)== 0)
                    printf("Bravo, vous avez trouve le mot masque!\nLe mot secret est: %s\n",mot);


             if((coups==0)&&(s>0))
                {
                    printf("Dommage vous avez epuise tout vos coups. \n");printf("Vous avez perdu!\n");printf("le mot secret est: %s\n",mot);
                }
             if((s<=0) && strcmp(mot_masque,mot)!=0)
                {
                    printf("Dommage le temps a coule \n");printf("Vous avez perdu!\n");printf("le mot secret est: %s\n",mot);
                }
               if (((coups==7) || (coups==6))&&(strcmp(mot, mot_masque)== 0))
                 score=score+4;
             else if (((coups==5) || (coups==4))&&(strcmp(mot, mot_masque)== 0))
                 score=score+3;
             else if (((coups==3) || (coups==2))&&(strcmp(mot, mot_masque)== 0))
                 score=score+2;
             else if ((coups==1)&&(strcmp(mot, mot_masque)== 0))
                 score=score+1;
             else
                 score=0;
            Trouve=0;
            if (score>0)
            {
                        do
                        {
                            printf("Entrer votre pseudo (il doit comporter au max 7 caracteres)\n");
                            scanf("%s",pseudo);
                            fflush(stdin);
                        }while(strlen(pseudo)>7);
                n++ ;i=0;
                Trouve=0;
                while((i<n)&&(!Trouve))
                {
                if(strcmp(pseudos[i],pseudo)==0)
                {
                    Trouve=1;scores[i]=scores[i]+score;n--;
                } else
                    i++;
                }
                if (!Trouve)
                {
                strcpy(pseudos[n-1],pseudo);scores[n-1]=score;
                }
               Trouve=1;
                while(Trouve)
                {
                for(i=0;i<n;i++)
                {
                    if (scores[i]<scores[i+1])
                    {
                        scores_aux=scores[i];scores[i]=scores[i+1];scores[i+1]=scores_aux;
                        strcpy(pseudos_aux,pseudos[i]);strcpy(pseudos[i],pseudos[i+1]);strcpy(pseudos[i+1],pseudos_aux);
                        i=n;Trouve=1;
                    }
                    else
                        Trouve=0;
                }
                }
                }
               }
            else if (choix2=='2')
            {
                printf("votre score est %i\n",score);
            }
            else if(choix2=='3')
            {
                printf("------CLASSEMENT------\n");
                printf("pseudos\t\tscores\n");
                for(i=0;i<n;i++)
                        printf("%s\t\t%i\n",pseudos[i],scores[i]);
            }
            else if(choix2=='4')
                    affichage();
            affichage2();
             }while((choix2!='5')&&(choix2!='4'));
             if(choix2=='5')
                {printf("Bye Bye\nTaper une touche pour quitter le jeu!");
                choix='4';
                }
       }
    else if(choix=='2')
        {
            choix2='1';
            do{
            int j;
            srand(time(NULL));
            pos=rand()%17;
            len=strlen(liste[pos]);
            char pos_exacte[len],mot_masque[len],mot[len],mot_donne[100];
             coups=7;
            mot_masque[len]='\0';
            pos_exacte[len]='\0';
            x=0;x2=0;
            s=70;
            i=0;
            strcpy(mot,liste[pos]);
            mot_masque[0]=mot[0];
            for (i=1;i<len;i++)
            mot_masque[i]='*';
            for (i=0;i<len;i++)
            pos_exacte[i]=' ';
            seconds = time(NULL);
            x = seconds;
            Trouve=1;
            if (choix2=='1')
            {
                score=0;
                printf("Bienvenu au motus! \n");
               help=0;
               while((strcmp(mot,mot_masque)!=0) && (coups>0) && (s>0))
               {
                 do
                 {
                     printf("Il vous reste %i coups a jouer et %i secondes\n",coups,s);
                     if (!help)
                        printf("Taper '?' pour help(!Attetion Vous perdez un point de votre score)\n");
                     printf("%s [%s] Donnez votre proposition composee de %i caracteres\n",mot_masque,pos_exacte,len);
                     scanf(" %s", mot_donne);
                     fflush(stdin);
                     if(strcmp(mot_donne,"?")==0)
                        help++;
                     seconds2 = time(NULL);
                     x2 = seconds2;
                     s=70-(x2-x);
                     i=0;
                     Trouve=1;
                     do
                     {
                         if (((mot_donne[i]<'A') || (mot_donne[i]>'Z')) && ((mot_donne[i]<'a') || (mot_donne[i]>'z')) && ((strcmp(mot_donne,"?")!=0) && (help!=1)))
                         Trouve=0;
                         else
                            i++;
                     }while((i<len) && (Trouve));
                 }while((((strlen(mot_donne)!=len)||(!Trouve))&&(help!=1)) &&(s>0));
                 if ((strcmp(mot_donne,"?")==0)&& (help==1))
                   {
                        do
                        {
                            pos=rand()%len;
                        }
                        while((mot_masque[pos]==mot[pos])||(mot[pos]==pos_exacte[pos]));
                        mot_masque[pos]=mot[pos];
                        help++;
                        score=-1;
                   }

                   else
                   {
                 for (i=0;i<len;i++)
                   {
                     mot_donne[i]=toupper(mot_donne[i]);
                     if (mot_donne[i]==mot[i])
                     {
                        mot_masque[i]=mot_donne[i];
                     }
                     else
                     {
                         for(j=0;j<len;j++)
                         {if ((mot[j]==mot_donne[i])&&(mot[j]!=mot_donne[j]))
                                pos_exacte[j]=mot[j];
                         }
                     }
                    }
                    if (strcmp(mot_donne,mot_masque)!=0)
                        coups=coups-1;
                   }
                    if (strcmp(mot,mot_masque)== 0)
                    printf("Bravo, vous avez trouve le mot masque!\nLe mot secret est: %s\n",mot);
             else if((coups==0)&&(s>0))
                {
                    printf("Dommage vous avez epuise tout vos coups. \n");printf("Vous avez perdu!\n");printf("le mot secret est: %s\n",mot);
                }
             else if((s<=0) && (strcmp(mot_donne,mot)!=0))
                {
                    printf("Dommage le temps a coule \n");printf("Vous avez perdu!\n");printf("le mot secret est: %s\n",mot);
                }
                 if (((coups==7) || (coups==6))&&(strcmp(mot, mot_masque)== 0))
                 score=score+4;
             else if (((coups==5) || (coups==4))&&(strcmp(mot, mot_masque)== 0))
                 score=score+3;
             else if (((coups==3) || (coups==2))&&(strcmp(mot, mot_masque)== 0))
                 score=score+2;
             else if ((coups==1)&&(strcmp(mot, mot_masque)== 0))
                 score=score+1;
             else
                 score=0;
            Trouve=0;
            if (score>0)
            {
                do
                {
                    printf("Entrer votre pseudo (il doit comporter au max 7 caracteres)\n");
                    scanf("%s",pseudo);
                    fflush(stdin);
                }while(strlen(pseudo)>7);
                n2++ ;i=0;
                while((i<n2)&&(!Trouve))
                {
                if(strcmp(pseudos2[i],pseudo)==0)
                {
                    Trouve=1;scores2[i]=scores2[i]+score;n2--;
                } else
                    i++;
                }
                if (!Trouve)
                {
                strcpy(pseudos2[n2-1],pseudo);scores2[n2-1]=score;
                }
               Trouve=1;
                while(Trouve)
                {
                for(i=0;i<n2;i++)
                {
                    if (scores2[i]<scores2[i+1])
                    {
                        scores_aux=scores2[i];scores2[i]=scores2[i+1];scores2[i+1]=scores_aux;
                        strcpy(pseudos_aux,pseudos2[i]);strcpy(pseudos2[i],pseudos2[i+1]);strcpy(pseudos2[i+1],pseudos_aux);
                        i=n;Trouve=1;
                    }
                    else
                        Trouve=0;
                }
                }
            }
                }
            }
               else if (choix2=='2')
                printf("votre score est %i\n",score);
               else if(choix2=='3')
            {
                printf("------CLASSEMENT------\n");
                printf("pseudos\t\tscores\n");
                for(i=0;i<n2;i++)
                    printf("%s\t\t%i\n",pseudos2[i],scores2[i]);
            }
            else if(choix2=='4')
                    affichage();
            affichage2();
             }while((choix2!='5')&&(choix2!='4'));
             if(choix2=='5')
                {printf("Bye Bye\nTaper une touche pour quitter le jeu!");
                choix='4';
                }
        }
    else if(choix=='3')
        printf("Bye Bye\nTaper une touche pour quitter le jeu!");
   }while((choix=='1')||(choix=='2'));
   return 0;
}
