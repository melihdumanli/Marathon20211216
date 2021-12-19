package com.bilgeadam.model;

import com.bilgeadam.controller.ArtistController;
import com.bilgeadam.controller.CdController;
import com.bilgeadam.controller.DvdController;
import com.bilgeadam.controller.VinylController;

public class DataCreator {

    public static void createData() {
        ArtistEntity artist1 = new ArtistEntity();
        artist1.setName("Müslüm");
        artist1.setSurname("Gürses");
        artist1.setDescription("Müslüm Gürses ya da doğum adıyla Müslüm Akbaş, Türk arabesk ve halk müziği sanatçısı, besteci, söz yazarı ve oyuncu.");

        ArtistEntity artist2 = new ArtistEntity();
        artist2.setName("Duman");
        artist2.setSurname(" ");
        artist2.setDescription("Duman, 1999 yılında kurulmuş, vokalist Kaan Tangöze, gitarist Batuhan Mutlugil, bas gitarist Ari Barokas ve baterist Mehmet Demirdelen'den oluşan Türk Rock grubu.");

        ArtistEntity artist3 = new ArtistEntity();
        artist3.setName("Miles");
        artist3.setSurname("Davis");
        artist3.setDescription("Miles Dewey Davis III, Amerikalı caz trompetçisi, şef ve bestecidir.");

        ArtistEntity artist4 = new ArtistEntity();
        artist4.setName("Athena");
        artist4.setSurname(" ");
        artist4.setDescription("Athena; İstanbul, Türkiye kökenli ska ve punk rock grubu. Gökhan Özoğuz ve Hakan Özoğuz kardeşler grubun kurucu üyeleridir.");

        ArtistEntity artist5 = new ArtistEntity();
        artist5.setName("Mor ve Ötesi");
        artist5.setSurname(" ");
        artist5.setDescription("Mor ve Ötesi, Ocak 1995'te Harun Tekin, Alper Tekin, Derin Esmer ve Kerem Kabadayı tarafından İstanbul'da kurulan Türk alternatif rock müzik grubu");

        ArtistEntity artist6 = new ArtistEntity();
        artist6.setName("Gipsy Kings");
        artist6.setSurname(" ");
        artist6.setDescription("Gipsy Kings, Rumba-flamenko tarzı müzikleriyle tanınan, İspanyol Çingenelerinden oluşan müzik grubu.");

        ArtistEntity artist7 = new ArtistEntity();
        artist7.setName("Dream Theater");
        artist7.setSurname(" ");
        artist7.setDescription("Dream Theater, ABD/New York'tan çıkmış progresif metal grubudur. 1990'ların başında Amerika'da başlayan progresif metal hareketinin başı çeken gruplarındandır.");

        ArtistEntity artist8 = new ArtistEntity();
        artist8.setName("Tarkan");
        artist8.setSurname("Tevetoğlu");
        artist8.setDescription("Tarkan Tevetoğlu, Türk şarkıcı-şarkı yazarıdır. 1990'ların başından itibaren Türk pop müziğinde yakaladığı devamlı liste ve satış başarılarıyla hem Türkiye'de hem de Avrupa'da tanındı.");

        ArtistEntity artist9 = new ArtistEntity();
        artist9.setName("Metallica");
        artist9.setSurname(" ");
        artist9.setDescription("\"Metallica, 1981 yılında kurulan Amerikalı bir heavy metal grubudur.");

        ArtistEntity artist10 = new ArtistEntity();
        artist10.setName("Tommy");
        artist10.setSurname("Emmanuel");
        artist10.setDescription("William Thomas Emmanuel AM, Avustralyalı bir gitarist. Genellikle tüm zamanların en büyük akustik gitaristlerinden biri olarak kabul edilir.");

        CDEntity cd1 = new CDEntity();
        cd1.setAlbumName("Küskünüm");
        cd1.setAlbumGenre("Arabesk");
        cd1.setAlbumPrice(30);
        cd1.setDiscount(15);
        cd1.setDiscountedPrice(calculateDiscountedPrice(cd1.getAlbumPrice(), cd1.getDiscount()));
        cd1.setStockCount(10);
        cd1.setSoldCount(0);
        cd1.setSalable(true);
        cd1.setArtist(artist1);

        CDEntity cd2 = new CDEntity();
        cd2.setAlbumName("Darmaduman");
        cd2.setAlbumGenre("Rock");
        cd2.setAlbumPrice(150);
        cd2.setDiscount(10);
        cd2.setDiscountedPrice(calculateDiscountedPrice(cd2.getAlbumPrice(), cd2.getDiscount()));
        cd2.setStockCount(10);
        cd2.setSoldCount(0);
        cd2.setSalable(true);
        cd2.setArtist(artist2);

        CDEntity cd3 = new CDEntity();
        cd3.setAlbumName("Bitches Brew");
        cd3.setAlbumGenre("Blues");
        cd3.setAlbumPrice(120);
        cd3.setDiscount(20);
        cd3.setDiscountedPrice(calculateDiscountedPrice(cd3.getAlbumPrice(), cd3.getDiscount()));
        cd3.setStockCount(10);
        cd3.setSoldCount(0);
        cd3.setSalable(true);
        cd3.setArtist(artist3);

        CDEntity cd4 = new CDEntity();
        cd4.setAlbumName("Holigan");
        cd4.setAlbumGenre("Rock");
        cd4.setAlbumPrice(50);
        cd4.setDiscount(0);
        cd4.setDiscountedPrice(calculateDiscountedPrice(cd4.getAlbumPrice(), cd4.getDiscount()));
        cd4.setStockCount(10);
        cd4.setSoldCount(0);
        cd4.setSalable(true);
        cd4.setArtist(artist4);

        CDEntity cd5 = new CDEntity();
        cd5.setAlbumName("Dünya Yalan Söylüyor");
        cd5.setAlbumGenre("Rock");
        cd5.setAlbumPrice(45);
        cd5.setDiscount(0);
        cd5.setDiscountedPrice(calculateDiscountedPrice(cd5.getAlbumPrice(), cd5.getDiscount()));
        cd5.setStockCount(10);
        cd5.setSoldCount(0);
        cd5.setSalable(true);
        cd5.setArtist(artist5);

        CDEntity cd6 = new CDEntity();
        cd6.setAlbumName("Gipsy Kings Live 2005");
        cd6.setAlbumGenre("Blues");
        cd6.setAlbumPrice(120);
        cd6.setDiscount(15);
        cd6.setDiscountedPrice(calculateDiscountedPrice(cd6.getAlbumPrice(), cd6.getDiscount()));
        cd6.setStockCount(10);
        cd6.setSoldCount(0);
        cd6.setSalable(true);
        cd6.setArtist(artist6);

        CDEntity cd7 = new CDEntity();
        cd7.setAlbumName("Octavarium");
        cd7.setAlbumGenre("Rock");
        cd7.setAlbumPrice(30);
        cd7.setDiscount(15);
        cd7.setDiscountedPrice(calculateDiscountedPrice(cd7.getAlbumPrice(), cd7.getDiscount()));
        cd7.setStockCount(10);
        cd7.setSoldCount(0);
        cd7.setSalable(true);
        cd7.setArtist(artist7);

        CDEntity cd8 = new CDEntity();
        cd8.setAlbumName("Dudu");
        cd8.setAlbumGenre("Türk pop");
        cd8.setAlbumPrice(30);
        cd8.setDiscount(10);
        cd8.setDiscountedPrice(calculateDiscountedPrice(cd8.getAlbumPrice(), cd8.getDiscount()));
        cd8.setStockCount(10);
        cd8.setSoldCount(0);
        cd8.setSalable(true);
        cd8.setArtist(artist8);

        CDEntity cd9 = new CDEntity();
        cd9.setAlbumName("And Justice for All");
        cd9.setAlbumGenre("Heavy metal");
        cd9.setAlbumPrice(1000);
        cd9.setDiscount(15);
        cd9.setDiscountedPrice(calculateDiscountedPrice(cd9.getAlbumPrice(), cd9.getDiscount()));
        cd9.setStockCount(10);
        cd9.setSoldCount(0);
        cd9.setSalable(true);
        cd9.setArtist(artist9);

        CDEntity cd10 = new CDEntity();
        cd10.setAlbumName("Classical Gas");
        cd10.setAlbumGenre("Blues");
        cd10.setAlbumPrice(200);
        cd10.setDiscount(10);
        cd10.setDiscountedPrice(calculateDiscountedPrice(cd10.getAlbumPrice(), cd10.getDiscount()));
        cd10.setStockCount(10);
        cd10.setSoldCount(0);
        cd10.setSalable(true);
        cd10.setArtist(artist10);

        DVDEntity dvd1 = new DVDEntity();
        dvd1.setAlbumName("Gitme");
        dvd1.setAlbumGenre("Arabesk");
        dvd1.setAlbumQuality("UHD");
        dvd1.setAlbumPrice(200);
        dvd1.setDiscount(15);
        dvd1.setDiscountedPrice(calculateDiscountedPrice(dvd1.getAlbumPrice(), dvd1.getDiscount()));
        dvd1.setStockCount(10);
        dvd1.setSoldCount(0);
        dvd1.setSalable(true);
        dvd1.setArtist(artist1);

        DVDEntity dvd2 = new DVDEntity();
        dvd2.setAlbumName("Eski Koprunun Altinda");
        dvd2.setAlbumGenre("Rock");
        dvd2.setAlbumQuality("UHD");
        dvd2.setAlbumPrice(100);
        dvd2.setDiscount(30);
        dvd2.setDiscountedPrice(calculateDiscountedPrice(dvd2.getAlbumPrice(), dvd2.getDiscount()));
        dvd2.setStockCount(10);
        dvd2.setSoldCount(0);
        dvd2.setSalable(true);
        dvd2.setArtist(artist2);

        DVDEntity dvd3 = new DVDEntity();
        dvd3.setAlbumName("In a Silent Way");
        dvd3.setAlbumGenre("Blues");
        dvd3.setAlbumQuality("HD");
        dvd3.setAlbumPrice(600);
        dvd3.setDiscount(55);
        dvd3.setDiscountedPrice(calculateDiscountedPrice(dvd3.getAlbumPrice(), dvd3.getDiscount()));
        dvd3.setStockCount(10);
        dvd3.setSoldCount(0);
        dvd3.setSalable(true);
        dvd3.setArtist(artist3);

        DVDEntity dvd4 = new DVDEntity();
        dvd4.setAlbumName("Tam Zamanı Şimdi");
        dvd4.setAlbumGenre("Rock");
        dvd4.setAlbumQuality("HD");
        dvd4.setAlbumPrice(80);
        dvd4.setDiscount(50);
        dvd4.setDiscountedPrice(calculateDiscountedPrice(dvd4.getAlbumPrice(), dvd4.getDiscount()));
        dvd4.setStockCount(10);
        dvd4.setSoldCount(0);
        dvd4.setSalable(true);
        dvd4.setArtist(artist4);

        DVDEntity dvd5 = new DVDEntity();
        dvd5.setAlbumName("Gül Kendine");
        dvd5.setAlbumGenre("Rock");
        dvd5.setAlbumQuality("UHD");
        dvd5.setAlbumPrice(200);
        dvd5.setDiscount(15);
        dvd5.setDiscountedPrice(calculateDiscountedPrice(dvd5.getAlbumPrice(), dvd5.getDiscount()));
        dvd5.setStockCount(10);
        dvd5.setSoldCount(0);
        dvd5.setSalable(true);
        dvd5.setArtist(artist5);

        DVDEntity dvd6 = new DVDEntity();
        dvd6.setAlbumName("Mosaique");
        dvd6.setAlbumGenre("Blues");
        dvd6.setAlbumQuality("UHD");
        dvd6.setAlbumPrice(130);
        dvd6.setDiscount(15);
        dvd6.setDiscountedPrice(calculateDiscountedPrice(dvd6.getAlbumPrice(), dvd6.getDiscount()));
        dvd6.setStockCount(10);
        dvd6.setSoldCount(0);
        dvd6.setSalable(true);
        dvd6.setArtist(artist6);

        DVDEntity dvd7 = new DVDEntity();
        dvd7.setAlbumName("Images and Words");
        dvd7.setAlbumGenre("Rock");
        dvd7.setAlbumQuality("sD");
        dvd7.setAlbumPrice(78);
        dvd7.setDiscount(22);
        dvd7.setDiscountedPrice(calculateDiscountedPrice(dvd7.getAlbumPrice(), dvd7.getDiscount()));
        dvd7.setStockCount(10);
        dvd7.setSoldCount(0);
        dvd7.setSalable(true);
        dvd7.setArtist(artist7);

        DVDEntity dvd8 = new DVDEntity();
        dvd8.setAlbumName("Ölürüm Sana");
        dvd8.setAlbumGenre("Türk Pop");
        dvd8.setAlbumQuality("UHD");
        dvd8.setAlbumPrice(9000);
        dvd8.setDiscount(10);
        dvd8.setDiscountedPrice(calculateDiscountedPrice(dvd8.getAlbumPrice(), dvd8.getDiscount()));
        dvd8.setStockCount(10);
        dvd8.setSoldCount(0);
        dvd8.setSalable(true);
        dvd8.setArtist(artist8);

        DVDEntity dvd9 = new DVDEntity();
        dvd9.setAlbumName("Master of Puppets");
        dvd9.setAlbumGenre("Heavy Metal");
        dvd9.setAlbumQuality("FHD");
        dvd9.setAlbumPrice(199);
        dvd9.setDiscount(17);
        dvd9.setDiscountedPrice(calculateDiscountedPrice(dvd9.getAlbumPrice(), dvd9.getDiscount()));
        dvd9.setStockCount(10);
        dvd9.setSoldCount(0);
        dvd9.setSalable(true);
        dvd9.setArtist(artist9);

        DVDEntity dvd10 = new DVDEntity();
        dvd10.setAlbumName("Endless Road");
        dvd10.setAlbumGenre("Blues");
        dvd10.setAlbumQuality("sD");
        dvd10.setAlbumPrice(70);
        dvd10.setDiscount(15);
        dvd10.setDiscountedPrice(calculateDiscountedPrice(dvd10.getAlbumPrice(), dvd10.getDiscount()));
        dvd10.setStockCount(10);
        dvd10.setSoldCount(0);
        dvd10.setSalable(true);
        dvd10.setArtist(artist10);


        VinylEntity vinyl1 = new VinylEntity();
        vinyl1.setAlbumName("Mutlu Ol Yeter");
        vinyl1.setAlbumGenre("Arabesk");
        vinyl1.setType("45'lik");
        vinyl1.setRpm("45");
        vinyl1.setAlbumPrice(300);
        vinyl1.setDiscount(15);
        vinyl1.setDiscountedPrice(calculateDiscountedPrice(vinyl1.getAlbumPrice(), vinyl1.getDiscount()));
        vinyl1.setStockCount(20);
        vinyl1.setSoldCount(0);
        vinyl1.setSalable(true);
        vinyl1.setArtist(artist1);

        VinylEntity vinyl2 = new VinylEntity();
        vinyl2.setAlbumName("Seni Kendime Sakladım");
        vinyl2.setAlbumGenre("Rock");
        vinyl2.setType("LP");
        vinyl2.setRpm("33");
        vinyl2.setAlbumPrice(200);
        vinyl2.setDiscount(22);
        vinyl2.setDiscountedPrice(calculateDiscountedPrice(vinyl2.getAlbumPrice(), vinyl2.getDiscount()));
        vinyl2.setStockCount(20);
        vinyl2.setSoldCount(0);
        vinyl2.setSalable(true);
        vinyl2.setArtist(artist2);

        VinylEntity vinyl3 = new VinylEntity();
        vinyl3.setAlbumName("Kind of Blue");
        vinyl3.setAlbumGenre("Blues");
        vinyl3.setType("Taş");
        vinyl3.setRpm("78");
        vinyl3.setAlbumPrice(99);
        vinyl3.setDiscount(10);
        vinyl3.setDiscountedPrice(calculateDiscountedPrice(vinyl3.getAlbumPrice(), vinyl3.getDiscount()));
        vinyl3.setStockCount(20);
        vinyl3.setSoldCount(0);
        vinyl3.setSalable(true);
        vinyl3.setArtist(artist3);

        VinylEntity vinyl4 = new VinylEntity();
        vinyl4.setAlbumName("Herşey Yolunda");
        vinyl4.setAlbumGenre("Rock");
        vinyl4.setType("LP");
        vinyl4.setRpm("33");
        vinyl4.setAlbumPrice(30);
        vinyl4.setDiscount(15);
        vinyl4.setDiscountedPrice(calculateDiscountedPrice(vinyl4.getAlbumPrice(), vinyl4.getDiscount()));
        vinyl4.setStockCount(20);
        vinyl4.setSoldCount(0);
        vinyl4.setSalable(true);
        vinyl4.setArtist(artist4);

        VinylEntity vinyl5 = new VinylEntity();
        vinyl5.setAlbumName("Büyük Düşler");
        vinyl5.setAlbumGenre("Rock");
        vinyl5.setType("45'lik");
        vinyl5.setRpm("45");
        vinyl5.setAlbumPrice(300);
        vinyl5.setDiscount(5);
        vinyl5.setDiscountedPrice(calculateDiscountedPrice(vinyl5.getAlbumPrice(), vinyl5.getDiscount()));
        vinyl5.setStockCount(20);
        vinyl5.setSoldCount(0);
        vinyl5.setSalable(true);
        vinyl5.setArtist(artist5);

        VinylEntity vinyl6 = new VinylEntity();
        vinyl6.setAlbumName("Este Mundo");
        vinyl6.setAlbumGenre("Blues");
        vinyl6.setType("LP");
        vinyl6.setRpm("33");
        vinyl6.setAlbumPrice(49.90);
        vinyl6.setDiscount(10);
        vinyl6.setDiscountedPrice(calculateDiscountedPrice(vinyl6.getAlbumPrice(), vinyl6.getDiscount()));
        vinyl6.setStockCount(20);
        vinyl6.setSoldCount(0);
        vinyl6.setSalable(true);
        vinyl6.setArtist(artist6);

        VinylEntity vinyl7 = new VinylEntity();
        vinyl7.setAlbumName("Awake");
        vinyl7.setAlbumGenre("Rock");
        vinyl7.setType("Taş");
        vinyl7.setRpm("78");
        vinyl7.setAlbumPrice(89.90);
        vinyl7.setDiscount(15);
        vinyl7.setDiscountedPrice(calculateDiscountedPrice(vinyl7.getAlbumPrice(), vinyl7.getDiscount()));
        vinyl7.setStockCount(20);
        vinyl7.setSoldCount(0);
        vinyl7.setSalable(true);
        vinyl7.setArtist(artist7);

        VinylEntity vinyl8 = new VinylEntity();
        vinyl8.setAlbumName("Karma");
        vinyl8.setAlbumGenre("Pop");
        vinyl8.setType("45'lik");
        vinyl8.setRpm("45");
        vinyl8.setAlbumPrice(199.90);
        vinyl8.setDiscount(15);
        vinyl8.setDiscountedPrice(calculateDiscountedPrice(vinyl8.getAlbumPrice(), vinyl8.getDiscount()));
        vinyl8.setStockCount(20);
        vinyl8.setSoldCount(0);
        vinyl8.setSalable(true);
        vinyl8.setArtist(artist8);

        VinylEntity vinyl9 = new VinylEntity();
        vinyl9.setAlbumName("Ride the Lightning");
        vinyl9.setAlbumGenre("Metal");
        vinyl9.setType("LP");
        vinyl9.setRpm("33");
        vinyl9.setAlbumPrice(99.90);
        vinyl9.setDiscount(0);
        vinyl9.setDiscountedPrice(calculateDiscountedPrice(vinyl9.getAlbumPrice(), vinyl9.getDiscount()));
        vinyl9.setStockCount(20);
        vinyl9.setSoldCount(0);
        vinyl9.setSalable(true);
        vinyl9.setArtist(artist9);

        VinylEntity vinyl10 = new VinylEntity();
        vinyl10.setAlbumName("The Journey");
        vinyl10.setAlbumGenre("Blues");
        vinyl10.setType("Taş");
        vinyl10.setRpm("78");
        vinyl10.setAlbumPrice(74.90);
        vinyl10.setDiscount(35);
        vinyl10.setDiscountedPrice(calculateDiscountedPrice(vinyl10.getAlbumPrice(), vinyl10.getDiscount()));
        vinyl10.setStockCount(20);
        vinyl10.setSoldCount(0);
        vinyl10.setSalable(true);
        vinyl10.setArtist(artist10);

        ArtistController artistController = new ArtistController();
        artistController.create(artist1);
        artistController.create(artist2);
        artistController.create(artist3);
        artistController.create(artist4);
        artistController.create(artist5);
        artistController.create(artist6);
        artistController.create(artist7);
        artistController.create(artist8);
        artistController.create(artist9);
        artistController.create(artist10);

        VinylController vinylController = new VinylController();
        vinylController.create(vinyl1);
        vinylController.create(vinyl2);
        vinylController.create(vinyl3);
        vinylController.create(vinyl4);
        vinylController.create(vinyl5);
        vinylController.create(vinyl6);
        vinylController.create(vinyl7);
        vinylController.create(vinyl8);
        vinylController.create(vinyl9);
        vinylController.create(vinyl10);

        DvdController dvdController = new DvdController();
        dvdController.create(dvd1);
        dvdController.create(dvd2);
        dvdController.create(dvd3);
        dvdController.create(dvd4);
        dvdController.create(dvd5);
        dvdController.create(dvd6);
        dvdController.create(dvd7);
        dvdController.create(dvd8);
        dvdController.create(dvd9);
        dvdController.create(dvd10);

        CdController cdController = new CdController();
        cdController.create(cd1);
        cdController.create(cd2);
        cdController.create(cd3);
        cdController.create(cd4);
        cdController.create(cd5);
        cdController.create(cd6);
        cdController.create(cd7);
        cdController.create(cd8);
        cdController.create(cd9);
        cdController.create(cd10);

    }

    private static Double calculateDiscountedPrice(double price, double discount) {
        double discountedPrice;
        if (discount > 0)
            discountedPrice = price - (price * discount / 100);
        else
            discountedPrice = price;
        return discountedPrice;
    }
}
