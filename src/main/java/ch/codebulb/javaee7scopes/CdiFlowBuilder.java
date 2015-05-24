package ch.codebulb.javaee7scopes;

import ch.codebulb.javaee7scopes.cdi.CdiBeanFlow;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import javax.inject.Named;

@Named
@ApplicationScoped
public class CdiFlowBuilder {
    @Produces
    @FlowDefinition
    public Flow buildFlow(@FlowBuilderParameter FlowBuilder builder) {
        builder.id("", "myFlow");
        builder.viewNode("startFlow", "/pages/myFlow/index2.xhtml").markAsStartNode();
        builder.returnNode("endFlow").fromOutcome("/pages/myFlow/index.xhtml");
        return builder.getFlow();
    }
    
    public CdiBeanFlow createDummyCdiBeanFlow() {
        return new CdiBeanFlow();
    }
}
