package cn.edu.lcu.math;


import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Long id;
	private String name;
	private String gender;
	private Date birthday;
	
	public User(Long id) {
		this.id = id;
	}
	
	public User(Long id, String name) {
		this(id);
		this.name = name;
	}
	
	public User(Long id, String name, String gender) {
		this(id, name);
		this.gender = gender;
	}
}
