package controllers;

import play.mvc.*;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    public static boolean index() {

        /*Alcohol a = new Alcohol("Ron",1,1).save();
        //addAlcohol("Ron",1,1);

        //Alcohol a = Alcohol.find("byName","Ron").first();

        Cocktail c = new Cocktail();
        c.addCocktail("RonCola",1,1);
        c.getComposition().add(a);

        //List<Alcohol> la = c.getComposition();
        //renderText(la.get(0).name);


*/

        Alcohol a = new Alcohol();
        a.addAlcohol("Vodka",333,9.32);
        a.addAlcohol("Ron",500,15.28);
        List<Alcohol> list = new ArrayList<Alcohol>();

        Relacio rel = new Relacio();
        rel.quantitat = 10;

        a = Alcohol.find("byName","Vodka").first();
        list.add(a);
        rel.a = a;
        Cocktail c =new Cocktail("RonCola",12,1).save();
        //c.addCocktail("RonCola",12,1);
        rel.c = c;
        rel.save();
        a = Alcohol.find("byName","Ron").first();
        list.add(a);

        //Cocktail c =new Cocktail();
        //c.addCocktail("RonCola",12,1);

        Relacio rel1 = new Relacio();
        rel1.quantitat = 20;
        rel1.a = a;
        rel1.c = c;

        rel1.save();

        //renderJSON(list);
        renderJSON(a);

        return true;
    }

    public static boolean logIn(String user, String password) {
        User u = User.find("byName",user).first();
        if(u!=null){
            if(u.password.equals(password))
            {
                renderText("Hola "+user);
                return true;
            }
        }
        renderText("Datos incorrectos");
        return false;

    }

    public static boolean registerUser(String user, String password) {
        User newUser = new User(user,password);
        User lookForUser = User.find("byName",user).first();

        if(lookForUser==null || !newUser.name.equals(lookForUser.name)){
            newUser.save();
            return true;
        }else{
            return false;
        }
    }

    public static boolean addAlcohol(String name, double volume, double price) {
        Alcohol a = new Alcohol();
        return a.addAlcohol(name,volume,price);
    }

    public static boolean addCocktail(String name, double volume, double price, List<Alcohol> alcohol,int[] part) {
        Cocktail c = new Cocktail();
        return c.addCocktail(name,volume,price/*,alcohol,part*/);
    }

    /*public static boolean addAlcohol(String name, double volume, double price) {
        Alcohol newAlcohol = new Alcohol(name,volume,price);
        Alcohol lookForAlcohol = Alcohol.find("byName",name).first();

        if(lookForAlcohol==null || !newAlcohol.name.equals(lookForAlcohol.name)){
            newAlcohol.save();
            return true;
        }else{
            return false;
        }
    }*/

}