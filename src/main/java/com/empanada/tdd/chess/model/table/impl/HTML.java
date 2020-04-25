package com.empanada.tdd.chess.model.table.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class HTML {

    public static void main(String [] args){
        String fileName= "/home/empanada/Personal/Projects/hackerrank/tags/input.html";
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
           tagExtractor(br);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void tagExtractor(BufferedReader br) throws IOException{
        String line;
        Map<String, Integer> tagsResult = new HashMap<>();
        while ((line = br.readLine()) != null) {
            tagsResult = contabilizarTags(line);

        }
        tagsResult.get(1);
    }

    private static Map<String, Integer> contabilizarTags(String line) {
        String tag = "";
        boolean hasGreaterThanStarted = false;
        Map<String, Integer> tagsResult = new HashMap<>();
        for (int i = 0; i <= line.length(); i++) {

            if (line.charAt(i) == '<') {
                hasGreaterThanStarted = true;
                continue;
            }

            if (hasGreaterThanStarted) {
                if (line.charAt(i)== '>') {
                    System.out.println(tag);
                    tag = "";
                    hasGreaterThanStarted = false;
                }
            }
            tag += line.charAt(i);
            if (line.charAt(i) == '/' ){
                tag = "";
            }
        }
        tagsResult.putIfAbsent(tag, 0);
        tagsResult.put(tag, tagsResult.get(tag) + 1);

        return tagsResult;
    }


}
