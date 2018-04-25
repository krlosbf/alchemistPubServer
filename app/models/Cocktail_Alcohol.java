package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Cocktail_Alcohol extends Model {

    public int quantitat;

    public Cocktail_Alcohol(Cocktail c, Alcohol a, int q){
        this.quantitat = q;
        this.cocktail = c;
        this.alcohol = a;
    }

    @ManyToOne
    public Cocktail cocktail;

    @ManyToOne
    public Alcohol alcohol;


}
