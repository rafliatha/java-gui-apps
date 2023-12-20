// Nama : Muhammad Rafli Falam Athallah 
// NIM : 5312422019

package Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class KalkulatorGUI extends JFrame implements ActionListener {

  // Komponen-komponen GUI
  private JTextField textField;
  private JButton[] numberButtons;
  private JButton addButton, subButton, mulButton, divButton, eqButton, clrButton, dotButton;

  // Variabel-variabel untuk operasi kalkulator
  private double angkaPertama, angkaKedua, hasil;
  private char operator;

  // Konstruktor
  public KalkulatorGUI() {
    // Set layout
    setLayout(new BorderLayout());

    // TextField
    textField = new JTextField();
    Font font = new Font("Arial", Font.PLAIN, 17);
    add(textField, BorderLayout.NORTH);
    textField.setFont(font);
    add(textField, BorderLayout.NORTH);

    // Tombol angka
    numberButtons = new JButton[10];
    for (int i = 0; i < 10; i++) {
      numberButtons[i] = new JButton(String.valueOf(i));
      numberButtons[i].addActionListener(this);
    }

    // Tombol operator
    addButton = new JButton("+");
    subButton = new JButton("-");
    mulButton = new JButton("x");
    divButton = new JButton("/");
    eqButton = new JButton("=");
    clrButton = new JButton("C");
    dotButton = new JButton(".");

    // Tambahkan listener
    addButton.addActionListener(this);
    subButton.addActionListener(this);
    mulButton.addActionListener(this);
    divButton.addActionListener(this);
    eqButton.addActionListener(this);
    clrButton.addActionListener(this);
    dotButton.addActionListener(this);

    // Panel untuk tombol-tombol
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(4, 5));

    // Baris 1
    buttonPanel.add(numberButtons[1]);
    buttonPanel.add(numberButtons[2]);
    buttonPanel.add(numberButtons[3]);
    buttonPanel.add(addButton);
    buttonPanel.add(clrButton);


    // Baris 2
    buttonPanel.add(numberButtons[4]);
    buttonPanel.add(numberButtons[5]);
    buttonPanel.add(numberButtons[6]);
    buttonPanel.add(subButton);

    // Baris 3
    buttonPanel.add(numberButtons[7]);
    buttonPanel.add(numberButtons[8]);
    buttonPanel.add(numberButtons[9]);
    buttonPanel.add(mulButton);

    // Baris 4
    buttonPanel.add(dotButton);
    buttonPanel.add(numberButtons[0]);
    buttonPanel.add(eqButton);
    buttonPanel.add(divButton);

    //Baris 5
    
    // Tambahkan panel tombol ke frame
    add(buttonPanel, BorderLayout.CENTER);

    // Setting frame
    setTitle("Kalkulator Sederhana");
    setSize(300, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null); // Memposisikan frame di tengah layar
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    if ((command.charAt(0) >= '0' && command.charAt(0) <= '9')) {
      textField.setText(textField.getText() + command);
    } else if (command.charAt(0) == 'C') {
      textField.setText("");
      angkaPertama = angkaKedua = hasil = 0;
      operator = '\0';
    } else if (command.charAt(0) == '=') {
      angkaKedua = Double.parseDouble(textField.getText());

      switch (operator) {
        case '+':
          hasil = angkaPertama + angkaKedua;
          break;
        case '-':
          hasil = angkaPertama - angkaKedua;
          break;
        case 'x':
          hasil = angkaPertama * angkaKedua;
          break;
        case '/':
          if (angkaKedua != 0) {
            hasil = angkaPertama / angkaKedua;
          } else {
            textField.setText("Undefined");
            return;
          }
          break;
      }
      textField.setText(String.valueOf(hasil));
      angkaPertama = hasil;
      operator = '\0';
    } else {
      operator = command.charAt(0);
      angkaPertama = Double.parseDouble(textField.getText());
      textField.setText("");
    }
  }

  public static void main(String[] args) {
    new KalkulatorGUI();
  }
}
