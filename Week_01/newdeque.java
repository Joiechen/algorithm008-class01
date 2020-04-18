package Week_01;

import java.util.Deque;
import java.util.LinkedList;

public class newdeque {

    public static void newdequeapi() {
        Deque<String> deque = new LinkedList<String>();

        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size()>0){
            System.out.println(deque.pop());
        }

        System.out.println(deque);

    }

    public static void main(String[] args) {
        newdequeapi();
    }

}