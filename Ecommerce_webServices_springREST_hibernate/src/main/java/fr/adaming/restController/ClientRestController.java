package fr.adaming.restController;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.service.ICommanderService;

@RestController
@RequestMapping(value="/client")
public class ClientRestController extends ConsulterRestController{

	
	@Autowired
	@Qualifier(value="CommanderServiceImpl")
	ICommanderService commanderService;

	@RequestMapping(value="/commande/{id_commande}", method=RequestMethod.GET, produces="application/json")
	public Commande consulterCommande(@PathVariable("id_commande")int id_commande) {
		
		return  consulterService.consulterCommande(id_commande);
	}
	



	

}
