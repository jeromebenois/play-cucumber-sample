package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Person extends Model {

	public String firstName;
	public String lastName;

	public static String getString(int i) {
		if (i >= 0) {
			return "foo";
		} else {
			return "bar";
		}
	}

}
