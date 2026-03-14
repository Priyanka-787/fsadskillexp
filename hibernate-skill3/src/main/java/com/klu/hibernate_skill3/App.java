package com.klu.hibernate_skill3;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            /* ------------------------------------------------------
               STEP 2: INSERT PRODUCTS (RUN THIS ONCE ONLY)
               ------------------------------------------------------
            Product p1 = new Product("Laptop", "Electronics", 55000, 5);
            Product p2 = new Product("Mouse", "Electronics", 500, 50);
            Product p3 = new Product("Chair", "Furniture", 3000, 15);
            Product p4 = new Product("Table", "Furniture", 7000, 7);
            Product p5 = new Product("Pen", "Stationery", 10, 100);
            Product p6 = new Product("Notebook", "Stationery", 50, 40);
            Product p7 = new Product("Bag", "Travel", 1200, 20);
            Product p8 = new Product("Headphones", "Electronics", 1500, 10);

            session.save(p1);
            session.save(p2);
            session.save(p3);
            session.save(p4);
            session.save(p5);
            session.save(p6);
            session.save(p7);
            session.save(p8);
            */

            /* ------------------------------------------------------
               STEP 3: SORTING (HQL)
               ------------------------------------------------------ */
            System.out.println("\n1. Price ASC:");
            List<Product> ascPrice = session
                    .createQuery("FROM Product ORDER BY price ASC", Product.class)
                    .list();
            ascPrice.forEach(System.out::println);

            System.out.println("\n2. Price DESC:");
            List<Product> descPrice = session
                    .createQuery("FROM Product ORDER BY price DESC", Product.class)
                    .list();
            descPrice.forEach(System.out::println);

            /* ------------------------------------------------------
               STEP 4: SORT BY QUANTITY DESC
               ------------------------------------------------------ */
            System.out.println("\n3. Quantity Highest First:");
            List<Product> qtySort = session
                    .createQuery("FROM Product ORDER BY quantity DESC", Product.class)
                    .list();
            qtySort.forEach(System.out::println);

            /* ------------------------------------------------------
               STEP 5: PAGINATION
               ------------------------------------------------------ */
            System.out.println("\n4. First 3 Products:");
            Query<Product> q1 = session.createQuery("FROM Product", Product.class);
            q1.setFirstResult(0);
            q1.setMaxResults(3);
            q1.list().forEach(System.out::println);

            System.out.println("\n5. Next 3 Products:");
            Query<Product> q2 = session.createQuery("FROM Product", Product.class);
            q2.setFirstResult(3);
            q2.setMaxResults(3);
            q2.list().forEach(System.out::println);

            /* ------------------------------------------------------
               STEP 6: AGGREGATE FUNCTIONS
               ------------------------------------------------------ */
            System.out.println("\n6a. Total Product Count:");
            Long totalCount = session
                    .createQuery("SELECT COUNT(*) FROM Product", Long.class)
                    .uniqueResult();
            System.out.println(totalCount);

            System.out.println("\n6b. Count where quantity > 0:");
            Long qtyCount = session
                    .createQuery("SELECT COUNT(*) FROM Product WHERE quantity > 0", Long.class)
                    .uniqueResult();
            System.out.println(qtyCount);

            System.out.println("\n6c. Count grouped by description:");
            List<Object[]> groupCount = session
                    .createQuery("SELECT description, COUNT(*) FROM Product GROUP BY description", Object[].class)
                    .list();
            for(Object[] r : groupCount) {
                System.out.println(r[0] + " → " + r[1]);
            }

            System.out.println("\n6d. Min & Max Price:");
            Object[] minmax = session
                    .createQuery("SELECT MIN(price), MAX(price) FROM Product", Object[].class)
                    .uniqueResult();
            System.out.println("Min Price: " + minmax[0] + ", Max Price: " + minmax[1]);

            /* ------------------------------------------------------
               STEP 7: GROUP BY DESCRIPTION
               ------------------------------------------------------ */
            System.out.println("\n7. Group by Description:");
            List<Product> groupByDesc = session
                    .createQuery("FROM Product GROUP BY description", Product.class)
                    .list();
            groupByDesc.forEach(System.out::println);

            /* ------------------------------------------------------
               STEP 8: WHERE PRICE RANGE
               ------------------------------------------------------ */
            System.out.println("\n8. Price between 1000 and 10000:");
            List<Product> priceRange = session
                    .createQuery("FROM Product WHERE price BETWEEN 1000 AND 10000", Product.class)
                    .list();
            priceRange.forEach(System.out::println);

            /* ------------------------------------------------------
               STEP 9: LIKE QUERIES
               ------------------------------------------------------ */
            System.out.println("\n9a. Name starts with 'P':");
            session.createQuery("FROM Product WHERE name LIKE 'P%'", Product.class)
                    .list().forEach(System.out::println);

            System.out.println("\n9b. Name ends with 'e':");
            session.createQuery("FROM Product WHERE name LIKE '%e'", Product.class)
                    .list().forEach(System.out::println);

            System.out.println("\n9c. Name contains 'oo':");
            session.createQuery("FROM Product WHERE name LIKE '%oo%'", Product.class)
                    .list().forEach(System.out::println);

            System.out.println("\n9d. Name length = 5:");
            session.createQuery("FROM Product WHERE LENGTH(name) = 5", Product.class)
                    .list().forEach(System.out::println);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
