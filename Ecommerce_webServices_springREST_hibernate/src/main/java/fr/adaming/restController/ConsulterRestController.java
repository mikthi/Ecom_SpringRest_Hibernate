package fr.adaming.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.IConsulterService;

@RestController
public class ConsulterRestController {

	@Autowired
	@Qualifier(value = "ConsulterServiceImpl")
	IConsulterService consulterService;

	// -----------------------------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------
	/**
	 * Méthodes du web-services
	 */

	/**
	 * Rechercher tous les produits
	 */
	@RequestMapping(value = "/getAllProduits", method = RequestMethod.GET, produces = "application/json")
	protected List<Produit> consulterTousLesProduits() {
		return consulterService.consulterTousLesProduits();
	}

	/**
	 * Rechercher toutes les catégories
	 */
	@RequestMapping(value = "/getAllCategories", method = RequestMethod.GET, produces = "application/json")
	protected List<Categorie> consulterToutesLesCategories() {
		return consulterService.consulterToutesLesCategories();
	}

	/**
	 * Rechercher tous les produits d'une catégorie
	 */
	@RequestMapping(value = "/getAllProduitsByCategorie/{id_categ}", method = RequestMethod.GET, produces = "application/json")
	protected List<Produit> consulterLesProduitsParCategorie(@PathVariable("id_categ") int id_categ) {
		return consulterService.consulterLesProduitsParCategorie(id_categ);
	}

	/**
	 * Rechercher un produit par son ID
	 */
	@RequestMapping(value = "/getProduitById/{id_produit}", method = RequestMethod.GET, produces = "application/json")
	protected Produit consulterProduitSelectionne(@PathVariable("id_produit") int id_produit) {
		return consulterService.consulterProduitSelectionne(id_produit);
	}

	/**
	 * Rechercher des produits par mot-clef
	 */
	@RequestMapping(value = "/GetProduitsBySearch/{motCle}", method = RequestMethod.GET, produces = "application/json")
	protected List<Produit> chercherProduitsParMotCle(@PathVariable("motCle") String motCle) {
		return consulterService.chercherProduitsParMotCle(motCle);
	}

	/**
	 * Rechercher une catégorie par son ID
	 */
	@RequestMapping(value = "/getCategorieById/{id_categorie}", method = RequestMethod.GET, produces = "application/json")
	protected Categorie consulterCategorieParId(@PathVariable("id_categorie") int id_categorie) {
		return consulterService.consulterCategorieParId(id_categorie);
	}

}
