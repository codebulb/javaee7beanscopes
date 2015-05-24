package ch.codebulb.javaee7scopes.cdi;

import ch.codebulb.javaee7scopes.BaseBean;
import java.io.Serializable;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;

@Named
@FlowScoped("myFlow")
public class CdiBeanFlow extends BaseBean implements Serializable {
    
}
