package de.lraupach.fhirtest;

import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.server.IResourceProvider;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Patient;

public class TestProvider implements IResourceProvider {
    @Override
    public Class<? extends IBaseResource> getResourceType() {
        return Patient.class;
    }

    @Search
    public Patient getPatient() {
        Patient patient = new Patient();
        patient.addIdentifier();
        patient.getIdentifier().get(0).setUse(Identifier.IdentifierUse.OFFICIAL);
        patient.getIdentifier().get(0).setSystem("urn:hapitest:mrns");
        patient.getIdentifier().get(0).setValue("00001");
        return patient;
    }
}
