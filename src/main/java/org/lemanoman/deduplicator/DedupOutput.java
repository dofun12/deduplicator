package org.lemanoman.deduplicator;

public class DedupOutput {
    private int initialLines;
    private int finalLines;
    private String outputText;

    public DedupOutput(int initialLines, int finalLines, String outputText) {
        this.initialLines = initialLines;
        this.finalLines = finalLines;
        this.outputText = outputText;
    }

    public int getInitialLines() {
        return initialLines;
    }

    public void setInitialLines(int initialLines) {
        this.initialLines = initialLines;
    }

    public int getFinalLines() {
        return finalLines;
    }

    public void setFinalLines(int finalLines) {
        this.finalLines = finalLines;
    }

    public String getOutputText() {
        return outputText;
    }

    public void setOutputText(String outputText) {
        this.outputText = outputText;
    }
}
