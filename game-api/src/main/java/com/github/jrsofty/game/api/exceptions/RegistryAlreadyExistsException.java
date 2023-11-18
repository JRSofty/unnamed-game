package com.github.jrsofty.game.api.exceptions;

public class RegistryAlreadyExistsException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 2172903868754708178L;

    private static String buildMessage(final String registryName) {
        return String.format("The registry named; %s already exists in the list of registries", registryName);
    }

    public RegistryAlreadyExistsException(final String registryName) {
        super(RegistryAlreadyExistsException.buildMessage(registryName));
    }
}
