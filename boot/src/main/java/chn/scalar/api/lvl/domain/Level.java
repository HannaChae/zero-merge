package chn.scalar.api.lvl.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Level {

	@Id
	@Column(name = "level", nullable=true)
	private int level;

}
