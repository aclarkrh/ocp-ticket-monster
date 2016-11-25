package com.bp.ist.synergy.appstore.kubedsl;

import io.fabric8.kubernetes.generator.annotation.KubernetesModelProcessor;
import io.fabric8.openshift.api.model.TemplateBuilder;

@KubernetesModelProcessor
public class MainKubernetesModelProcessor {

    public void withTemplateBuilder(TemplateBuilder builder) {

        new BuildConfigKubernetesModelProcessor().on(builder);
        new ImageStreamKubernetesModelProcessor().on(builder);
        new DeploymentConfigKubernetesModelProcessor().on(builder);
        new ServiceKubernetesModelProcessor().on(builder);
        new RouteKubernetesModelProcessor().on(builder);
        new PersistentVolumeClaimKubernetesModelProcessor().on(builder);
    }
}
