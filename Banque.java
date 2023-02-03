import java.security.PublicKey;
import java.util.ArrayList;
import java.util.PrimitiveIterator.OfDouble;

public class Banque {
    // attribus
  private  ArrayList MesClients=new ArrayList<Client>();
  private ArrayList NosCompte=new ArrayList<Compte>();
  private String nom,adress;
   // Cons

   public Banque(String nomdeBanque ,String Adressdebanque)
   {
       this.nom=nomdeBanque;this.adress=Adressdebanque;
   }

   // methode
   public void ajouterClient(Client Cl)
   {
       MesClients.add(Cl);
   }
   public void ouvrirCompte(Compte compte )
   {
      if (compte instanceof CompteCourant)// pour assurer que les client de cette banque ne peuvent etre titulaire qu'un seul compte courant;
      {
          Client C=compte.getTitulaire();
          if(rechercherClient(C)==1) // si le client appartient a cette banque alors on verifie nombre de ses compte courannt
          {   
              if(C.getNbrvompteCourant()==0){ NosCompte.add(compte);C.setNbrCompteCourant(1);}
              else System.out.println("Vous pouvez pas d'etre titulaire au plus d'un seul compte courant");
          }
          else NosCompte.add(compte); 
      }
      else NosCompte.add(compte);
   }
   public int rechercherClient(Client cl) //Rechercher si le client est un client de cette bnque
   {
       int i=0;
    while(i<this.MesClients.size())
    {
        if(MesClients.get(i)== cl) {return 1;}
        i++;
    }
    return 0;
   }
   // Fonction qui cherche un compte à partir de son numero et retourner sa position s'il existe sinon elle va retourner -1
   // on a ajouté cette methode pour faciliter la recherche dans l'arraylist
   public int Recherchecompte(int numerodecompte)
   { int i=0;
       while(i<this.NosCompte.size())
       {
           if(((Compte)NosCompte.get(i)).getNumero()==numerodecompte) {return i;}
           i++;
       }
    return -1;
   }
   //Fonction qui cherche un compte à partir de son numero est le retourner s'il existe sinon elle va retourner null
   public Compte Rchercher_Compte(int numeroDecompte)
   {
        int i=0;
        Compte t;
        while(i<this.NosCompte.size()  )
        {
            t=((Compte) this.NosCompte.get(i));
            if(t.getNumero()==numeroDecompte) 
            {
                return t ;
            }
        }
        return null;
   }
   public void debiter(int Numero_compte,double montant) throws Exception
   {
       if(this.Recherchecompte(Numero_compte)==-1) System.out.println("Ce compte n existe pas!");
       else{
           if(this.NosCompte.get(this.Recherchecompte(Numero_compte))instanceof CompteCourant)
           {
                ((CompteCourant)this.NosCompte.get(Recherchecompte(Numero_compte))).retrait(montant);
           }
           if(this.NosCompte.get(this.Recherchecompte(Numero_compte))instanceof CompteLDD)
           {
                ((CompteLDD)this.NosCompte.get(Recherchecompte(Numero_compte))).retrait(montant);
           }
           if(this.NosCompte.get(this.Recherchecompte(Numero_compte))instanceof ComptePEL)  System.out.println("Le Retrait n est pas autorise pour ce compte ");
        
       }
   }
   public void crediter(int numero_de_compte,double montant)
   {
       if(this.Recherchecompte(numero_de_compte)==-1) System.out.println("Ce compte n existe pas!");
       else
       {
         ((Compte) this.NosCompte.get(Recherchecompte(numero_de_compte))).depot(montant);
       }
   }
   public void afficher(int numero_de_compte) //Afficher le solde et le nom du titulaire d'un compte dont on connait le numéro. 
   {
       if(this.Recherchecompte(numero_de_compte)==-1) System.out.println("Ce compte n existe pas!");
       else
       {
        System.out.println(((Compte) this.NosCompte.get(Recherchecompte(numero_de_compte))).getNomTitulaire() +
        " votre solde= "+ ((Compte) this.NosCompte.get(Recherchecompte(numero_de_compte))).getSolde()+" DA");
       }
   }

   public void compte_a_decouvert()
   {
       //Afficher la liste des comptes qui sont à découvert (on se contentera d'afficher les numéros
       // des comptes qui sont à découvert)
       for (Integer i=0;i<this.NosCompte.size();i++)
       {
            if(((Compte) this.NosCompte.get(i)).getSolde()<0) System.out.println( ((Compte) this.NosCompte.get(i)).getNumero());
       }
   }
   public void afficherContenuBanque() // afficher Tous les clients et les comptes de la banque
   {
       System.out.println("Les Clients du Banque : \n");
       for(Integer i=0;i<this.MesClients.size();i++)
       {
           System.out.println(this.MesClients.get(i));
       }
        System.out.println("Les Comptes du Banque : \n");
        for (Integer i=0;i<this.NosCompte.size();i++)
        {
            System.out.println(this.NosCompte.get(i));
        }
   }

   public String toString(){ return "Banque"+this.nom+" /"+this.adress+"/" ;}

}
