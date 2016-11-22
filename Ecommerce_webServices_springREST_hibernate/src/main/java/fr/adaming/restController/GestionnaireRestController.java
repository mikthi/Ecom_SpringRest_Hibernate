package fr.adaming.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.IEditerService;

@RestController
@RequestMapping(value = "/gestionnaire")
public class GestionnaireRestController extends ConsulterRestController {

	@Autowired
	@Qualifier(value = "EditerServiceImpl")
	IEditerService gestionnaireService;

	// -----------------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------
	/**
	 * Méthodes du web-services
	 */

	/**
	 * Ajouter une catégorie
	 */
	@RequestMapping(value = "/addCategorie", method = RequestMethod.POST, consumes = "application/json")
	private void ajouterCategorie(@RequestBody Categorie c) {
		gestionnaireService.ajouterCategorie(c);
	}

	/**
	 * Modifier une catégorie
	 */
	@RequestMapping(value = "/updateCategorie", method = RequestMethod.PUT, consumes = "application/json")
	private void modifierCategorie(@RequestBody Categorie c) {
		gestionnaireService.modifierCategorie(c);
	}

	/**
	 * Supprimer une catégorie
	 */
	@RequestMapping(value = "/removeCategorie/{id}", method = RequestMethod.DELETE)
	public void supprimerCategorie(@PathVariable("id") int id_categorie) {
		gestionnaireService.supprimerCategorie(id_categorie);
	}

	/**
	 * Ajouter un produit
	 */
	@RequestMapping(value = "/addProduit", method = RequestMethod.POST, consumes = "application/json")
	private void ajouterProduit(@RequestBody Produit p) {
		gestionnaireService.ajouterProduit(p);
	}

	/**
	 * Modifier un produit
	 */
	@RequestMapping(value = "/updateProduit", method = RequestMethod.PUT, consumes = "application/json")
	private void modifierProduit(@RequestBody Produit p) {
		gestionnaireService.modifierProduit(p);
	}

	/**
	 * Supprimer un produit
	 */
	@RequestMapping(value = "/removeProduit/{id}", method = RequestMethod.DELETE)
	public void supprimerProduit(@PathVariable("id") int id_produit) {
		gestionnaireService.supprimerProduit(id_produit);
	}

}
