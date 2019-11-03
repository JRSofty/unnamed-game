package com.github.jrsofty.game.lib.wrapper.textures;

public class TextureCreationException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 2167205922578246479L;
    private static final String DEFAULT_MESSAGE = "Failed to create texture for resource %s";

    public TextureCreationException(final String filename) {
        super(String.format(TextureCreationException.DEFAULT_MESSAGE, filename));
    }

    public TextureCreationException(final String filename, final Throwable t) {
        super(String.format(TextureCreationException.DEFAULT_MESSAGE, filename), t);
    }

}
