package com.bilgeadam.model;

import com.bilgeadam.controller.ArtistController;
import com.bilgeadam.controller.CdController;
import com.bilgeadam.controller.DvdController;
import com.bilgeadam.controller.VinylController;
import com.bilgeadam.utils.BAUtils;
import com.bilgeadam.utils.HibernateUtils;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.util.Scanner;

public class AdminCrudOperations {

    //To Create a single MenuItems object
    private static final AdminCrudOperations instance = new AdminCrudOperations();

    // To avoid MenuItems instantiated, constuctors will set private
    private AdminCrudOperations() {
    }

    //To access object
    public static AdminCrudOperations getInstance() {
        return instance;
    }

    MenuItems menuItems = MenuItems.getInstance();
    Scanner scanner = new Scanner(System.in);
    BAUtils baUtils = BAUtils.getInstance();

    /*public void showMainMenu() {

        int choice;
        do {
            baUtils.menuBodyCreator(menuItems.getLoginMenuList(), "Lütfen Seçiminizi Yapınız");
            choice = scanner.nextInt();
            if (choice < 0 || choice > 3)
                System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
        } while (choice < 0 || choice > 3);

        switch (choice) {
            case 1 -> adminLoginScreen();
            case 2 -> UserCrudOperations.userLoginScreen();
            case 3 -> {
                System.out.println("Çıkış yapılıyor...");
                System.exit(0);
            }
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
        scanner.close();
    }*/

    public Boolean adminLoginScreen(String username, String password) {
        //Scanner scanner = new Scanner(System.in);
        AdminEntity adminEntity = new AdminEntity();
        Boolean isAdmin = false;
        //adminEntity.setId(0);
        Session session = HibernateUtils.getSessionfactory().openSession();

        //do {
            //System.out.println("\n\n\tKullanıcı adınızı giriniz:");
            //adminEntity.setUsername(username);
            //System.out.println("\tŞifrenizi giriniz:");
            //adminEntity.setPassword(password);

            TypedQuery<AdminEntity> query = session.createQuery("select a from AdminEntity as a where username = :key1 and password = :key2", AdminEntity.class);
            query.setParameter("key1", username);
            query.setParameter("key2", password);
            try {
                adminEntity = query.getSingleResult();
            }catch (Exception e){
                System.out.println("\n\n\tKullanıcı adı veya şifre hatalı");
                System.out.println("\tLütfen tekrar deneyiniz");
            }
        //} while (adminEntity.getId() == 0);
        //System.out.println("\n\n\tHoşgeldiniz " + adminEntity.getUsername());
        //adminPanel();
        //scanner.close();
        if (adminEntity.getId() != 0) {
            isAdmin = true;
        } else {
            isAdmin = false;
        }
        return isAdmin;
    }

    private void adminPanel() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            baUtils.menuBodyCreator(menuItems.getAdminMenuList(), "Lütfen Seçiminizi Yapınız");
            choice = scanner.nextInt();
            if (choice < 0 || choice > 6)
                System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
        } while (choice < 0 || choice > 6);

        switch (choice) {
            case 1 -> listAlbums();
            case 2 -> addAlbum();
            case 3 -> deleteAlbum();
            case 4 -> editAlbum();
            case 5 -> showOrders();
            case 6 -> {
                System.out.println("Çıkış yapılıyor...");
                System.exit(0);
            }
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
        scanner.close();
    }

    private void showOrders() {
        Session session = HibernateUtils.getSessionfactory().openSession();
        String hql = "select o from OrderEntity as o";
        TypedQuery<OrderEntity> query = session.createQuery(hql, OrderEntity.class);
        System.out.println("\n\n\tSiparişleriniz:");
        for (OrderEntity orderEntity : query.getResultList()) {
           // System.out.println("\t" + orderEntity.getId() + ") " + orderEntity.getOrderDate() + " - " + orderEntity.getCdAlbums() + "-" + orderEntity.getDvdAlbums() + "-" + orderEntity.getVinylAlbums());
        }
    }

    private void editAlbum() {
        int choice;
        do {
            baUtils.menuBodyCreator(menuItems.getAlbumTypes(), "Lütfen Güncellemek İstediğiniz Albüm Türünü Seçiniz");
            choice = scanner.nextInt();
            if (choice < 0 || choice > 3)
                System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
        } while (choice < 0 || choice > 3);

        switch (choice) {
            case 1 -> updateDvdAlbums();
            case 2 -> updateCdAlbums();
            case 3 -> updateVinylAlbums();
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
    }

    private void updateVinylAlbums() {
        VinylController vinylController = new VinylController();
        VinylEntity vinylEntity;
        vinylController.list().forEach(System.out::println);
        System.out.println("Güncellemek istediğiniz albümün id'sini giriniz:");
        int id = scanner.nextInt();
        vinylEntity = vinylController.find(id);
        int choice;
        do {
            baUtils.menuBodyCreator(menuItems.getVinylProperties(), "Lütfen Albümün Güncellenecek Alanını Seçiniz");
            choice = scanner.nextInt();
            if (choice < 0 || choice > 8)
                System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
        } while (choice < 0 || choice > 8);

        switch (choice) {
            case 1 :
                System.out.println("Lütfen Albüm Adını Giriniz:");
                scanner.nextLine();
                vinylEntity.setAlbumName(scanner.nextLine());
                break;
            case 2 : System.out.println("Lütfen Albüm Türünü Giriniz (Örn: Pop, Rock, Metal):");
                vinylEntity.setAlbumGenre(scanner.nextLine());
                break;
            case 3 :
                System.out.println("Lütfen Albüm Fiyatını Giriniz:");
                vinylEntity.setAlbumPrice(scanner.nextDouble());
                break;
            case 4 :
                System.out.println("Lütfen Albümün İskonto Oranını Giriniz:");
                vinylEntity.setDiscount(scanner.nextDouble());
                if (vinylEntity.getDiscount() != 0)
                    vinylEntity.setDiscountedPrice(vinylEntity.getAlbumPrice() - vinylEntity.getAlbumPrice() * vinylEntity.getDiscount()/100);
                else
                    vinylEntity.setDiscountedPrice(vinylEntity.getAlbumPrice());
                break;
            case 5 :
                System.out.println("Lütfen Albümün Stok Adedini Giriniz:");
                vinylEntity.setStockCount(scanner.nextInt());
                break;
            case 6 :
                System.out.println("Lütfen Albümün Satış Durumunu Giriniz: \n1.) Satışa Açık\n2.) Satışa Kapalı");
                vinylEntity.setSalable(scanner.nextInt() == 1 ? true : false);
                if (!vinylEntity.isSalable())
                    vinylEntity.setAlbumPrice(0);
                    vinylEntity.setDiscount(0);
                    vinylEntity.setDiscountedPrice(0);
                break;
            case 7 :
                System.out.println("Lütfen Ürün Çeşidini Giriniz (Örn: LP, 45'lik, 70'lik):");
                vinylEntity.setType(scanner.nextLine());
                break;
            case 8 :
                System.out.println("Lütfen Albümün Devir Hızını Giriniz (Örn: 16 Devir, 33 Devir, 45 Devir, 78 Devir");
                vinylEntity.setRpm(scanner.nextLine());
            default :
                throw new IllegalStateException("Unexpected value: " + choice);
        }

        vinylController.update(vinylEntity);
        adminPanel();
    }

    private void updateCdAlbums() {
        CdController cdController = new CdController();
        CDEntity cdEntity;
        cdController.list().forEach(System.out::println);
        System.out.println("Güncellemek istediğiniz albümün id'sini giriniz:");
        int id = scanner.nextInt();
        cdEntity = cdController.find(id);
        int choice;
        do {
            baUtils.menuBodyCreator(menuItems.getCdProperties(), "Lütfen Albümün Güncellenecek Alanını Seçiniz");
            choice = scanner.nextInt();
            if (choice < 0 || choice > 8)
                System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
        } while (choice < 0 || choice > 8);

        switch (choice) {
            case 1 -> {
                System.out.println("Lütfen Albüm Adını Giriniz:");
                cdEntity.setAlbumName(scanner.nextLine());
            }
            case 2 -> {
                System.out.println("Lütfen Albüm Türünü Giriniz (Örn: Pop, Rock, Metal):");
                cdEntity.setAlbumGenre(scanner.nextLine());
            }
            case 3 -> {
                System.out.println("Lütfen Albüm Fiyatını Giriniz:");
                cdEntity.setAlbumPrice(scanner.nextDouble());
            }
            case 4 -> {
                System.out.println("Lütfen Albümün İskonto Oranını Giriniz:");
                cdEntity.setDiscount(scanner.nextDouble());
                if (cdEntity.getDiscount() != 0)
                    cdEntity.setDiscountedPrice(cdEntity.getAlbumPrice() - cdEntity.getAlbumPrice() * cdEntity.getDiscount()/100);
                else
                    cdEntity.setDiscountedPrice(cdEntity.getAlbumPrice());
            }
            case 5 -> {
                System.out.println("Lütfen Albümün Stok Adedini Giriniz:");
                cdEntity.setStockCount(scanner.nextInt());
            }
            case 6 -> {
                System.out.println("Lütfen Albümün Satış Durumunu Giriniz: \n1.) Satışa Açık\n2.) Satışa Kapalı");
                cdEntity.setSalable(scanner.nextInt() == 1 ? true : false);
                if (!cdEntity.isSalable())
                    cdEntity.setAlbumPrice(0);
                cdEntity.setDiscount(0);
                cdEntity.setDiscountedPrice(0);
            }
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }

        cdController.update(cdEntity);
        adminPanel();
    }

    private void updateDvdAlbums() {
        DvdController dvdController = new DvdController();
        DVDEntity dvdEntity;
        dvdController.list().forEach(System.out::println);
        System.out.println("Güncellemek istediğiniz albümün id'sini giriniz:");
        int id = scanner.nextInt();
        dvdEntity = dvdController.find(id);
        int choice;
        do {
            baUtils.menuBodyCreator(menuItems.getCdProperties(), "Lütfen Albümün Güncellenecek Alanını Seçiniz");
            choice = scanner.nextInt();
            if (choice < 0 || choice > 8)
                System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
        } while (choice < 0 || choice > 8);

        switch (choice) {
            case 1 -> {
                System.out.println("Lütfen Albüm Adını Giriniz:");
                scanner.nextLine();
                dvdEntity.setAlbumName(scanner.nextLine());
            }
            case 2 -> {
                System.out.println("Lütfen Albüm Türünü Giriniz (Örn: Pop, Rock, Metal):");
                dvdEntity.setAlbumGenre(scanner.nextLine());
            }
            case 3 -> {
                System.out.println("Lütfen Albüm Fiyatını Giriniz:");
                dvdEntity.setAlbumPrice(scanner.nextDouble());
            }
            case 4 -> {
                System.out.println("Lütfen Albümün İskonto Oranını Giriniz:");
                dvdEntity.setDiscount(scanner.nextDouble());
                if (dvdEntity.getDiscount() != 0)
                    dvdEntity.setDiscountedPrice(dvdEntity.getAlbumPrice() - dvdEntity.getAlbumPrice() * dvdEntity.getDiscount()/100);
                else
                    dvdEntity.setDiscountedPrice(dvdEntity.getAlbumPrice());
            }
            case 5 -> {
                System.out.println("Lütfen Albümün Stok Adedini Giriniz:");
                dvdEntity.setStockCount(scanner.nextInt());
            }
            case 6 -> {
                System.out.println("Lütfen Albümün Satış Durumunu Giriniz: \n1.) Satışa Açık\n2.) Satışa Kapalı");
                dvdEntity.setSalable(scanner.nextInt() == 1 ? true : false);
                if (!dvdEntity.isSalable())
                    dvdEntity.setAlbumPrice(0);
                dvdEntity.setDiscount(0);
                dvdEntity.setDiscountedPrice(0);
            }
            case 7 -> {
                System.out.println("Lütfen Albümün Görüntü Kaliesini Giriniz (Örn: SD, HD, UHD) :");
                dvdEntity.setAlbumQuality(scanner.nextLine());
            }
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }

        dvdController.update(dvdEntity);
        adminPanel();
    }

    private void deleteAlbum() {
        int choice;
        do {
            baUtils.menuBodyCreator(menuItems.getAlbumTypes(), "Lütfen Silmek İstediğiniz Albüm Türünü Seçiniz");
            choice = scanner.nextInt();
            if (choice < 0 || choice > 3)
                System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
        } while (choice < 0 || choice > 3);

        switch (choice) {
            case 1 -> deleteDvdAlbums();
            case 2 -> deleteCdAlbums();
            case 3 -> deleteVinylAlbums();
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
    }

    private void deleteVinylAlbums() {
        VinylController vinylController = new VinylController();
        VinylEntity vinylEntity;
        vinylController.list().forEach(System.out::println);
        System.out.println("Silmek istediğiniz albümün id'sini giriniz:");
        int id = scanner.nextInt();
        vinylEntity = vinylController.find(id);
        vinylController.delete(vinylEntity);
        adminPanel();
    }

    private void deleteCdAlbums() {
        CdController cdController = new CdController();
        CDEntity cdEntity;
        cdController.list().forEach(System.out::println);
        System.out.println("Silmek istediğiniz albümün id'sini giriniz:");
        int id = scanner.nextInt();
        cdEntity = cdController.find(id);
        cdController.delete(cdEntity);
        adminPanel();
    }

    private void deleteDvdAlbums() {
        DvdController dvdController = new DvdController();
        DVDEntity dvdEntity;
        dvdController.list().forEach(System.out::println);
        System.out.println("Silmek istediğiniz albümün id'sini giriniz:");
        int id = scanner.nextInt();
        dvdEntity = dvdController.find(id);
        dvdController.delete(dvdEntity);
        adminPanel();
    }

    private void addAlbum() {
        int choice;
        do {
            baUtils.menuBodyCreator(menuItems.getAlbumTypes(), "Lütfen Eklemek İstediğiniz Albüm Türünü Seçiniz");
            choice = scanner.nextInt();
            if (choice < 0 || choice > 3)
                System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
        } while (choice < 0 || choice > 3);

        switch (choice) {
            case 1 -> addDvdAlbums();
            case 2 -> addCdAlbums();
            case 3 -> addVinylAlbums();
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }

    }

    private void addVinylAlbums() {
        VinylEntity vinylEntity = new VinylEntity();
        ArtistEntity artistEntity = new ArtistEntity();
        System.out.println("Lütfen Albüm Adını Giriniz");
        vinylEntity.setAlbumName(scanner.nextLine());
        System.out.println("Lütfen Artist Adını Giriniz");
        artistEntity.setName(scanner.nextLine());
        System.out.println("Lütfen Artist Soyadını Giriniz");
        artistEntity.setSurname(scanner.nextLine());
        System.out.println("Lütfen Artist Açıklaması Giriniz");
        artistEntity.setDescription(scanner.nextLine());
        vinylEntity.setArtist(artistEntity);
        System.out.println("Lütfen Albüm Türünü Giriniz (Örn: Pop, Rock, Metal)");
        vinylEntity.setAlbumGenre(scanner.nextLine());
        System.out.println("Lütfen Vinyl Çapını inç Giriniz");
        vinylEntity.setType(scanner.nextLine());
        System.out.println("Lütfen Vinyl devir hızını giriniz");
        vinylEntity.setRpm(scanner.nextLine());
        String choice;
        do {
            System.out.println("Girmiş Olduğunuz Albüm Satışa Çıkacak Mı? (Evet/Hayır)");
            choice = scanner.nextLine();
        } while (!choice.equalsIgnoreCase("Evet") && !choice.equalsIgnoreCase("Hayır"));
        if (choice.equalsIgnoreCase("Evet")) {
            vinylEntity.setSalable(true);
            System.out.println("Lütfen Albüm Fiyatını Giriniz");
            vinylEntity.setAlbumPrice(scanner.nextDouble());
            System.out.println("Lütfen % Cinsinden İskonto Oranını Giriniz (Örn: 10, 20, 30)");
            vinylEntity.setDiscount(scanner.nextDouble());
            if (vinylEntity.getDiscount() == 0) {
                vinylEntity.setDiscountedPrice(vinylEntity.getAlbumPrice());
            }else {
                vinylEntity.setDiscountedPrice(vinylEntity.getAlbumPrice() - (vinylEntity.getAlbumPrice() * vinylEntity.getDiscount() / 100));
            }
            System.out.println("Lütfen Albüm Stok Sayısını Giriniz");
            vinylEntity.setStockCount(scanner.nextInt());
            vinylEntity.setSoldCount(0);
        }
        artistEntity.addVinyl(vinylEntity);
        ArtistController artistController = new ArtistController();
        artistController.create(artistEntity);
        adminPanel();
    }

    private void addCdAlbums() {
        CDEntity cdEntity = new CDEntity();
        ArtistEntity artistEntity = new ArtistEntity();
        System.out.println("Lütfen Albüm Adını Giriniz");
        cdEntity.setAlbumName(scanner.nextLine());
        System.out.println("Lütfen Artist Adını Giriniz");
        artistEntity.setName(scanner.nextLine());
        System.out.println("Lütfen Artist Soyadını Giriniz");
        artistEntity.setSurname(scanner.nextLine());
        System.out.println("Lütfen Artist Açıklaması Giriniz");
        artistEntity.setDescription(scanner.nextLine());
        cdEntity.setArtist(artistEntity);
        System.out.println("Lütfen Albüm Türünü Giriniz (Örn: Pop, Rock, Metal)");
        cdEntity.setAlbumGenre(scanner.nextLine());

        String choice;
        do {
            System.out.println("Girmiş Olduğunuz Albüm Satışa Çıkacak Mı? (Evet/Hayır)");
            choice = scanner.nextLine();
        } while (!choice.equalsIgnoreCase("Evet") && !choice.equalsIgnoreCase("Hayır"));
        if (choice.equalsIgnoreCase("Evet")) {
            cdEntity.setSalable(true);
            System.out.println("Lütfen Albüm Fiyatını Giriniz");
            cdEntity.setAlbumPrice(scanner.nextDouble());
            System.out.println("Lütfen % Cinsinden İskonto Oranını Giriniz (Örn: 10, 20, 30)");
            cdEntity.setDiscount(scanner.nextDouble());
            if (cdEntity.getDiscount() == 0) {
                cdEntity.setDiscountedPrice(cdEntity.getAlbumPrice());
            }else {
                cdEntity.setDiscountedPrice(cdEntity.getAlbumPrice() - (cdEntity.getAlbumPrice() * cdEntity.getDiscount() / 100));
            }
            System.out.println("Lütfen Albüm Stok Sayısını Giriniz");
            cdEntity.setStockCount(scanner.nextInt());
            cdEntity.setSoldCount(0);
        }
        artistEntity.addCd(cdEntity);
        CdController cdController = new CdController();
        cdController.create(cdEntity);
        adminPanel();
    }

    private void addDvdAlbums() {
        DVDEntity dvdEntity = new DVDEntity();
        ArtistEntity artistEntity = new ArtistEntity();
        System.out.println("Lütfen Albüm Adını Giriniz");
        scanner.nextLine();
        dvdEntity.setAlbumName(scanner.nextLine());
        System.out.println("Lütfen Artist Adını Giriniz");
        artistEntity.setName(scanner.nextLine());
        System.out.println("Lütfen Artist Soyadını Giriniz");
        artistEntity.setSurname(scanner.nextLine());
        System.out.println("Lütfen Artist Açıklaması Giriniz");
        artistEntity.setDescription(scanner.nextLine());
        dvdEntity.setArtist(artistEntity);
        System.out.println("Lütfen Albüm Türünü Giriniz (Örn: Pop, Rock, Metal)");
        dvdEntity.setAlbumGenre(scanner.nextLine());
        System.out.println("Lütfen Albüm Kalitesini Giriniz (Örn: HD, SD, UHD)");
        dvdEntity.setAlbumQuality(scanner.nextLine());

        String choice;
        do {
            System.out.println("Girmiş Olduğunuz Albüm Satışa Çıkacak Mı? (Evet/Hayır)");
            choice = scanner.nextLine();
        } while (!choice.equalsIgnoreCase("Evet") && !choice.equalsIgnoreCase("Hayır"));
        if (choice.equalsIgnoreCase("Evet")) {
            dvdEntity.setSalable(true);
            System.out.println("Lütfen Albüm Fiyatını Giriniz");
            dvdEntity.setAlbumPrice(scanner.nextDouble());
            System.out.println("Lütfen % Cinsinden İskonto Oranını Giriniz (Örn: 10, 20, 30)");
            dvdEntity.setDiscount(scanner.nextDouble());
            if (dvdEntity.getDiscount() == 0) {
                dvdEntity.setDiscountedPrice(dvdEntity.getAlbumPrice());
            }else {
                dvdEntity.setDiscountedPrice(dvdEntity.getAlbumPrice() - (dvdEntity.getAlbumPrice() * dvdEntity.getDiscount() / 100));
            }
            System.out.println("Lütfen Albüm Stok Sayısını Giriniz");
            dvdEntity.setStockCount(scanner.nextInt());
            dvdEntity.setSoldCount(0);
        }
        artistEntity.addDvd(dvdEntity);
        ArtistController artistController = new ArtistController();
        artistController.create(artistEntity);
        adminPanel();
    }

    private void listAlbums() {
        int choice;
        do {
            baUtils.menuBodyCreator(menuItems.getAlbumTypes(), "Lütfen Seçiminizi Yapınız");
            choice = scanner.nextInt();
            if (choice < 0 || choice > 4)
                System.out.println("Hatalı giriş yaptınız. Lütfen tekrar deneyiniz.");
        } while (choice < 0 || choice > 4);

        switch (choice) {
            case 1 -> listDvdAlbums();
            case 2 -> listCdAlbums();
            case 3 -> listVinylAlbums();
            case 4 -> listAllAlbums();
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
        scanner.close();
    }

    private void listAllAlbums() {
        VinylController vinylController = new VinylController();
        CdController cdController = new CdController();
        DvdController dvdController = new DvdController();
        cdController.list().forEach(System.out::println);
        vinylController.list().forEach(System.out::println);
        dvdController.list().forEach(System.out::println);
        System.out.println("Tüm Albümler Yukarıda Gösterilmiştir.");
        adminPanel();
    }

    private void listVinylAlbums() {
        VinylController vinylController = new VinylController();
        vinylController.list().forEach(System.out::println);
        System.out.println("Vinyl Albümler Yukarıda Gösterilmiştir.");
        adminPanel();
    }

    private void listCdAlbums() {
        CdController cdController = new CdController();
        cdController.list().forEach(System.out::println);
        System.out.println("CD Albümler Yukarıda Gösterilmiştir.");
        adminPanel();
    }

    private void listDvdAlbums() {
        DvdController dvdController = new DvdController();
        dvdController.list().forEach(System.out::println);
        System.out.println("DVD Albümler Yukarıda Gösterilmiştir.");
        adminPanel();
    }

}
