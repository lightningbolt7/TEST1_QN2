import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main{
    public static void removeAllDroppedStudents(int numbersArray[], Node head){
        Node original = new Node();
        original = head;
        int i=0;
        int loc = 0;
        while(head.next!=null && loc<7){
            if(i==3){
                return;
            }
            if(numbersArray[i]==1){
                original = head.next;
                 displayNode(original);
                System.out.println();
                i++;
            }
            if(head.val == numbersArray[i]-1){
                head.next = head.next.next;
                displayNode(original);
                System.out.println();
                i++;
            }
            head = head.next;
            loc++;
           
        }
        head.next = null; // removing last node



    }
    public static void initialiseNode(Node head){
        int i=2;
        while(i!=10){
            Node newLisNode = new Node(i);
            head.next=newLisNode;
            head = head.next;
            i++;
            newLisNode = null;
        }
    }
    public static void displayNode(Node head){
        while(head.next!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Node head = new Node(1);
        initialiseNode(head);
        //displayNode(head);
        FileInputStream FileStream = new FileInputStream("numbers.txt"); 
        Scanner scnr = new Scanner(FileStream);
        int numbersArray[] = new int[3];
         int i = 0;
        while(scnr.hasNextInt()){
          
            numbersArray[i]= scnr.nextInt();
            i++;
        }
        removeAllDroppedStudents(numbersArray, head);
       
    }
}