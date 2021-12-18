package com.bilgeadam.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "cd_albums")
public class CDEntity implements Serializable {
    private static final long serialVersionUID = 8644126461632857248L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private long id;

    @Column(name = "album_name")
    private String albumName;

    @Column(name = "album_genre")
    private String albumGenre;

    @Column(name = "album_price")
    private double albumPrice;

    @Column(name = "discount")
    private double discount;

    @Column(name = "discounted_price")
    private double discountedPrice;

    /*@Lob
	@Column(name = "image")
	private byte[] image;*/

    @Column(name = "stock_count")
    private int stockCount;

    @Column(name = "sold_count")
    private int soldCount;

    @Column(name = "is_salable")
    private boolean isSalable;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private ArtistEntity artist;

}
