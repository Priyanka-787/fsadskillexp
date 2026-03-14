package com.main;


import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.product.entity.HibernateUtil;
import com.product.entity.Product;
public class MainApp 
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n PRODUCT CRUD MENU");
            System.out.println("1. Insert Product");
            System.out.println("2. Get All Products");
            System.out.println("3. Get Product By ID");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) 
            {
               
                case 1: 
                {
                    Session session = HibernateUtil.getSessionFactory().openSession();
                    Transaction tx = session.beginTransaction();
                    Product p = new Product();

                    System.out.print("Enter Product ID: ");
                    p.setPid(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    p.setPname(sc.nextLine());

                    System.out.print("Enter Product Description: ");
                    p.setPdescription(sc.nextLine());

                    System.out.print("Enter Product Price: ");
                    p.setPrice(Integer.parseInt(sc.nextLine()));

                    System.out.print("Enter Product Quantity: ");
                    p.setQuantity(Integer.parseInt(sc.nextLine()));

                    session.persist(p);
                    tx.commit();
                    session.close();

                    System.out.println("Product Inserted Successfully");

                    break;
                }
                
                case 2: 
                {
                    Session session = HibernateUtil.getSessionFactory().openSession();
                    List<Product> list =session.createQuery("from Product", Product.class).list();
                    System.out.println("PID\tPNAME\t\t\tPDESCRIPTION\t\tPRICE\tPQUANTITY");

                    for (Product p : list) {
                    	System.out.println( p.getPid() + "\t" + p.getPname() + "\t\t" + p.getPdescription() + "\t\t" +  p.getPrice() + "\t" + p.getQuantity());
                    }
                    session.close();
                    break;
                }
                
                case 3: 
                {
                    Session session = HibernateUtil.getSessionFactory().openSession();
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    Product p = session.get(Product.class, id);
                    System.out.println("PID\tPNAME\t\t\tPDESCRIPTION\t\tPRICE\tPQUANTITY");
                    if (p != null) 
                    {
                    	System.out.println( p.getPid() + "\t" + p.getPname() + "\t\t" + p.getPdescription() + "\t\t" +  p.getPrice() + "\t" + p.getQuantity());
                    } 
                    else 
                    {
                        System.out.println("Product Not Found");
                    }
                    session.close();
                    break;
                }

                case 4: 
                {
                    Session session = HibernateUtil.getSessionFactory().openSession();
                    Transaction tx = session.beginTransaction();

                    System.out.print("Enter Product ID to Update: ");
                    int id = sc.nextInt();
                    Product p = session.get(Product.class, id);
                    if (p != null) 
                    {
                    	System.out.print("Enter 'p' to update Price or 'q' to update Quantity: ");
                        char choiceforporq = sc.next().toLowerCase().charAt(0);

                        if (choiceforporq == 'p')
                        {
                            System.out.print("Enter New Price: ");
                            p.setPrice(sc.nextInt());
                        }
                        else if (choiceforporq == 'q')
                        {
                            System.out.print("Enter New Quantity: ");
                            p.setQuantity(sc.nextInt());
                        }
                        session.merge(p);
                        tx.commit();
                        System.out.println("Product Updated Successfully");
                    } 
                    else 
                    {
                        System.out.println("Product Not Found");
                    }
                    session.close();
                    break;
                }

                
                case 5: 
                {
                    Session session = HibernateUtil.getSessionFactory().openSession();
                    Transaction tx = session.beginTransaction();
                    System.out.print("Enter Product ID to Delete: ");
                    int id = sc.nextInt();
                    Product p = session.get(Product.class, id);

                    if (p != null) {
                        session.remove(p);
                        tx.commit();
                        System.out.println("Product Deleted Successfully");
                    } 
                    else 
                    {
                        System.out.println("Product Not Found");
                    }
                    session.close();
                    break;
                }

                case 0:
                    System.out.println("Exiting Application");
                    HibernateUtil.getSessionFactory().close();
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 0);

        sc.close();
    }
}
