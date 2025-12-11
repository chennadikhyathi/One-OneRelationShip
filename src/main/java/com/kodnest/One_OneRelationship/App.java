package com.kodnest.One_OneRelationship;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book name, price, no of pages: ");
        Book book = new Book(sc.nextLine(),sc.nextInt(),sc.nextInt());
        System.out.println("Enter Author name, gender,age,address");
        Author author = new Author(sc.next(), sc.next(), sc.nextInt(), sc.next());
        book.setAuthor(author);
        
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(book);
        transaction.commit();
        session.close();
        factory.close();
        sc.close();
    }
}
