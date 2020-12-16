package com.zenika.snapshotmatcherexample;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static com.zenika.snapshotmatcher.SnapshotMatcher.matchesSnapshot;
import static org.hamcrest.MatcherAssert.assertThat;

public class ComplexStringTest {
    @Test
    public void testComplexString () throws IOException {
        FileInputStream inputStream = new FileInputStream("src/test/resources/data/complexString.html");
        Scanner s = new Scanner(inputStream).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";
        assertThat(result, matchesSnapshot());
    }
}