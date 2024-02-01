package View;
import javax.swing.*;
import Control.ElevadorControl;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElevatorView extends JFrame {
    private ElevadorControl elevadorControl;

    public ElevatorView(ElevadorControl elevadorControl) {
        this.elevadorControl = elevadorControl;
        initComponents();
    }

    private void initComponents() {
        setTitle("Controle de Elevadores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2));

        for (int i = 0; i < elevadorControl.getNumeroElevadores(); i++) {
            JPanel elevadorPanel = new JPanel();
            elevadorPanel.setBorder(BorderFactory.createTitledBorder("Elevador " + i));

            JButton chamarButton = new JButton("Chamar");
            JTextField destinoField = new JTextField(5);
            JLabel estadoLabel = new JLabel();

            final int finalI = i; // Cópia final da variável i

            chamarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int destino = Integer.parseInt(destinoField.getText());
                    elevadorControl.chamarElevador(finalI, destino);
                }
            });

            elevadorPanel.add(chamarButton);
            elevadorPanel.add(new JLabel("Destino:"));
            elevadorPanel.add(destinoField);
            elevadorPanel.add(estadoLabel);

            add(elevadorPanel);
        }

        JButton exibirEstadoButton = new JButton("Exibir Estado Geral");
        exibirEstadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elevadorControl.exibirEstadoGeral();
            }
        });

        add(exibirEstadoButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        ElevadorControl elevadorControl = new ElevadorControl(2, 10); // Substitua 2 e 10 pelos valores desejados
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ElevatorView(elevadorControl);
            }
        });
    }
}
