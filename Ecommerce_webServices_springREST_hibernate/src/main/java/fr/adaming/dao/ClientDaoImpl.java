package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
@Repository


public class ClientDaoImpl implements ICommanderDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public Client clientIsExist(Client client)
	{
		Session s =sf.getCurrentSession();
		String req="From Client c where c.nom=:nom and c.prenom=:prenom";
		Query query = s.createQuery(req);
		
		query.setParameter("nom", client.getNom());
		query.setParameter("prenom", client.getPrenom());
		return  (Client) query.uniqueResult();
	
	}

	@Override
	public void passerCommande(Commande com) {
		Session s = sf.getCurrentSession();
		s.save(com);

	}
	@Override
	public int enregistrerClient(Client cl) {
		Session s = sf.getCurrentSession();
		s.save(cl);
		return cl.getId_client();
	}
	
	/** getters et setters */
	
	/**
	 * @param sf the sf to set
	 */
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}






}
