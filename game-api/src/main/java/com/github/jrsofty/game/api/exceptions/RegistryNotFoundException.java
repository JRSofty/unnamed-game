package com.github.jrsofty.game.api.exceptions;

public class RegistryNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -184124280545254895L;

    private static String buildMessage(final String registryName) {
        return String.format("Registry named: %s is not found in the list of registries", registryName);
    }

    public RegistryNotFoundException(final String registryName) {
        super(RegistryNotFoundException.buildMessage(registryName));
    }

}
