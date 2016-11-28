package org.jboss.examples.ticketmonster.kubedsl;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import io.fabric8.kubernetes.api.model.IntOrStringBuilder;
import io.fabric8.openshift.api.model.TemplateBuilder;

public class DBServiceKubernetesModelProcessor {

    public void on(TemplateBuilder builder) {

        builder.addNewServiceObject()
                .withNewSpec()
                    .withPorts()
                        .addNewPort()
                        	.withName("mysql")
                        	.withProtocol("TCP")
                            .withPort(3306)
                            .withTargetPort(new IntOrStringBuilder().withIntVal(3306).build())
                            .withNodePort(0)
                        .endPort()
                    .withSelector(getSelector())
                .endSpec()
                .withNewMetadata()
                    .withName("external-mysql-service")
//                    .withLabels(ConfigConstants.getLabels())
//                    .withAnnotations(ImmutableMap.<String, String>of(
//                            "description",
//                            "The app server's http port."))
                .endMetadata()
                .endServiceObject()

                .build();

    }

    public static Map<String, String> getSelector() {
        return ImmutableMap.<String, String> builder()
                .build();
    }
}
