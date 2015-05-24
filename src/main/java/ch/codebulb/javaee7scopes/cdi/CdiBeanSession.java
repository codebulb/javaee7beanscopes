package ch.codebulb.javaee7scopes.cdi;

import ch.codebulb.javaee7scopes.BaseBean;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class CdiBeanSession extends BaseBean implements Serializable {
    
}
