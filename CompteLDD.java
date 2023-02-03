public class CompteLDD extends CompteNonbloque{
    //attribus
    public static int pourcentageInterres=2;//initialisation à 2%
    public static double seuil;

    //cons
    public CompteLDD(){};
    public CompteLDD(Client client ,double solde){super(client,solde);}

    //medh

    public static double getSeuil(){ return seuil;}
    public static void setSeuil(double Seuil){seuil=Seuil;}
    
    public void retrait(double montant)
    {
        if(montant <=0) System.out.println("Erreur! vous pouvez pas retrir un montant negative ou nul");
        else
        {
            if(this.getSolde()>= montant)
             {
                 if(montant <= this.seuil) this.setSolde(this.getSolde()-montant);
                 else System.out.println("Noud pouvons pas effectuer cette operation ,Le montant depasse le seuil");
                 
             }
             else 
             {
                System.out.println("Le solde est insuffisant ");
             }
        }
        
    }
    public void depot(double montant)
    {
        super.depot(montant);
    }
    public void actualiser()
    { 
        //D'après ce qu'on a compris de l'énoncé l'actualisation de compte LDD est 
                             // pour prendre 2% de solde pour l'utiliser 
        this.setSolde(this.getSolde()-(this.getSolde()*pourcentageInterres/100));
    }
    public String toString()
    {
        return "Compte LDD - "+super.toString();
    }
    
}
