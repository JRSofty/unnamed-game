package com.github.jrsofty.game.api.io;

import java.io.IOException;
import java.util.Set;

public interface FileReader {
    String getPath();

    byte[] readFileData(String fullPath) throws IOException;

    Set<String> listFilesInPath();
}
