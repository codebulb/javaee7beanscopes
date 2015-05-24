package ch.codebulb.javaee7scopes;

import ch.codebulb.javaee7scopes.jsf.JsfBeanRequestFlash;
import javax.enterprise.inject.Alternative;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.Flash;
import org.omnifaces.util.Faces;

@ManagedBean
@RequestScoped
// we must use JSR 299 annotation Alternative, otherwise it's considered a CDI bean.
@Alternative
public class JsfFlashLoader {
    @ManagedProperty("#{flash}")
    private Flash flash;
    
    public JsfBeanRequestFlash loadBean() {
        JsfBeanRequestFlash instance = (JsfBeanRequestFlash) flash.get("jsfBeanFlash");
        if (instance == null) {
            instance = Faces.evaluateExpressionGet("#{jsfBeanRequestFlash}");
            flash.put("jsfBeanFlash", instance);
        }
        return instance;
    }

    public Flash getFlash() {
        return flash;
    }

    public void setFlash(Flash flash) {
        this.flash = flash;
    }
}
