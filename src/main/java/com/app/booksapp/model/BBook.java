package com.app.booksapp.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BBook extends BEntity{
	private String titre;
	private String annee;
	private String auteur;
	private String editeur;
	private String description;
	
	@Column(length = 10000)
	private String lienFichier;
	
	@Column(length = 10000)
	private String lienImage;

	/*@OneToMany(fetch = FetchType.EAGER)
	private List<BComment> comments;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<BLike> likes;
	*/

}

