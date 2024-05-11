package com.app.booksapp.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BComment extends BEntity{
	private String texte;
	private String date;

	@ManyToOne
	private BUser user;

	@ManyToOne
	private BBook book;
}

