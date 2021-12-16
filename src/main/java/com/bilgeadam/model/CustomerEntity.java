package com.bilgeadam.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "customers")
public class CustomerEntity implements Serializable {
	private static final long serialVersionUID = -6078998591482739532L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	private long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "address")
	private String address;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "is_active")
	private boolean isActive;

	/*@Lob
	@Column(name = "image")
	private byte[] image;*/

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<OrderEntity> orders = new HashSet<>();

	public void addOrder(OrderEntity order) {
		this.orders.add(order);
	}

}
