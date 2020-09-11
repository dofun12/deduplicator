package org.lemanoman.deduplicator;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GUI {
    private JPanel panel1;
    private JTextArea textArea1;
    private JButton dedupButton;
    private JLabel infoLabel;
    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    public GUI() {
        JFrame frame = new JFrame("Deduplicator");
        frame.setSize(600, 300);
        frame.getContentPane().add(panel1);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        infoLabel.setText("Pronto!");

        dedupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDedupClick();
            }
        });
    }

    private void onDedupClick() {
        executor.submit(new DeduplicatorTask(textArea1.getText(), new OnDeduplication() {
            @Override
            public void onInit(String receivedText) {
                infoLabel.setText("Iniciando ...");
            }

            @Override
            public void onFinish(DedupOutput dedupOutput) {
                textArea1.setText(dedupOutput.getOutputText());
                infoLabel.setText("Removed: " + (dedupOutput.getInitialLines() - dedupOutput.getFinalLines()) + " lines");
            }

            @Override
            public void onError(Exception ex) {
                infoLabel.setText("Error :" + ex.getMessage());
            }
        }));
    }

    public void initWindow() {

    }

    public static void main(String... args) {
        new GUI();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(10, 10, 10, 10), -1, -1));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FormLayout("fill:d:noGrow,left:4dlu:noGrow,fill:d:grow", "center:d:noGrow,top:4dlu:noGrow,center:d:grow,top:4dlu:noGrow,center:max(d;4px):noGrow"));
        panel1.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Courier New", Font.PLAIN, 18, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Text:");
        CellConstraints cc = new CellConstraints();
        panel2.add(label1, cc.xy(1, 1));
        dedupButton = new JButton();
        dedupButton.setText("Dedup!!");
        panel2.add(dedupButton, cc.xy(3, 5, CellConstraints.RIGHT, CellConstraints.DEFAULT));
        final JScrollPane scrollPane1 = new JScrollPane();
        panel2.add(scrollPane1, cc.xyw(1, 3, 3, CellConstraints.FILL, CellConstraints.FILL));
        textArea1 = new JTextArea();
        textArea1.setText("");
        scrollPane1.setViewportView(textArea1);
        infoLabel = new JLabel();
        infoLabel.setText("Label");
        panel2.add(infoLabel, cc.xy(1, 5));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}
