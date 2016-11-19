package fr.adaming.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.service.ICommanderService;

@RestController
@RequestMapping(value="client")
public class ClientRestController extends ConsulterRestController{

	
	@Autowired
	@Qualifier(value="CommanderServiceImpl")
	ICommanderService clientService;


	public void passerCommande(Commande com) {
		clientService.passerCommande(com);

	}

	/**
	 * Enregistrer un client
	 */
	@RequestMapping(value = "/saveClient", method = RequestMethod.POST, consumes = "application/json")
	public void enregistrerClient(@RequestBody Client cl) {
		clientService.enregistrerClient(cl);
	}
	
	public void getCommande(int id_com)
	{
		
	}
	
	public void getClient(int id_client)
	{
		
	}
}
