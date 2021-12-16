package com.bilgeadam.model;

import java.io.Serializable;

import lombok.*;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "dvd_albums")
public class DVDEntity implements Serializable {
	private static final long serialVersionUID = 1980629840027711453L;
	
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

	@Column(name = "album_quality")
	private String albumQuality;

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
	@JoinColumn(name = "artist_id")
	private ArtistEntity artist;

	
}
