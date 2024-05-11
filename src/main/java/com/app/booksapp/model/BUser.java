package com.app.booksapp.model;

import lombok.*;
import jakarta.persistence.*;

//@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BUser extends BEntity{
	private String email;
	private String password;
	private String nom;
	private String prenom;
	private String tel;
	private String role;

	//@OneToMany(fetch = FetchType.EAGER,mappedBy="user")
	//private List<BComment> comments;

	//@OneToMany(fetch = FetchType.EAGER,mappedBy="user")
	//private List<BLike> likes;
	
}

