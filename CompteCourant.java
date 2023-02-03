public class CompteCourant extends CompteNonbloque{
   //att
    private static int pourcentageAgios=5;
    private int seuilDecouvert;


    //cons
    public CompteCourant(){};
    public CompteCourant(int seuilDecouvert)
    {
        this.seuilDecouvert=seuilDecouvert;
    }
    public CompteCourant(Client client ,double solde,int seuilDecouvert)
    {
        super(client,solde);this.seuilDecouvert=seuilDecouvert;
    }

    //meth

    public int getSeuilDecouvert(){return this.seuilDecouvert;}

    public void setseuildecouvert(int seuilDecouvert){this.seuilDecouvert=seuilDecouvert;}

    public static int getPourcentageagios(){return pourcentageAgios;}

    public static void setPourcentageagios(int PourcentageAgios){pourcentageAgios=PourcentageAgios;}

    public void retrait(double montant) 
    {
        if(montant <= 0) System.out.println("Erreur! vous pouvez pas faire le retrait d'un montant negative ou nul");
        else
        {
            if(this.getSolde()>= montant)
            {
                this.setSolde(this.getSolde()-montant);
            }
            else 
            {
                if((this.getSolde()+this.getSeuilDecouvert())>= montant)
                {
                    this.setSolde(this.getSolde()-montant);
                    System.out.println("Le solde est insuffisant ! vous allez payer les frais de decouvert");
                    actualiser();// actualiser() les frais de decouvert sont elevés
                    
    
                }
                else System.out.println("Impossible d'effectuer cette operation! Le montant depasse le seuil de decouvert");
        }
       
           
        }
    }
    public void actualiser()// permet d'elevé les frait de decouvert 
    {
        if(this.getSolde()<0)
        {
            this.setSolde(this.getSolde()+(this.getSolde()*pourcentageAgios/100));
        }
    }
    public String toString() // en plus de l'affichage de super() elle affiche "Compte courant" 
    {
        return "Compte Courant - "+super.toString();
    }
    
}
