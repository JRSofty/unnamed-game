package com.github.jrsofty.game.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.jrsofty.game.api.gds.GameDataEntry;
import com.github.jrsofty.game.api.gds.GameDataEntryObject;

class GameDataEntryTests {

    final GameDataEntry<String> stringEntry = new GameDataEntryObject<>();
    final GameDataEntry<Integer> integerEntry = new GameDataEntryObject<>();
    final GameDataEntry<Boolean> boolEntry = new GameDataEntryObject<>();
    final GameDataEntry<HashSet<String>> setEntry = new GameDataEntryObject<>();
    final GameDataEntry<HashSet<GameDataEntry<?>>> entries = new GameDataEntryObject<>();
    final GameDataEntry<GameDataEntry<?>> parentEntry = new GameDataEntryObject<>();

    @BeforeEach
    public void setup() {

        this.stringEntry.setEntryName("stringEntryTest");
        this.stringEntry.setEntryData("SomeStringData");
        this.integerEntry.setEntryName("integerEntryTest");
        this.integerEntry.setEntryData(100);
        this.boolEntry.setEntryName("boolEntryTest");
        this.boolEntry.setEntryData(Boolean.TRUE);
        final HashSet<String> hash = new HashSet<>();
        hash.add("Apple");
        hash.add("Pie");
        hash.add("Is");
        hash.add("Good");
        this.setEntry.setEntryData(hash);
        this.setEntry.setEntryName("collectionEntryTest");
        final HashSet<GameDataEntry<?>> entrySet = new HashSet<>();
        entrySet.add(this.stringEntry);
        entrySet.add(this.boolEntry);
        entrySet.add(this.integerEntry);
        entrySet.add(this.setEntry);
        this.entries.setEntryData(entrySet);
        this.entries.setEntryName("childrenEntries");
        this.parentEntry.setEntryName("examples");
        this.parentEntry.setEntryData(this.entries);

    }

    @Test
    public void testPrint() throws IOException {
        final String testFile = this.loadTestFile("not-pretty-output.txt");
        Assertions.assertSame(testFile, this.parentEntry.toString());
    }

    @Test
    void testPrettyString() throws IOException {
        this.dumpToFile(this.parentEntry.toString(true));
        Assertions.assertTrue(true);
    }

    private String loadTestFile(final String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(filename)))) {
            final StringBuilder builder = new StringBuilder();
            String str;
            while ((str = reader.readLine()) != null) {
                builder.append(str);
            }
            return builder.toString();
        }

    }

    private void dumpToFile(final String value) throws IOException {
        Files.writeString(Paths.get("gde.txt"), value);
    }

}
