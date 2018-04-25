package models;
import play.db.jpa.Model;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class  Alcohol extends Model{
    public String name;
    public double volume;
    public double price;

    // Constructors
    public Alcohol(){};

    public Alcohol(String n, double v, double p){
        name = n;
        volume = v;
        price = p;
    }
}
