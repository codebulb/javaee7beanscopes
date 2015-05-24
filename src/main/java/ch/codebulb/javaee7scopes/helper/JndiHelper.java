package ch.codebulb.javaee7scopes.helper;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;

/**
 * Utility class for EJBs. There's a {@link #lookup(Class)} method which allows you to lookup the 
 * current instance of a given EJB class from the JNDI context. This utility class assumes that 
 * EJBs are deployed in the WAR as you would do in Java EE 6 Web Profile. For EARs, you'd need to
 * alter the <code>EJB_CONTEXT</code> to add the EJB module name or to add another lookup() method.
 * 
 * based on: http://balusc.blogspot.ch/2011/09/communication-in-jsf-20.html#GettingAnEJBInFacesConverterAndFacesValidator,
 * https://github.com/codebulb/javaee7beantypes/blob/master/src/main/java/ch/codebulb/javaee7beans/helper/JndiHelper.java
 */
public final class JndiHelper<T> {

    // Constants ----------------------------------------------------------------------------------

    private static final BeanManager BEAN_MANAGER = CDI.current().getBeanManager();

    // Constructors -------------------------------------------------------------------------------

    private JndiHelper() {
        // Utility class, so hide default constructor.
    }

    // Helpers ------------------------------------------------------------------------------------    
    public static <T> T lookupWithBeanManager(Class beanClass) throws IllegalArgumentException {
        try {
            Bean<T> bean = (Bean<T>)BEAN_MANAGER.getBeans(beanClass).toArray()[0];
            CreationalContext<T> ctx = BEAN_MANAGER.createCreationalContext(bean);
            return (T) BEAN_MANAGER.getReference(bean, beanClass, ctx);
        }
        catch(ArrayIndexOutOfBoundsException ex) {
            throw new IllegalArgumentException(
                String.format("Cannot find bean class %s in BeanManager", beanClass), ex);
        }
    }
}