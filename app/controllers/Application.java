package controllers;

import play.mvc.*;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    public static boolean index() {

        addAlcohol("Vodka",333,9.32);
        addAlcohol("Ron",500,15.28);
        addAlcohol("Naranja",2000,3.59);
/*
        Alcohol vodka = Alcohol.find("byName","Vodka").first();
        Alcohol ron = Alcohol.find("byName","Ron").first();

        List<Alcohol> list = new ArrayList<Alcohol>();

        Cocktail_Alcohol rel = new Cocktail_Alcohol();
        rel.quantitat = 10;

        Alcohol a = Alcohol.find("byName","Vodka").first();
        list.add(a);
        rel.a = a;
        addCocktail("RonCola",12,1);
        rel.c = c;
        rel.save();
        a = Alcohol.find("byName","Ron").first();
        list.add(a);

        Cocktail_Alcohol rel1 = new Cocktail_Alcohol();
        rel1.quantitat = 20;
        rel1.a = a;
        rel1.c = c;

        rel1.save();

        renderJSON(a);*/

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
        User lookForUser = User.find("byName",user).first();
        if(lookForUser==null){
            new User(user,password).save();
            return true;
        }
        else
            return false;
    }

    public static boolean addCocktail(String name, double volume, double price,String... s) {
        Cocktail lookForCocktail = Cocktail.find("byName",name).first();
        if(lookForCocktail==null){
            new Cocktail(name,volume,price).save();
            return true;
        }
        else
            return false;
    }

    public static boolean addCocktail2(String name, double volume, double price,String... s) {
        Cocktail lookForCocktail = Cocktail.find("byName",name).first();
        if(lookForCocktail==null){
            Cocktail newCocktail = new Cocktail(name,volume,price).save();
            for(int i = 0; i<s.length; i=i+2){
                Alcohol lookForAlcohol = Alcohol.find("byName",s[i].toString()).first();
                new Cocktail_Alcohol(newCocktail,lookForAlcohol, Integer.parseInt(s[i+1].toString())).save();
            }
            return true;
        }
        else
            return false;
    }

    public static boolean addAlcohol(String name, double volume, double price) {
        Alcohol lookForAlcohol = Alcohol.find("byName",name).first();
        if(lookForAlcohol==null){
            new Alcohol(name,volume,price).save();
            return true;
        }
        else
            return false;
    }

    public static boolean test(String... s){
        //renderText(s.length);
        renderText(s[2].toString());
        return true;
    }
}