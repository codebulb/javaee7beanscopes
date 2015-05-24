package ch.codebulb.javaee7scopes;
 // we must use JSR 299 annotation Alternative, otherwise it's considered a CDI bean.
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

@Alternative
public abstract class BaseBean {
    @Inject
    private Counter counter;
    
    @PostConstruct
    public synchronized void init() {
        counter.countUp(this);
    }
    
    @PreDestroy
    public synchronized void destroy() {
        counter.countDown(this);
    }

    public int getActive() {
        return counter.active(this);
    }
    
    public int getCreated() {
        return counter.created(this);
    }
    
    public int getDestroyed() {
        return counter.destroyed(this);
    }
}
