package com.bilgeadam.model;

import com.bilgeadam.utils.BAUtils;
import com.bilgeadam.utils.HibernateUtils;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.util.*;
import java.lang.*;


public class MenuItems {
    //To Create a single MenuItems object
    private static final MenuItems instance = new MenuItems();

    // To avoid MenuItems instantiated, constuctors will set private
    private MenuItems() {
    }

    //To access object
    public static MenuItems getInstance() {
        return instance;
    }

    public List<String> getLoginMenuList() {
        List<String> mainMenuList = new ArrayList<>();
        mainMenuList.add("Yetkili Girişi");
        mainMenuList.add("Kullanıcı Girişi");
        mainMenuList.add("Çıkış");
        return mainMenuList;
    }

    public List<String> getAdminMenuList() {
        List<String> adminMenuList = new ArrayList<>();
        adminMenuList.add("Albümleri Listele");
        adminMenuList.add("Albüm Ekle");
        adminMenuList.add("Albüm Sil");
        adminMenuList.add("Albüm Düzenle");
        adminMenuList.add("Siparişleri Görüntüle");
        adminMenuList.add("Çıkış");
        return adminMenuList;
    }

    public List<String> getAlbumTypes() {
        List<String> albumTypes = new ArrayList<>();
        albumTypes.add("DVD");
        albumTypes.add("CD");
        albumTypes.add("Vinyl");
        albumTypes.add("Tüm Albümler");
        return albumTypes;

    }

    public List<String> getVinylProperties() {
        List<String> vinylProperties = new ArrayList<>();
        vinylProperties.add("Albüm Adı");
        vinylProperties.add("Albüm Türü");
        vinylProperties.add("Albüm Fiyatı");
        vinylProperties.add("İskonto Oranı");
        vinylProperties.add("Stok Adedi");
        vinylProperties.add("Satış Durumu");
        vinylProperties.add("Ürün Çeşidi");
        vinylProperties.add("Devir Hızı");
        return vinylProperties;
    }

    public List<String> getCdProperties() {
        List<String> cdProperties = new ArrayList<>();
        cdProperties.add("Albüm Adı");
        cdProperties.add("Albüm Türü");
        cdProperties.add("Albüm Fiyatı");
        cdProperties.add("İskonto Oranı");
        cdProperties.add("Stok Adedi");
        cdProperties.add("Satış Durumu");
        return cdProperties;
    }

    public List<String> getDvdProperties() {
        List<String> dvdProperties = new ArrayList<>();
        dvdProperties.add("Albüm Adı");
        dvdProperties.add("Albüm Türü");
        dvdProperties.add("Albüm Fiyatı");
        dvdProperties.add("İskonto Oranı");
        dvdProperties.add("Stok Adedi");
        dvdProperties.add("Satış Durumu");
        dvdProperties.add("Görüntü Kalitesi");

        return dvdProperties;
    }

    public List<String> getUserMenuList() {
        List<String> userMenuList = new ArrayList<>();
        userMenuList.add("Son Eklenen Albümleri Listele");
        userMenuList.add("İndirimli Albümleri Listele");
        userMenuList.add("Türlere Göre Albümleri Listele");
        userMenuList.add("Sanatçılara Göre Albümleri Listele");
        userMenuList.add("En Çok Sipariş Edilen Albümleri Listele");
        userMenuList.add("Çok Satan Sanatçıları Listele");
        userMenuList.add("Sepete Git");
        userMenuList.add("Çıkış");
        return userMenuList;
    }

    public List<String> getOrdersList() {
        return null;
    }




}
