package com.app.booksapp.model;
/*import jakarta.persistency.Id;
import jakarta.persistency.GeneratedValue;
import jakarta.persistency.GenerationType;*/
import jakarta.persistence.*;


/***/

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class BEntity implements MyEntity<Long> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Override
	public Long getId(){return id;}

	@Override
	public void setId(Long id){this.id = id;}

	BEntity(){
		id = (long) 5 ;
	}
}

