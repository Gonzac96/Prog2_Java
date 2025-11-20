// Teoría
public class BobTest {
    public static void main(String[] args) {
        Bob h = new Bob("Bobby", 42);
        Bob g = new Bob();
        System.out.println(h);
        System.out.println(g);
    }
}

class Bob {
    int shoeSize;
    String nickName;
    Bob(){
        
    }
    Bob(String nickName, int shoeSize) {
        this.nickName = nickName;
        this.shoeSize = shoeSize;
    }
    public String toString() {
        return ("I am a Bob, but you can call me " + nickName + " and my shoe size is " + shoeSize);
    }
}
