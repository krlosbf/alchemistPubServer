package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Relacio extends Model {

    public int quantitat;

    @ManyToOne
    public Cocktail c;

    @ManyToOne
    public Alcohol a;


}
