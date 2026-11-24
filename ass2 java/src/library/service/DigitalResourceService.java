package library.service;

import library.model.DigitalResource;

public class DigitalResourceService implements Printable {
    private final DigitalResource resource;

    public DigitalResourceService(DigitalResource resource) {
        this.resource = resource;
    }

    @Override
    public void printDetails() {
        System.out.println("Digital resource: " + resource.details());
    }
}
