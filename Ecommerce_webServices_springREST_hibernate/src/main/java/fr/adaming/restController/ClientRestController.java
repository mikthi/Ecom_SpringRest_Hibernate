package fr.adaming.restController;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.service.ICommanderService;

@RestController
@RequestMapping(value="client")
public class ClientRestController extends ConsulterRestController{

	
	@Autowired
	@Qualifier(value="CommanderServiceImpl")
	ICommanderService commanderService;


	public void passerCommande(Commande com) {
		commanderService.passerCommande(com);

	}

	public void enregistrerClient(Client cl) {
		commanderService.enregistrerClient(cl);
	}
	
	public void getCommande(int id_com)
	{
		
	}
	
	public void getClient(int id_client)
	{
		
	}
}
