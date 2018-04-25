package models;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cocktail extends Model{

    private String name;
    private double volume;
    private double price;
    //private int[] id_Alcohol;
    //private int[] part_Alcohol;




    // Constructors


    public Cocktail(){
    }

    public Cocktail(String n, double v, double p/*List<Alcohol> c, int[] part*/){
        name = n;
        volume = v;
        price = p;
        //composition=new ArrayList<Alcohol>(); // cambiar cuando se pueda actualizar cocktail
        //composition.addAll(c);
        //this.part = part;
    }

    // De momento solo se crean nuevos cocktails, no se actualizan

    public boolean addCocktail(String n, double v, double p /*List<Alcohol> c,int[] part*/){

        Cocktail lookForCocktail = Cocktail.find("byName",n).first();
        if(lookForCocktail == null){
            new Cocktail(n,v,p/*,c,part*/).save();
            return true;
        }
        else
            return false;

    }

    /*@OneToMany(mappedBy="cocktail")
    private List<cocktailComposition> list;*/

    /*@ManyToMany
    @JoinTable(
            name="COCKTAIL_ALCOHOL",
            joinColumns =@JoinColumn(name="COCKTAIL_ID",referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name="ALCOHOL_ID",referencedColumnName = "ID"))
    private List<Alcohol> cocktailComposition = new ArrayList<Alcohol>();

    public List<Alcohol> getComposition(){
        return this.cocktailComposition;
    }

    public void addComposition(Alcohol a){
        this.cocktailComposition.add(a);
    }*/
}
