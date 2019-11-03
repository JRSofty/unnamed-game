package com.github.jrsofty.game.lib.wrapper.textures;

import com.jrsofty.github.game.api.Texture;

public interface TextureFactory {
    Texture createTexture(String resourceName);
}
