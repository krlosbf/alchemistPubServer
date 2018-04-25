package models;
import play.db.jpa.Model;
import javax.persistence.Entity;

@Entity
public class  User extends Model{
    public String name;
    public String password;

    public User(){
        name=null;
        password=null;
    }

    public User(String n, String p){
        name=n;
        password=p;
    }
}
