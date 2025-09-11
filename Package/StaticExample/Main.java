package StaticExample;
// Static variable are independent of variable
public class Main {
    public static void main(String[] args) {
        Human Madhur=new Human(20,"Madhur Rastogi",0,false);
        Human Rahul=new Human(24,"Rahul Rastogi",1000,true);
        System.out.println(Human.population);
        System.out.println(Human.population);
    }
}
