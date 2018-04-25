package models;
import play.db.jpa.Model;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Alcohol extends Model{
    private String name;
    private double volume;
    private double price;

    // Constructors
    public Alcohol(){};

    private Alcohol(String n, double v, double p){
        name = n;
        volume = v;
        price = p;
    }


    public boolean addAlcohol(String n, double v, double p){

        Alcohol lookForAlcohol = Alcohol.find("byName",n).first();
        if(lookForAlcohol == null){
            new Alcohol(n,v,p).save();
            return true;
        }
        else
            return false;

    }

    /*@OneToMany(mappedBy="alcohol")
    private List<cocktailComposition> list;*/
}
