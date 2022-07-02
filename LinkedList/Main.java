package LinkedList;

public class Main {
  public static void main(String[] args) {

        LinkedList l1=new LinkedList();

        for(int i=1;i<=5;i++)
        l1.addLast(i);

        l1.display();


     l1.addAt(5,99);
        l1.display();
        System.out.println(l1.size());

    }
}
