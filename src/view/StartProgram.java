package view;

import java.util.List;
import java.util.Scanner;

import controller.ListItemHelper;
import model.ListItem;
// Craig Longnecker
public class StartProgram { // Begin class StartProgram.

	static Scanner in = new Scanner(System.in);
	static ListItemHelper lih = new ListItemHelper();
//	private static ListItemHelper listHelper;

	private static void addAnItem() { // Begin addAnItem method.
		System.out.print("Enter a team city/state/college: ");
		String teamName = in.nextLine();
		System.out.print("Enter the team's nickname: ");
		String teamNickname = in.nextLine();
		ListItem toAdd = new ListItem(teamName, teamNickname);
		lih.insertItem(toAdd);
	} // Close addAnItem method.

	private static void editAnItem() { // Begin editAnItem method.
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Team City/State/College");
		System.out.println("2 : Search by Team Nickname");
		int searchBy = in.nextInt();
		in.nextLine();
		List<ListItem> foundItems;
		if (searchBy == 1) { // Begin if statement.
			System.out.print("Enter the team city/state/college: ");
			String name = in.nextLine();
			foundItems = lih.searchForTeamByTeam(name);
		} else { // Close if statement, begin else statement.
			System.out.print("Enter the team nickname: ");
			String nickname = in.nextLine();
			foundItems = lih.searchForTeamByNickname(nickname);
		} // Close else statement.
		if (!foundItems.isEmpty()) { // Begin if statement.
			System.out.println("Found Results.");
			for (ListItem l : foundItems) { // Begin for loop.
				System.out.println("ID: " + l.getId() + " - " + l.returnItemDetails());
			} // Close for loop.
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();
			ListItem toEdit = lih.searchForItemById(idToEdit);
			System.out.println("Retrieved " + toEdit.getTeamName() + " from " + toEdit.getTeamNickname());
			System.out.println("1 : Update Team City/State/College");
			System.out.println("2 : Update Nickname");
			int update = in.nextInt();
			in.nextLine();
			if (update == 1) { // Begin nested if statement.
				System.out.print("New Team City/State/College: ");
				String newTeam = in.nextLine();
				toEdit.setTeamName(newTeam);
			} else if (update == 2) { // Close nested if statement, begin nested else if statement.
				System.out.print("New Nickname: ");
				String newNickname = in.nextLine();
				toEdit.setTeamNickname(newNickname);
			} // Close nested else if statement.
			lih.updateItem(toEdit);
		} else { // Close if statement, begin else statement.
			System.out.println("---- No results found");
		} // Close else statement.
	} // Close editAnItem method.

	private static void deleteAnItem() { // Begin deleteAnItem method.
		System.out.print("Enter the team city/state/college to delete: ");
		String teamName = in.nextLine();
		System.out.print("Enter the team's nickname to delete: ");
		String teamNickname = in.nextLine();
		ListItem toDelete = new ListItem(teamName, teamNickname);
		lih.deleteItem(toDelete);
	} // Close deleteAnItem method.

	private static void viewTheList() { // Begin viewTheList method.
		List<ListItem> allItems = lih.showAllItems();
		for(ListItem l : allItems){ // Begin for loop.
			System.out.println(l.returnItemDetails());
		} // Close for loop.
	} // Close viewTheList method.
	
	public static void main(String[] args) { // Begin main.
		runMenu();
	} // Close main.

	public static void runMenu() { // Begin runMenu method.
		boolean goAgain = true;
		System.out.println("--- Welcome to our football team list! ---");
		while (goAgain) { // Begin while loop,
			System.out.println("*  Select an team:");
			System.out.println("*  1 -- Add a team");
			System.out.println("*  2 -- Edit a team");
			System.out.println("*  3 -- Delete a team");
			System.out.println("*  4 -- View the team list");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();
			if (selection == 1) { // Begin if statement.
				addAnItem();
			} else if (selection == 2) { // Close if statement, begin else if statement.
				editAnItem();
			} else if (selection == 3) { // Close and begin else if statements.
				deleteAnItem();
			} else if (selection == 4) { // Close and begin else if statements.
				viewTheList();
			} else { // Close else if statement, begin else statement.
				lih.cleanUp();
				System.out.println("FOOTBALL IS AWESOME!");
				goAgain = false;
			} // Close else statement.
		} // Close while loop.
	} // Close runMenu method.
} // Close class StartProgram.