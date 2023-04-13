import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class IntegrationSolverGUI extends JFrame implements ActionListener {
    //private JTextField equationInput;
    private JTextField lowerLimitInput;
    private JTextField upperLimitInput;
    private JButton solveButton;
    private JButton refreshButton;
    private JTextArea solutionOutput;
    private JPanel animationPanel;
    private  JTextArea equationInput;
    private  JTextArea animationText;
    String eqn ="";

    public IntegrationSolverGUI() {
        // Set up the JFrame
        super("Integration Solver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1800, 1200);

        JLabel softwareLabel = new JLabel("Integration Solver");
        softwareLabel.setFont(new Font("Chilanka", Font.BOLD, 35));
        softwareLabel.setForeground(Color.white);

        softwareLabel.setIcon(new ImageIcon("igic.png"));


        softwareLabel.setHorizontalAlignment(JLabel.CENTER);

        // Create the equation input field
        JLabel equationLabel = new JLabel("Enter equation:");
        equationLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        //equationInput = new JTextField(20);
        equationInput = new JTextArea();
        equationInput.setLineWrap(true);

        equationInput.setPreferredSize(new Dimension(300,90));
        equationInput.setFont(new Font("Serif", Font.PLAIN, 20));
        JScrollPane equationScrollPane = new JScrollPane(equationInput);


        // Create the lower limit input field
        JLabel lowerLimitLabel = new JLabel("Lower Limit:");
        lowerLimitLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        lowerLimitInput = new JTextField(10);
        lowerLimitInput.setFont(new Font("Arial", Font.PLAIN, 30));

        // Create the upper limit input field
        JLabel upperLimitLabel = new JLabel("Upper Limit:");
        upperLimitLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        upperLimitInput = new JTextField(10);
        upperLimitInput.setFont(new Font("Arial", Font.PLAIN, 30));

        // Create the solve button
        solveButton = new JButton("Solve");
        solveButton.addActionListener(this);
        solveButton.setFont(new Font("Monospaced", Font.PLAIN, 30));

        // Create the solve button
        refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(this);
        refreshButton.setFont(new Font("Monospaced", Font.PLAIN, 30));

        // Create the solution output field
        JLabel solutionLabel = new JLabel("Solution:");
        solutionLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        solutionOutput = new JTextArea(8, 30);
        solutionOutput.setLineWrap(true);
        solutionOutput.setEditable(false);
        solutionOutput.setFont(new Font("Serif", Font.PLAIN, 30));
        JScrollPane solutionScrollPane = new JScrollPane(solutionOutput);


        animationText = new JTextArea(20, 15);
        animationText.setPreferredSize(new Dimension(200,800));
        animationText.setLineWrap(true);
        animationText.setEditable(false);
        animationText.setFont(new Font("Serif", Font.PLAIN, 23));
        JScrollPane animationScrollPane = new JScrollPane(animationText);
        //animationScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //animationScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        // Create the animation panel
        animationPanel = new JPanel();
        animationPanel.setPreferredSize(new Dimension(500, 800));
        animationPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        JLabel animationLabel = new JLabel("Termwise Integration ");
        animationLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        animationPanel.add(animationLabel);
        animationPanel.add(animationScrollPane);
        animationPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel header = new JPanel(new GridLayout(1,4,10,10));
        header.add(softwareLabel,BorderLayout.CENTER);
        header.setBackground(Color.black);
        header.setBorder(BorderFactory.createEmptyBorder(20,0,15,0));

        JPanel inputPanel = new JPanel(new GridLayout(3, 4, 10, 10));


        // Add the components to the JFrame


        inputPanel.add(lowerLimitLabel, BorderLayout.WEST);
        inputPanel.add(lowerLimitInput, BorderLayout.CENTER);
        inputPanel.add(upperLimitLabel, BorderLayout.CENTER);
        inputPanel.add(upperLimitInput, BorderLayout.WEST);
        inputPanel.add(equationLabel, BorderLayout.CENTER);
        inputPanel.add(equationScrollPane, BorderLayout.WEST);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(solveButton, BorderLayout.WEST);
        buttonPanel.add(refreshButton,BorderLayout.EAST);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(solutionLabel, BorderLayout.NORTH);
        outputPanel.add(solutionScrollPane, BorderLayout.CENTER);
        outputPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        JPanel contentPanel = new JPanel(new BorderLayout());
        //contentPanel.add(header,BorderLayout.CENTER);
        contentPanel.add(inputPanel, BorderLayout.NORTH);
        contentPanel.add(buttonPanel, BorderLayout.CENTER);
        contentPanel.add(outputPanel, BorderLayout.SOUTH);

        Container contentPane = getContentPane();

        contentPane.setLayout(new BorderLayout());
        contentPane.add(header, BorderLayout.NORTH);
        contentPane.add(contentPanel, BorderLayout.CENTER);
        contentPane.add(animationPanel, BorderLayout.EAST);
    }

    public void actionPerformed(ActionEvent e) {
        // Handle the solve button click event
        if (e.getSource() == solveButton) {
            String equation = equationInput.getText();
            eqn = equation;
            //double lowerLimit = Double.parseDouble(lowerLimitInput.getText());
            //double upperLimit = Double.parseDouble(upperLimitInput.getText());
            TermSeperatorAndCalculator tryAnother = new TermSeperatorAndCalculator(eqn.replace(" ",""));
            tryAnother.seperateTerms();//3cosx+7sinx+10logx+8cosx-5logx
            tryAnother.calculate();//5cosx-10logx+3sinx+7cosx
            tryAnother.integrateS();
            String r = "\n Calculation : \t"+ tryAnother.calcResult +"\n\n Integration : \t"+ tryAnother.integrationResult+"\n";
            solutionOutput.setText("");
            animationText.setText("");

            //solutionOutput.append(tryAnother.showResult());
            solutionOutput.append(r);
            animationText.append(tryAnother.stepByStep);
        }
        if (e.getSource() == refreshButton){
            solutionOutput.setText("");
            animationText.setText("");
            equationInput.setText("");
        }
    }

    public String getEqn(){
        return eqn;
    }
}
