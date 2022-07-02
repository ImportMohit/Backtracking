package LinkedList;

public class LinkedList {


    public LinkedList() {

    }

    private class Node{
        int data;
        Node next;

        private Node(int data,Node next){
            this.data=data;
            this.next=next;
        }

    }


   private Node head;



    public LinkedList(int data){

        this.head=new Node(data,null);

    }




    public void addFirst(int ele){
        if(head==null) {
            head = new Node(ele, null);
            return;
        }

            Node newn=new Node(ele,head);
            head=newn;


    }

    public void addLast(int ele){

        if(head==null){
            head=new Node(ele,null);
            return;
        }

         Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=new Node(ele,null);



    }

     public void addAt(int idx,int ele){
        if(idx==0)
            addFirst(ele);
        else{
            Node temp=head;
            int curr=0;
            while(curr<idx-1 && temp.next!=null) {
                temp = temp.next;
                curr++;
            }

            if(curr!=idx-1)
                throw new RuntimeException("Invalid index to add");

            if(temp.next==null)
                addLast(ele);
            else{

               Node newn=new Node(ele, temp.next);

                temp.next=newn;

            }


        }
     }
    public int getFirst(){

        if(head==null)
            throw  new RuntimeException("Empty LinkedList");

        return head.data;

    }

    public int getLast(){
        if(head==null)
            throw  new RuntimeException("Empty LinkedList");

        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
       return temp.data;
    }

    public int getAt(int idx){

        int curr=0;

        Node temp=head;

        while(curr<idx && temp!=null){
            temp=temp.next;
            curr++;
        }

        if(temp==null)
            throw new RuntimeException("Index not available");

        return temp.data;

    }

    private Node getNodeAt(int idx){
        int curr=0;

        Node temp=head;

        while(curr<idx && temp!=null){
            temp=temp.next;
            curr++;
        }

        if(temp==null)
            throw new RuntimeException("Index not available");

        return temp;
    }

    public int deleteFirst(){
        if(head==null)
            throw  new RuntimeException("Empty LinkedList");

        int temp=head.data;
        head=head.next;

        return temp;

    }
    public int deleteLast(){
        if(head==null)
            throw  new RuntimeException("Empty LinkedList");

        if(size()==1)
        {
            int ans=head.data;
            head=null;
            return ans;
        }

        Node temp=head;

        while( temp.next.next!=null)
             temp=temp.next;

        int ans=temp.next.data;

        temp.next=null;

         return ans;

    }

    public int deleteAt(int idx){
        int curr=0;

        Node temp=head;

        while(curr<idx-1 && temp!=null){
            temp=temp.next;
            curr++;
        }



        if(temp==null || temp.next==null )
            throw new RuntimeException("Index not available");

        int ans=temp.next.data;

        temp.next=temp.next.next;

        return ans;


    }
    public void display(){

        Node temp=this.head;

        System.out.print("[ ");
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

         System.out.println("]");

    }

    public int size(){

        int len=0;

        Node temp=head;
        while(temp!=null) {
            len++;
            temp=temp.next;
        }

        return len;

    }

    public  boolean isEmpty(){
        return head==null;
    }












}
