package com.javamsdt.hibernatexml;

import com.javamsdt.hibernatexml.model.entity.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static void main(String[] args) {
        System.out.println("Hibernate Xml");

        Scanner in = new Scanner(System.in);
        String m = "";
        System.out.println("Enter A message: ");
        m = in.nextLine();


        try{
            Configuration conf = new Configuration().configure();
            serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            sessionFactory = metadata.buildSessionFactory();
        }catch (Throwable ex){
            System.err.println("Failed to Create Session Factory Object" + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Session session = sessionFactory.openSession();

        Transaction tx = null;
        Integer msgId = null;

        try {
            tx = session.beginTransaction();
            Message msg = new Message(m);
             session.save(msg);
            List messages = session.createQuery("From Message").list();
            for (Iterator iterator = messages.iterator(); iterator.hasNext();){
                Message message = (Message) iterator.next();
                System.out.println("Message: " + message.getMessage());
            }
            tx.commit();

        }catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

        StandardServiceRegistryBuilder.destroy(serviceRegistry);


    }
}
