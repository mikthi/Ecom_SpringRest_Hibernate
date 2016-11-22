package fr.adaming.service;

import java.util.HashMap;
import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.Produit;

public interface ICommanderService extends IConsulterService{


	public void passerCommande(Commande com);
	public int enregistrerClient(Client cl);
	public double calculerMontantPanier(HashMap<Integer,Integer> listeProduit);
	public List<Produit> recupererProduitDuPanier(HashMap<Integer,Integer> listeProduit);
	public Client clientIsExist(Client client);


}
