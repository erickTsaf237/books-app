package com.app.booksapp.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BUser extends BEntity{
	private String email;
	private String password;
	private String nom;
	private String prenom;
	private String tel;
	private boolean isAdmin;

	//@OneToMany(fetch = FetchType.EAGER,mappedBy="user")
	//private List<BComment> comments;

	//@OneToMany(fetch = FetchType.EAGER,mappedBy="user")
	//private List<BLike> likes;
	
}

