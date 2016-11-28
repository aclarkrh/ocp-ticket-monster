package org.jboss.examples.ticketmonster.kubedsl;
import io.fabric8.openshift.api.model.TemplateBuilder;

public class DBEndpointKubernetesModelProcessor {

    public void on(TemplateBuilder builder) {

        builder.addNewEndpointsObject()
        	.withSubsets()
        		.addNewSubset()
        			.addNewAddress()
        				.withIp("aclark-OSX.local")
        			.endAddress()
        			.addNewPort()
        				.withPort(3306)
        				.withName("mysql")
        			.endPort()
        		.endSubset()
        	.withNewMetadata()
        		.withName("external-mysql-service")
        	.endMetadata()
        	.endEndpointsObject()
        	.build();
    }
}
