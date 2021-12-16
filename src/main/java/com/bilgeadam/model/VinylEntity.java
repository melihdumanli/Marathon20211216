package com.bilgeadam.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "vinyl_albums")
public class VinylEntity implements Serializable {
    private static final long serialVersionUID = -4618201324820868008L;

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

    @Column(name = "type")
    private String type;

    @Column(name = "rpm")
    private String rpm;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private ArtistEntity artist;

    @OneToMany(mappedBy = "vinylAlbums")
    private Collection<OrderEntity> orderEntity;

    public Collection<OrderEntity> getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(Collection<OrderEntity> orderEntity) {
        this.orderEntity = orderEntity;
    }
}

