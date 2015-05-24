package ch.codebulb.javaee7scopes.helper;

import ch.codebulb.javaee7scopes.ejb.EjbBeanStateful;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class JndiHelperBean {
    public Object getBeanWithBeanManager(String ejbClassName) {
        try {
            switch (ejbClassName) {
                case "ejbBeanStateful":
                    return JndiHelper.lookupWithBeanManager(EjbBeanStateful.class);
            }
        } catch (IllegalArgumentException ex) {
            return null;
        }
        
        throw new IllegalArgumentException(ejbClassName + " is not a valid bean class name.");
    }
}
