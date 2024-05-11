package com.app.booksapp.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BLike extends BEntity{
	@ManyToOne
	private BUser user;

	@ManyToOne
	private BBook book;
}

