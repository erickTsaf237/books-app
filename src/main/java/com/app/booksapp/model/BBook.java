package com.app.booksapp.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BBook extends BEntity{
	private String titre;
	private String annee;
	private String auteur;
	private String editeur;
	private String description;
	private String lienFichier;

	/*@OneToMany(fetch = FetchType.EAGER)
	private List<BComment> comments;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<BLike> likes;
	*/

}

