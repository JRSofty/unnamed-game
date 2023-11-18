package com.github.jrsofty.game.api.io;

import java.io.IOException;

public interface FileReader {
    String getPath();

    byte[] readFileData(String fullPath) throws IOException;
}
