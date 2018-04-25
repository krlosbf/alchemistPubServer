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

    // Constructors

    public Cocktail(){
    }

    public Cocktail(String n, double v, double p){
        name = n;
        volume = v;
        price = p;
    }
    // De momento solo se crean nuevos cocktails, no se actualizan
}
