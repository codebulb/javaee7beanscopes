package ch.codebulb.javaee7scopes.guice;

import ch.codebulb.javaee7scopes.BaseBean;
import java.io.Serializable;
import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class GuiceBeanSingleton extends BaseBean implements Serializable {
    
}
