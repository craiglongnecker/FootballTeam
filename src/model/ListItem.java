//Final annotated ListItem POJO
package model;

//All these import statements came in by clicking the red X and using Import options from the javax.persistence package.
//If you are asked to create a class, interface, constant, etc., you made a spelling or capitalization error!!
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// Craig Longnecker
@Entity
@Table(name="items")
public class ListItem { // Begin class ListItem.
	// Create variables and persistence columns.
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="TEAMNAME")
	private String teamName;
	@Column(name="TEAMNICKNAME")
	private String teamNickname;
	
	public ListItem() { // Begin Default constructor.
		
	} // Close Default constructor.

	public ListItem(String t, String n) { // Begin Non-default constructor.
		this.teamName = t;
		this.teamNickname = n;
	} // Close Non-default constructor.

	public int getId() { // Begin getter for id.
		return id;
	} // Close getter for id.

	public void setId(int id) { // Begin setter for id.
		this.id = id;
	} // Close setter for id.
	
	public String getTeamName() { // Begin getter for teamName.
		return teamName;
	} // Close getter for teamName.

	public void setTeamName(String teamName) { // Begin setter for teamName.
		this.teamName = teamName;
	} // Close setter for teamName.

	public String getTeamNickname() { // Begin getter for teamNickname.
		return teamNickname;
	} // Close getter for teamNickname.

	public void setTeamNickname(String teamNickname) { // Begin setter for teamNickname.
		this.teamNickname = teamNickname;
	} // Close setter for teamNickname.

	public String returnItemDetails() { // Begin returnItemDetails method.
		return "The " + teamName + " " + teamNickname + ".";
	} // Close returnItemDetails method.
} // Close class ListItem.