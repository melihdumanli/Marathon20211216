package com.bilgeadam.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "artists")
public class ArtistEntity implements Serializable {
    private static final long serialVersionUID = -3184651842629416580L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name ="surname")
    private String surname;

    @Column(name ="description")
    private String description;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CDEntity> cdList = new HashSet<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<DVDEntity> dvdList = new HashSet<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<VinylEntity> vinylList = new HashSet<>();

    public void addDvd(DVDEntity dvd){
        this.dvdList.add(dvd);
    }

    public void addCd(CDEntity cd){
        this.cdList.add(cd);
    }

    public void addVinyl(VinylEntity vinyl){
        this.vinylList.add(vinyl);
    }


}
