package GUI;

import Compressor_Decompressor.Compressor;
import Compressor_Decompressor.Decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {

    JButton compressButton;
    JButton decompressButton;

    AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        compressButton = new JButton("Select file to compress");
        compressButton.setBounds(400, 250, 200, 30);
        compressButton.addActionListener(this);


        decompressButton = new JButton("Select file to decompress");
        decompressButton.setBounds(400, 300, 200, 30);
        decompressButton.addActionListener(this);

        this.add(compressButton);
        this.add(decompressButton);

        this.setTitle("Compressor & Decompressor");
        this.setFocusable(true);
        this.setSize(1000, 600);
        this.getContentPane().setBackground(Color.black);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    Compressor.method(file);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }

        if (e.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    Decompressor.method(file);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }

            }
        }
    }
}


