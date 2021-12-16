package com.bilgeadam.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "orders")
public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 6162545052203157820L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "invoice_amount")
    private double invoiceAmount;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "cd_id",referencedColumnName = "id")
    private CDEntity cdAlbum;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "dvd_id",referencedColumnName = "id")
    private DVDEntity dvdAlbum;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "vinyl_id",referencedColumnName = "id")
    private VinylEntity vinylAlbum;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private CustomerEntity customer;

}
