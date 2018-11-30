/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.charmex.charmexproducciones.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Camilo
 */
@ManagedBean(name = "indexmbean")
@ViewScoped
public class IndexManagedBean implements Serializable {

    private List<String> urls_carousel;
    
    private List<String> urls_carousel_galery;

    private String introduccion;

    @PostConstruct
    public void init() {
        initObjects();
    }

    private void initObjects() {
        urls_carousel = new ArrayList<>();
        for ( int x = 1; x < 4; x++ ) {
            urls_carousel.add("banner"+x+".png");
        }
        
        urls_carousel_galery = new ArrayList<>();
        for ( int x = 15; x > 0; x-- ) {
            urls_carousel_galery.add("galeria_index"+x+".jpg");
        }
        
        introduccion = "En Charmex Producciones podrás lograr que todas tus ideas se concreten y conviertan en música, no importa si eres un músico aficionado que emprende camino o un artista/banda con amplia trayectoria; nosotros realizamos cada trabajo de forma profesional con el principal objetivo de lograr que cada proyecto musical sea de gran calidad.";
    }

    public List<String> getUrls_carousel() {
        return urls_carousel;
    }

    public String getIntroduccion() {
        return introduccion;
    }

    public List<String> getUrls_carousel_galery() {
        return urls_carousel_galery;
    }

}
