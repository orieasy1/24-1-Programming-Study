package homework.hw3;

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many books do you want to add to the library?");
        int bookNum = scanner.nextInt();

        Book[] books = new Book[bookNum];

        for (int i = 0; i < bookNum; i++) {

            System.out.println("Enter book title or type 'stop' to finish: ");
            String title = scanner.next();
            if(title.equals("stop")){
                break;
            }

            System.out.println("Enter author's name: ");
            String author = scanner.next();
            if(author.equals("stop")){
                break;
            }

            books[i] = new Book(title, author);
        }

        for (int i = 0; i < bookNum; i++) {
            if (books[i] != null) {
                System.out.println("Title: " + books[i].getTitle() + ", Author: " + books[i].getAuthor());
            }
        }

    }

}
