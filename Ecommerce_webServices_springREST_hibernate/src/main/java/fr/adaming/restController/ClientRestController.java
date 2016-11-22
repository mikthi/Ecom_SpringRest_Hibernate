package fr.adaming.restController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.Produit;
import fr.adaming.service.ICommanderService;

@RestController
@RequestMapping(value="/client")
public class ClientRestController extends ConsulterRestController{

	
	@Autowired
	@Qualifier(value="CommanderServiceImpl")
	ICommanderService commanderService;

	@RequestMapping(value="/commande/{id_commande}", method=RequestMethod.GET, produces="application/json")
	public Commande consulterCommande(@PathVariable("id_commande")int id_commande) {
		return  commanderService.consulterCommande(id_commande);
	}
	@RequestMapping(value="/getMontantPanier", method=RequestMethod.POST, produces="application/json" ,consumes="application/json")
	public double calculerMontantPanier(@RequestBody HashMap<Integer,Integer> listeProduit)
	{
		return commanderService.calculerMontantPanier(listeProduit);
	}
	@RequestMapping(value="/getProduitPanier", method=RequestMethod.POST, produces="application/json" ,consumes="application/json")
	public List<Produit> recupererProduitDuPanier(@RequestBody HashMap<Integer,Integer> listeProduit)
	{
		return commanderService.recupererProduitDuPanier(listeProduit);
	}
	
	@RequestMapping(value="/getClient", method=RequestMethod.POST, produces="application/json" ,consumes="application/json")
	public Client isExist(@RequestBody Client client)
	{
		Client cl=commanderService.clientIsExist(client);
		System.out.println(cl);
		return cl;
	}
	@RequestMapping(value="/enregistrerCommande", method=RequestMethod.POST, produces="application/json" ,consumes="application/json")
	public void enregistrerCommande(@RequestBody Commande commande)
	{
		System.out.println("le client est " + commande.getClient());
		System.out.println("retour is Exist" + commanderService.clientIsExist(commande.getClient()));
		
		if(commanderService.clientIsExist(commande.getClient())!=null)
		{
			commanderService.passerCommande(commande);
		}
		else
		{
			commanderService.enregistrerClient(commande.getClient());
			commanderService.passerCommande(commande);
		}
	}
	
	@RequestMapping(value="/enregistrerClient", method=RequestMethod.POST, produces="application/json" ,consumes="application/json")
	public int enregistrerClient(@RequestBody Client cl)
	{

		return commanderService.enregistrerClient(cl);
	}
	
}
