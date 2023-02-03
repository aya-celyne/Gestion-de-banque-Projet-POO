public abstract class Compte {
    // attribus
    private double solde;
    private Client titulaire;
    private int numero;
    //cons numero unique
    

    // Const
    public Compte(){};
    public Compte(Client client ,double solde)
    {
        this.titulaire=client;this.solde=solde;client.Mescomptes.add(this);
        //Ce code va gérer les numeros de comptes tel que le numero de compte va etre int de 8 numeros et composer 
       // de hashcode de (nom+prenom) de leur titulaire +le hashcode de compte 
        int id =this.titulaire.getNom().hashCode() +this.hashCode();
        int length = String.valueOf(id).length();
        int Max_Length = 8;
        if(String.valueOf(id).length()>Max_Length) 
        {
            id = (int) (id /Math.pow(10.0,length - Max_Length ));
        }
        if(id>0) this.numero=id;
        else this.numero=-id;
        
    }

        
    
    //methodes
     public double getSolde(){return this.solde;}
     public int getNumero(){return this.numero;}
     public String getNomTitulaire(){return this.titulaire.getNom();}
     public Client getTitulaire(){return this.titulaire;}
     public void setSolde(double solde) // modifier le solde de compte 
     {
         this.solde=solde;
     }
     public void depot(double montant) // pour deposer un montant 
     {
         if(montant<=0) System.out.println("Erreur ! Vous pouvez pas Deposer un montant negative a votre compte ou nul");
         else this.solde=this.solde+montant;
     }
     public String toString() // la methode toString return le le titulaire de compte + le numero de compte 
     {
         return this.titulaire.getNom()+"- N° Compte:"+this.numero;
     }
     public abstract void actualiser();


}

