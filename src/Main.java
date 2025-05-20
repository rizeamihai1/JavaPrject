import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class A {
    int x = 10;
    static int y = 20;
}
class B extends A {
    int x = 30;
    static int y = 40;
}

class Main {
    public static void main(String[] args) {
        A ob = new B();
        System.out.println(ob.x + " " + ob.y);
    }
}