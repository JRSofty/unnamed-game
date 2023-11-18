package com.github.jrsofty.game.api.io;

import java.io.IOException;

public interface FileWriter {

    String getPath();

    void writeToFile(String fullFilePath, byte[] data) throws IOException;

}