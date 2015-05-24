package ch.codebulb.javaee7scopes.cdi;

import ch.codebulb.javaee7scopes.BaseBean;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class CdiBeanApplication extends BaseBean implements Serializable {
    
}
