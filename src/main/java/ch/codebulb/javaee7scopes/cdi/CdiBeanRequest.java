package ch.codebulb.javaee7scopes.cdi;

import ch.codebulb.javaee7scopes.BaseBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CdiBeanRequest extends BaseBean {
    
}
