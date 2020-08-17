package com.gaurav.restwebservice.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class UserData {

	@Id
	@GeneratedValue
	private Integer id;
	@Size(min = 2, message = "Names should have atleast 2 characters")
	private String name;

//	@OneToMany(mappedBy = "user")

	public UserData() {

	}

	public UserData(Integer id, String name) {

		this.id = id;
		this.name = name;

	}

	@Override
	public String toString() {
		return "UserData [id=" + id + ", name=" + name + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
