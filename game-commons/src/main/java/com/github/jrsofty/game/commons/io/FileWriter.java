package com.github.jrsofty.game.commons.io;

import java.io.IOException;

public interface FileWriter {

    String getPath();

    void writeToFile(String fullFilePath, byte[] data) throws IOException;

}
