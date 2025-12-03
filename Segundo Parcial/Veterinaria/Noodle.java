

public class Noodle {
    
    String name;
    Noodle(String n){
        name = n;
    }
}

class AsianNoodle extends Noodle {
    public boolean equals(Object o){
        AsianNoodle n = (AsianNoodle)o;
        if(name.equals(n.name)) return true;
        return false;
    }

    public int hashCode(){
        return name.length();
    }
    AsianNoodle(String s){
        super(s);
    }

public static class Soba extends AsianNoodle {
    public static void main(String[] args) {
        Noodle n1 = new Noodle("bob");
        Noodle n2 = new Noodle("bob");
        AsianNoodle a1 = new AsianNoodle("fred");
        AsianNoodle a2 = new AsianNoodle("fred");
        Soba s1 = new Soba("jill");
        Soba s2 = new Soba("jill");

        System.out.print(n1.equals(n2) + " " + (n1 == n2) + " | ");
        System.out.print(a1.equals(a2) + " " + (a1 == a2) + " | ");
        System.out.print(s1.equals(s2) + " " + (s1 == s2));

    }
    Soba(String s){
        super(s);
    }
}


}
