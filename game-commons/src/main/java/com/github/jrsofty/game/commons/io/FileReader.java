package com.github.jrsofty.game.commons.io;

import java.io.IOException;
import java.util.Set;

public interface FileReader {
    String getPath();

    byte[] readFileData(String fullPath) throws IOException;

    Set<String> listFilesInPath();
}
