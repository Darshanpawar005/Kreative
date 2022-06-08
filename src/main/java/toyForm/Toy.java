package toyForm;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Toy {

	@Id
	String id;
	String name;
	int price;
}
