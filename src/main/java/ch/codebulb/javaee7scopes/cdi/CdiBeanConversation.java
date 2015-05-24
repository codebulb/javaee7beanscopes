package ch.codebulb.javaee7scopes.cdi;

import ch.codebulb.javaee7scopes.BaseBean;
import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class CdiBeanConversation extends BaseBean implements Serializable {
    @Inject
    private Conversation conversation;

    public Conversation getConversation() {
        return conversation;
    }
}
