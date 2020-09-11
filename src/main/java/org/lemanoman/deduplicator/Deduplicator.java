package org.lemanoman.deduplicator;

import java.util.HashSet;
import java.util.Set;

public class Deduplicator {

    public DedupOutput deduplicate(String text){
        String[] lines = text.split("\n");
        Set<String> uniqueLines = new HashSet<>(lines.length);
        for(String line:lines){
            uniqueLines.add(line.trim());
        }
        StringBuilder output = new StringBuilder("");
        for(String uniqueLine: uniqueLines){
            output.append(uniqueLine);
            output.append("\n");
        }
        return new DedupOutput(lines.length,uniqueLines.size(),output.toString());
    }
}
