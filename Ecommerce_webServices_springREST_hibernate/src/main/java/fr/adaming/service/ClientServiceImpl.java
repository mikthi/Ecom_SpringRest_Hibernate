package fr.adaming.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fr.adaming.dao.ICommanderDao;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.Produit;


@Service(value="CommanderServiceImpl")
@Transactional
public class ClientServiceImpl extends ConsulterServiceImpl implements ICommanderService {

	@Autowired
	ICommanderDao commanderDao;
	@Override
	public void passerCommande(Commande com) {
		commanderDao.passerCommande(com);
		
	}
	@Override
	public int enregistrerClient(Client cl) {
		return commanderDao.enregistrerClient(cl);	
	}

	public double calculerMontantPanier(HashMap<Integer,Integer> listeProduit)
	{
		double montant=0;
		Set listeCle=listeProduit.keySet();
		Iterator it = listeCle.iterator();
		while (it.hasNext()){
		   Integer cle = (Integer) it.next(); 
		   Integer valeur = (Integer) listeProduit.get(cle); 
		   montant = montant + valeur* consulterDao.consulterProduitParId(cle).getPrix();
		}
		return montant;
	}
	
	public List<Produit> recupererProduitDuPanier(HashMap<Integer,Integer> listeProduit)
	{
		List<Produit> produitsDuPanier=new ArrayList<Produit>();
		for(Entry<Integer, Integer> entry : listeProduit.entrySet()) {
			produitsDuPanier.add(consulterDao.consulterProduitParId(entry.getKey()));
		}
		return produitsDuPanier;
	}
	
	public Client clientIsExist(Client client)
	{
		return commanderDao.clientIsExist(client);
	}
}
