package com.bp.ist.synergy.appstore.kubedsl;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.openshift.api.model.TemplateBuilder;

public class PersistentVolumeClaimKubernetesModelProcessor {

    public void on(TemplateBuilder builder) {
    	
    	Map<String, Quantity> resources = new HashMap<String, Quantity>();
    	resources.put("storage", new Quantity(ConfigConstants.PERSISTENT_VOLUME_CLAIM_SIZE));
    	
    	ResourceRequirements resReq = new ResourceRequirements();
    	resReq.setRequests(resources);

        builder.addNewPersistentVolumeClaimObject()
                .withNewSpec()
                	.withAccessModes("ReadWriteMany")
                	.withResources(resReq)
                .endSpec()
                .withNewMetadata()
                    .withName(ConfigConstants.PERSISTENT_VOLUME_CLAIM_NAME)
                    .withLabels(ConfigConstants.getLabels())
                    .withAnnotations(ImmutableMap.<String, String>of(
                            "description",
                            "The persistent volume used to store app binaries."))
                .endMetadata()
                .endPersistentVolumeClaimObject()

                .build();
    }
}