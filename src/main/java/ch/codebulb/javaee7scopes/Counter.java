package ch.codebulb.javaee7scopes;

import ch.codebulb.javaee7scopes.cdi.CdiBeanApplication;
import ch.codebulb.javaee7scopes.cdi.CdiBeanSession;
import ch.codebulb.javaee7scopes.cdi.CdiBeanView;
import ch.codebulb.javaee7scopes.ejb.EjbBeanSingleton;
import ch.codebulb.javaee7scopes.ejb.EjbBeanStateless;
import ch.codebulb.javaee7scopes.guice.GuiceBeanSingleton;
import ch.codebulb.javaee7scopes.jsf.JsfBeanApplication;
import ch.codebulb.javaee7scopes.jsf.JsfBeanSession;
import ch.codebulb.javaee7scopes.jsf.JsfBeanView;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Counter implements Serializable {    
    private Map<Class<? extends BaseBean>, Integer> active = new HashMap<>();
    private Map<Class<? extends BaseBean>, Integer> created = new HashMap<>();
    private Map<Class<? extends BaseBean>, Integer> destroyed = new HashMap<>();
    
    public synchronized void countUp(BaseBean caller) {
        update(active, caller, true);
        update(created, caller, true);
    }
    
    public synchronized void countDown(BaseBean caller) {
        update(active, caller, false);
        update(destroyed, caller, true);
    }
    
    private void update(Map<Class<? extends BaseBean>, Integer> counts, BaseBean caller, boolean increase) {
        Integer current = counts.get(caller.getClass());
        if (current == null) {
            current = 1;
        }
        else {
            current = increase ? current + 1 : current - 1;
            if (current < 0) {
                current = 0;
            }
        }
        counts.put(caller.getClass(), current);
    }
    
    public int active(BaseBean caller) {
        Integer current = active.get(caller.getClass());
        return current != null ? current : 0;
    }
    
    public int created(BaseBean caller) {
        Integer current = created.get(caller.getClass());
        return current != null ? current : 0;
    }
    
    public int destroyed(BaseBean caller) {
        Integer current = destroyed.get(caller.getClass());
        return current != null ? current : 0;
    }
    
    public synchronized void reset() {
        active.clear();
        created.clear();
        destroyed.clear();
        
        reinitialize(new JsfBeanView());
        reinitialize(new JsfBeanSession());
        reinitialize(new JsfBeanApplication());
        
        reinitialize(new CdiBeanView());
        reinitialize(new CdiBeanSession());
        reinitialize(new CdiBeanApplication());
        
        reinitialize(new EjbBeanSingleton());
        reinitialize(new EjbBeanStateless());
        
        reinitialize(new GuiceBeanSingleton());
    }
    
    private void reinitialize(BaseBean bean) {
        update(active, bean, true);
        update(created, bean, true);
    }
    
    public void invalidateSession() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
    public void stayHere() {}
    
    public String navigateTo(String index) {
        return "index" + index + ".xhtml?faces-redirect=true";
    }
}
