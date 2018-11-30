/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.charmex.charmexproducciones.managedbean;

import com.charmex.charmexproducciones.utils.EmailSender;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Camilo
 */
@ManagedBean(name = "contact")
@ViewScoped
public class ContactoMB implements Serializable {

    /**
     * Inyeccion
     */
    @ManagedProperty("#{navbean}")
    private NavigationBean navbean;

    private String nombre;
    private String email;
    private String mensaje;
    private String fono;

    @PostConstruct
    public void init() {
    }

    private void limpiarCamposFormulario() {
        nombre = "";
        email = "";
        mensaje = "";
        fono = "";
    }

    /**
     * Enviar Mensaje
     */
    public void enviarMensaje() {
        if (new EmailSender().enviarEmail(nombre, email, mensaje, fono)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Email enviado correctamente, nos contactaremos con usted a la brevedad", null));
            limpiarCamposFormulario();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "¡UPS! Ha ocurrido un error al enviar el email de contacto, porfavor intentalo nuevamente más tarde", null));
            limpiarCamposFormulario();
        }
    }

    /**
     * GET Y SET *
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setNavbean(NavigationBean navbean) {
        this.navbean = navbean;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }
}
