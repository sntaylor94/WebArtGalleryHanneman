package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.GalleryPiece;
import model.Position;

public class GalleryPieceHelper {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebArtGalleryHanneman");

	public List<GalleryPiece> showAllArtwork() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<GalleryPiece> allResults = em.createQuery("select gp from GalleryPiece gp", GalleryPiece.class);
		List<GalleryPiece> allArt = allResults.getResultList();
		em.close();
		return allArt;
	}

	public void insertArt(GalleryPiece gp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(gp);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteItem(GalleryPiece gp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<GalleryPiece> deleteItem = em.createQuery("select gp from GalleryPiece gp where gp.title = :selectedTitle and gp.artistName = :selectedArtistName", GalleryPiece.class);
		deleteItem.setParameter("selectedTitle", gp.getTitle());
		deleteItem.setParameter("selectedArtistName", gp.getArtistName());
		deleteItem.setMaxResults(1);
		GalleryPiece toDelete = deleteItem.getSingleResult();
		em.remove(toDelete);
		em.getTransaction().commit();
		em.close();
	}
	
	public GalleryPiece searchForItemById(int galleryId) {
		EntityManager em = emfactory.createEntityManager();
		GalleryPiece foundPiece = em.find(GalleryPiece.class, id);
		em.close();
		return foundPiece;
	}
	
	public void updateItem(GalleryPiece gp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<GalleryPiece> updatePiece = em.createQuery("UPDATE GalleryPiece g SET g.title = :selectedTitle, g.artistName = :selectedArtist, g.media = :selectedMedia, g.year = :selectedYear, g.value = :selectedValue " + "WHERE g.id = :selectedId", GalleryPiece.class);
		updatePiece.setParameter("selectedTitle", gp.getTitle());
		updatePiece.setParameter("selectedArtist", gp.getArtistName());
		updatePiece.setParameter("selectedMedia", gp.getMedia());
		updatePiece.setParameter("selectedYear", gp.getYear());
		updatePiece.setParameter("selectedValue", gp.getValue());
		int updateCount=updatePiece.executeUpdate();
		if(updateCount>0) {
			System.out.println("Art Piece Updated");
		}
		em.getTransaction().commit();
		em.close();
	}

}
