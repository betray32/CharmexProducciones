package com.charmex.charmexproducciones.managedbean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Camilo
 */
@ManagedBean(name = "navbean")
@SessionScoped
public class NavigationBean implements Serializable {

    /**
     * UID
     */
    private static final long serialVersionUID = 7526472295622776147L;

    /**
     * Variables para las redirecciones
     */
    private String REDIR_FACE = "https://www.facebook.com/charmexproducciones";

    private String REDIR_SOUNDCLOUD = "https://soundcloud.com/charmexproducciones";

    private String REDIR_INSTA = "https://www.instagram.com/charmexproducciones/";

    private String REDIR_YOUTUBE = "https://www.youtube.com/user/charmexproducciones";

    @PostConstruct
    public void init() {

    }

    /**
     * Permite setear un mensaje en session previo a redireccionar una pagina
     */
    public void setRedirMsj(String mensaje, FacesMessage.Severity severidad) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severidad, mensaje, null));
    }

    /**
     * GET Y SET *
     */
    public String getREDIR_FACE() {
        return REDIR_FACE;
    }

    public void setREDIR_FACE(String REDIR_FACE) {
        this.REDIR_FACE = REDIR_FACE;
    }

    public String getREDIR_SOUNDCLOUD() {
        return REDIR_SOUNDCLOUD;
    }

    public void setREDIR_SOUNDCLOUD(String REDIR_SOUNDCLOUD) {
        this.REDIR_SOUNDCLOUD = REDIR_SOUNDCLOUD;
    }

    public String getREDIR_INSTA() {
        return REDIR_INSTA;
    }

    public void setREDIR_INSTA(String REDIR_INSTA) {
        this.REDIR_INSTA = REDIR_INSTA;
    }

    public String getREDIR_YOUTUBE() {
        return REDIR_YOUTUBE;
    }

    public void setREDIR_YOUTUBE(String REDIR_YOUTUBE) {
        this.REDIR_YOUTUBE = REDIR_YOUTUBE;
    }

}
