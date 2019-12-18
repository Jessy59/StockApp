package com.jllalt.mystockapp.data.manager;

import com.jllalt.mystockapp.data.ServiceGenerator;
import com.jllalt.mystockapp.data.services.IProductServices;

import javax.inject.Inject;

public class ProductManager {

    private IProductServices productServices;

    @Inject
    public ProductManager() {
        this.productServices = ServiceGenerator.createService(IProductServices.class);
    }

    public void log() {
        System.out.println("coucou");
    }

    /**
     * Ajoute un produit
     */
    public void addProduct(String codeEan) {
        System.out.println(String.format("Ajout du produit %s", codeEan));
        // TODO : faire un post vers l'api product
    }
}
