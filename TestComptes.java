import java.time.LocalDate;
public class TestComptes {
public static void main(String[] args) throws Exception {
	
  
    Client Ahmed=new Client("Aberkane", "Ahmed", "BEJAIA", LocalDate.of(2000, 6, 2));
    Client Mohammed=new Client("Lagab", "MOhammed", "ALGER", LocalDate.of(2001, 1 , 20));

    Banque banque=new Banque("ESALAM", "ALGER");
    banque.ajouterClient(Ahmed);
    banque.ajouterClient(Mohammed);

    //Pour monsieur Ahmed, créer un compte courant avec un seuil 
    // de découvert autorise de -500. Ajouter 1000 sur son compte. 
    CompteCourant Cpm1=new CompteCourant(Ahmed, 1000, 500);
    banque.ouvrirCompte(Cpm1);
    banque.debiter(Cpm1.getNumero(),100);
    banque.debiter(Cpm1.getNumero(),2000);

   //Pour monsieur Ahmed, créer un compte épargne logement avec un taux d'intérêt de 3%. Ajouter 200 sur ce compte. 
    Compte Cmp2=new ComptePEL(Ahmed, 0);
    banque.ouvrirCompte(Cmp2);
    Cmp2.depot(200);
    //Pour monsieur Ahmed, créer un compte courant. Ajouter 800
    Compte Cmp3=new CompteCourant(Ahmed, 0,0);
    banque.ouvrirCompte(Cmp3);
    banque.crediter(Cmp3.getNumero(), 800);
  
   //Afficher le contenu de la banque : clients et comptes
    banque.afficherContenuBanque();
  // affichage détaillé du clients et leur comptes;
  System.out.println("\n\n");
    Ahmed.afficher();Mohammed.afficher();

}
    
}
