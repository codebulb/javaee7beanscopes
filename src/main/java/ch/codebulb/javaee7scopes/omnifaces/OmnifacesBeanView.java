package ch.codebulb.javaee7scopes.omnifaces;

import ch.codebulb.javaee7scopes.BaseBean;
import java.io.Serializable;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

@Named
@ViewScoped
public class OmnifacesBeanView extends BaseBean implements Serializable {
    
}
