/*
 *at.haberstroh.parser
 *parser-interpreter-pattern-master - Json
 *(c)02.05.2025, Schueler, Philip Pfaffenlehner
 */

package at.haberstroh.parser;



import at.haberstroh.parser.JsonParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Gui extends JFrame {

    private final JTextArea inputArea;
    private final JButton parseButton;
    private final JTextArea outputArea;

    public Gui() {
        setTitle("JSON Parser - Matura");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Input JSON area
        inputArea = new JTextArea("{\"name\":\"Anna\",\"age\":30}");
        inputArea.setLineWrap(true);
        add(new JScrollPane(inputArea), BorderLayout.NORTH);

        // Parse Button
        parseButton = new JButton("Parse JSON");
        add(parseButton, BorderLayout.CENTER);

        // Output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        // TODO: Hier musst du den Parser anbinden
        parseButton.addActionListener(this::handleParse);

        setVisible(true);
    }

    private void handleParse(ActionEvent e) {
        String input = inputArea.getText();
        outputArea.setText("");

        try {
            // 👉 Du sollst hier den JsonParser einbinden
            Object result = JsonParser.parse(input);
            outputArea.setText(result.toString());
        } catch (Exception ex) {
            outputArea.setText("❌ Fehler beim Parsen:\n" + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Gui::new);
    }
}

