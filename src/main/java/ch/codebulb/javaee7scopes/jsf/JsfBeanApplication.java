package ch.codebulb.javaee7scopes.jsf;

import ch.codebulb.javaee7scopes.BaseBean;
import javax.enterprise.inject.Alternative;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
// we must use JSR 299 annotation Alternative, otherwise it's considered a CDI bean.
@Alternative
public class JsfBeanApplication extends BaseBean {
    
}
