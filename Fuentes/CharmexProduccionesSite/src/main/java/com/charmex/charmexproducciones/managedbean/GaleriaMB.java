package com.charmex.charmexproducciones.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Milo
 */
@ManagedBean(name = "gallery")
@ViewScoped
public class GaleriaMB implements Serializable {

    /**
	 * UID
	 */
	private static final long serialVersionUID = -827502970495426257L;
	private List<String> imagenes;

    @PostConstruct
    public void init() {

        imagenes = new ArrayList<>();
        for (int x = 1; x <= 62; x++) {
            imagenes.add("galeria" + x + ".jpg");
        }

        System.out.println("Imagenes correctamente cargadas");

    }

    public List<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<String> imagenes) {
        this.imagenes = imagenes;
    }

}
