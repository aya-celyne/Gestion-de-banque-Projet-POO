public class ComptePEL extends Compte {
     private static int pourcentageInterres=3;//Initialisation à 3%

     //cons
     public ComptePEL(){};
     public ComptePEL(Client client ,double solde ){ super(client,solde);}

     public static int getPourcentageInterres(){return pourcentageInterres;}
     public static void setPoucentageInterres(int PourcentageInterres){ pourcentageInterres=PourcentageInterres;}

     public void actualiser()// D'après ce qu'on a compris de l'énoncé l'actualisation de compte PEL est 
                             // pour prendre 3% de solde pour l'utiliser 
     {
        this.setSolde(this.getSolde()-(this.getSolde()*pourcentageInterres/100));
     }
     public String toString()
     {
         return "Compte PEL - "+super.toString();
     }

}
