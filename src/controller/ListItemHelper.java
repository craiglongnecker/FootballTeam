package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;
// Craig Longnecker
public class ListItemHelper { // Begin class ListItemHelper.
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FootballTeam");
	
	public void cleanUp() { // Begin cleanUp method.
		emfactory.close();
	} // Close cleanUp method.

	public void insertItem(ListItem li) { // Begin insertItem method.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	} // Close insertItem method.
	
	public void deleteItem(ListItem toDelete) { // Begin deleteItem method.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.teamName = :selectedName and li.teamNickname = :selectedNickname", ListItem.class);
		typedQuery.setParameter("selectedName", toDelete.getTeamName());
		typedQuery.setParameter("selectedNickname", toDelete.getTeamNickname());
		typedQuery.setMaxResults(1);
		ListItem result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();	
	} // Close deleteItem method.

	public List<ListItem> searchForTeamByNickname(String nickname) { // Begin searchForTeamByNickname method.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.teamNickname = :selectedNickname", ListItem.class);
		typedQuery.setParameter("selectedNickname", nickname);
		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	} // Close searchForTeamByNickname method.
	
	public List<ListItem> searchForTeamByTeam(String name) { // Begin searchForTeamByTeam method.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.teamName = :selectedName", ListItem.class);
		typedQuery.setParameter("selectedName", name);
		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	} // Close searchForTeamByTeam method.
	
	public ListItem searchForItemById(int id){ // Begin searchForItemById method.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListItem found = em.find(ListItem.class, id);
		em.close();
		return found;
	} // Close searchForItemById method.

	public List<ListItem> showAllItems(){ // Begin showAllItems method.
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li", ListItem.class);
		List<ListItem> allItems = typedQuery.getResultList();
		em.close();
		return allItems;
	} // Close showAllItems method.

	public void updateItem(ListItem toEdit) { // Begin updateItem method.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	} // Close updateItem method.
} // Close class ListItemHelper.
