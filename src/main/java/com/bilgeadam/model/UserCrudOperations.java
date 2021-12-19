package com.bilgeadam.model;

import com.bilgeadam.controller.ArtistController;
import com.bilgeadam.controller.CustomerController;
import com.bilgeadam.utils.BAUtils;
import com.bilgeadam.utils.HibernateUtils;
import com.bilgeadam.view.controller.LoginController;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class UserCrudOperations {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BAUtils baUtils = BAUtils.getInstance();
    private static final MenuItems menuItems = MenuItems.getInstance();
    private static final Logger logger = LogManager.getLogger(UserCrudOperations.class);

    /*public static void userLoginScreen() {
        int choice;
        do {
            System.out.println("Lütfen Yapmak İstediğiniz İşlemi Seçini: \n1.) Kullanıcı Girişi\n2.) Kullanıcı Kayıt\n3.) Çıkış");
            choice = scanner.nextInt();
            if (choice < 0 || choice > 3)
                System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
        } while (choice < 0 || choice > 3);
        switch (choice) {
            case 1 -> userSignIn();
            case 2 -> userSignUp();
            case 3 -> {
                System.out.println("Çıkış yapılıyor...");
                System.exit(0);
            }
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
        scanner.close();


    }*/

    private static void userSignUp() {
        CustomerEntity customerEntity = new CustomerEntity();
        CustomerController customerController = new CustomerController();
        System.out.println("Lütfen Adınızı Giriniz:");
        scanner.nextLine();
        customerEntity.setName(scanner.nextLine());
        System.out.println("Lütfen Soyadınızı Giriniz:");
        customerEntity.setSurname(scanner.nextLine());
        System.out.println("Lütfen Kullanıcı Adınızı Giriniz:");
        customerEntity.setUsername(scanner.nextLine());
        System.out.println("Lütfen Şifrenizi Giriniz:");
        customerEntity.setPassword(scanner.nextLine());
        System.out.println("Lütfen Telefon Numaranızı Giriniz:");
        customerEntity.setPhone(scanner.nextLine());
        System.out.println("Lütfen Email Adresinizi Giriniz:");
        customerEntity.setEmail(scanner.nextLine());
        System.out.println("Lütfen Adresinizi Giriniz:");
        customerEntity.setAddress(scanner.nextLine());
        customerController.create(customerEntity);
        System.out.println("Kullanıcı Kayıt İşlemi Başarıyla Gerçekleştirildi.");
        //userSignIn();
    }

    public Boolean userSignIn(String username, String password) {
        //CustomerEntity customerEntity = LoginController.customerEntity;
        boolean isValid = false;
        //CustomerController customerController = new CustomerController();
        Session session = HibernateUtils.getSessionfactory().openSession();
        session.getTransaction().begin();

        //do {
            /*System.out.println("\n\n\tKullanıcı adınızı giriniz:");
            scanner.nextLine();
            customerEntity.setUsername(scanner.nextLine());
            System.out.println("\tŞifrenizi giriniz:");
            customerEntity.setPassword(scanner.nextLine())*/;

            TypedQuery<CustomerEntity> query = session.createQuery("select c from CustomerEntity as c where username = :key1 and password = :key2", CustomerEntity.class);
            query.setParameter("key1", username);
            query.setParameter("key2", password);
            try {
                LoginController.customerEntity = query.getSingleResult();
            } catch (Exception e) {
                System.out.println("\n\n\tKullanıcı adı veya şifre hatalı");
                System.out.println("\tLütfen tekrar deneyiniz");
            }
        //} while (customerEntity.getId() == 0);
        /*System.out.println("\n\n\tHoşgeldiniz " + customerEntity.getUsername());
        userPanel();
        scanner.close();*/
        if (LoginController.customerEntity.getUsername() != null && LoginController.customerEntity.getPassword() != null) {
            isValid = true;
        } else
            isValid = false;
        return isValid;
    }

    private static void userPanel() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            baUtils.menuBodyCreator(menuItems.getUserMenuList(), "Lütfen Seçiminizi Yapınız");
            choice = scanner.nextInt();
            if (choice < 0 || choice > 8)
                System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
        } while (choice < 0 || choice > 8);

        switch (choice) {
            case 1 -> listLastAddedAlbums();
            case 2 -> listDiscountedAlbum();
            case 3 -> listAlbumsByGenres();
            case 4 -> listAlbumsByArtist();
            case 5 -> listAlbumsByOrderCount();
            case 6 -> listBestSellerArtist();
            case 7 -> purchaseList();
            case 8 -> {
                System.out.println("Çıkış yapılıyor...");
                System.exit(0);
            }
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
        scanner.close();
    }

    private static void purchaseList() {

    }

    private static void listBestSellerArtist() {

    }

    private static void listAlbumsByOrderCount() {

    }

    private static void listAlbumsByGenres() {
        System.out.println("\n\n\tLütfen Albüm Türünü Giriniz:");
        String genre = scanner.nextLine();
        try {
            Session session = HibernateUtils.getSessionfactory().openSession();
            String hql1 = "select c.albumGenre from CDEntity as c where c.albumGenre = :key1";
            TypedQuery<CDEntity> query1 = session.createQuery(hql1, CDEntity.class);
            query1.setParameter("key1", genre);
            ArrayList<CDEntity> cdEntities = (ArrayList<CDEntity>) query1.getResultList();
            for (CDEntity temp : cdEntities) {
                logger.info(temp);
            }

            String hql2 = "select d.albumGenre from DVDEntity as d where d.albumGenre = :key1";
            TypedQuery<DVDEntity> query2 = session.createQuery(hql2, DVDEntity.class);
            query2.setParameter("key1", genre);
            ArrayList<DVDEntity> dvdEntities = (ArrayList<DVDEntity>) query2.getResultList();
            for (DVDEntity temp : dvdEntities) {
                logger.info(temp);
            }

            String hql3 = "select v.albumGenre from VinylEntity as v where v.albumGenre = :key1";
            TypedQuery<VinylEntity> query3 = session.createQuery(hql3, VinylEntity.class);
            query3.setParameter("key1", genre);
            ArrayList<VinylEntity> vinylEntities = (ArrayList<VinylEntity>) query3.getResultList();
            for (VinylEntity temp : vinylEntities) {
                logger.info(temp);
            }
            System.out.println("Sonuçlar Yukarıda Gösterilmiştir.");
        } catch (Exception e) {
            System.out.println("Girmiş Olduğunuz Tür Bulunamadı. Lütfen Tekrar Deneyiniz. " + e.getMessage());
        }
        userPanel();
    }

    private static void listDiscountedAlbum() {
        Session session = HibernateUtils.getSessionfactory().openSession();
        String hql1 = "select c from CDEntity as c order by d.discount desc ,limit (5)";
        TypedQuery<CDEntity> query1 = session.createQuery(hql1, CDEntity.class);
        ArrayList<CDEntity> cdEntities = (ArrayList<CDEntity>) query1.getResultList();
        for (CDEntity temp : cdEntities) {
            logger.info(temp);
        }

        String hql2 = "select d from DVDEntity as d order by d.discount desc, limit (5)";
        TypedQuery<DVDEntity> query2 = session.createQuery(hql2, DVDEntity.class);
        ArrayList<DVDEntity> dvdEntities = (ArrayList<DVDEntity>) query2.getResultList();
        for (DVDEntity temp : dvdEntities) {
            logger.info(temp);
        }

        String hql3 = "select v from VinylEntity as v order by v.discount desc, limit (5)";
        TypedQuery<VinylEntity> query3 = session.createQuery(hql3, VinylEntity.class);
        ArrayList<VinylEntity> vinylEntities = (ArrayList<VinylEntity>) query3.getResultList();
        for (VinylEntity temp : vinylEntities) {
            logger.info(temp);
        }
        userPanel();
    }

    private static void listLastAddedAlbums() {
        Session session = HibernateUtils.getSessionfactory().openSession();
        String hql1 = "select c from CDEntity as c order by d.id desc, limit (5)";
        TypedQuery<CDEntity> query1 = session.createQuery(hql1, CDEntity.class);
        ArrayList<CDEntity> cdEntities = (ArrayList<CDEntity>) query1.getResultList();
        for (CDEntity temp : cdEntities) {
            logger.info(temp);
        }

        String hql2 = "select d from DVDEntity as d order by d.id desc, limit (5)";
        TypedQuery<DVDEntity> query2 = session.createQuery(hql2, DVDEntity.class);
        ArrayList<DVDEntity> dvdEntities = (ArrayList<DVDEntity>) query2.getResultList();
        for (DVDEntity temp : dvdEntities) {
            logger.info(temp);
        }

        String hql3 = "select v from VinylEntity as v order by v.id desc, limit (5)";
        TypedQuery<VinylEntity> query3 = session.createQuery(hql3, VinylEntity.class);
        ArrayList<VinylEntity> vinylEntities = (ArrayList<VinylEntity>) query3.getResultList();
        for (VinylEntity temp : vinylEntities) {
            logger.info(temp);
        }
        userPanel();
    }

    private static void listAlbumsByArtist() {
        ArtistController artistController = new ArtistController();
        Session session = HibernateUtils.getSessionfactory().openSession();
        String hql1 = "select distinct c from CDEntity as c order by d.albumGenre desc, limit (5)";
        TypedQuery<CDEntity> query1 = session.createQuery(hql1, CDEntity.class);
        ArrayList<CDEntity> cdEntities = (ArrayList<CDEntity>) query1.getResultList();
        for (CDEntity temp : cdEntities) {
            logger.info(temp);
        }

        String hql2 = "select distinct d from DVDEntity as d order by d.albumGenre desc, limit (5)";
        TypedQuery<DVDEntity> query2 = session.createQuery(hql2, DVDEntity.class);
        ArrayList<DVDEntity> dvdEntities = (ArrayList<DVDEntity>) query2.getResultList();
        for (DVDEntity temp : dvdEntities) {
            logger.info(temp);
        }

        String hql3 = "select distinct v from VinylEntity as v order by v.albumGenre desc, limit (5)";
        TypedQuery<VinylEntity> query3 = session.createQuery(hql3, VinylEntity.class);
        ArrayList<VinylEntity> vinylEntities = (ArrayList<VinylEntity>) query3.getResultList();
        for (VinylEntity temp : vinylEntities) {
            logger.info(temp);
        }
        userPanel();
    }

    public void verCodeGenerator() {
        UUID uuid = UUID.randomUUID();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\bilgeadam\\verification.txt"))) {
            bufferedWriter.write(uuid.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean verCodeChecker(String verCode) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\bilgeadam\\verification.txt"))) {
            String temp = bufferedReader.readLine();
            if (temp.equals(verCode)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
