import java.time.LocalDate;
import java.util.Vector;

public class Client{
    //  attribus
    private String nom;
    private String prenom;
    private String adress;
    private LocalDate date_naissance;
    private int NbrCompteCourant=0;// j'ai ajouté cet attribut pour controler le nombre de compte courant que le client peut avoir
    public Vector Mescomptes=new Vector<Compte>();

    // Constructeur

    public Client(String Cl_nom,String Cl_prenom,String Cl_adress, LocalDate Cl_DN )
    {
        this.nom=Cl_nom.toUpperCase();
        String s=Cl_prenom.toLowerCase();
        char[]x=s.toCharArray();x[0]=Character.toUpperCase(x[0]);
        this.prenom=String.valueOf(x);
        this.adress=Cl_adress;
        this.date_naissance=Cl_DN;
    }

    // methodes
    public int getNbrvompteCourant(){return this.NbrCompteCourant;}
    public void setNbrCompteCourant(int Nbr){this.NbrCompteCourant=Nbr;}
    public String getNom(){ return this.nom+' '+this.prenom;}
    public String getAdress(){return this.adress;}
    public String toString()
    {
        return this.nom+' '+this.prenom+' '+'('+this.date_naissance+')';
    }
    // methode afficher() va afficher tous les compte d'un client
    // elle va parcourir le vector Mescomptes
    public void afficher()
    {
        System.out.println("Nombre de Compte de "+this.getNom()+" est :"+this.Mescomptes.size());
        for(Integer i=0;i<this.Mescomptes.size();i++)
        {
            System.out.println(((Compte)this.Mescomptes.get(i)));
            System.out.println(((Compte)this.Mescomptes.get(i)).getSolde() +"DA");
        }
    }
   @Override
   public boolean equals(Object o) { // cette methode compare l'egalité de deux objets Client 
                                     // elle prend en compte les nom et le prenom 
       //TODO Auto-generated method stub
       if(o==this) return true;
       if(!(o instanceof Client)) return false;
       Client cl=(Client) o;
       String s1=this.nom+this.prenom;
       String s2=cl.nom+cl.prenom;
       return  (s1).equals(s2);
   }

 
}
