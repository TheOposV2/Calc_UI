import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.round;


public class GUI implements ActionListener {

   private static JFrame frame;
   private static JPanel panel;
   private static JButton button;
   private static JLabel lable;
   private static JTextField MathSpace;

    public static void main(String[] args){

            //definitions of elements
            frame = new JFrame();
            panel = new JPanel();
            lable = new JLabel();

            GridBagConstraints gbc = new GridBagConstraints();

            panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            panel.setLayout(new GridBagLayout());
            //def of layout

            MathSpace = new JTextField("",12);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 4;
            panel.add(MathSpace,gbc);
            gbc.gridwidth = 1;

            JButton c = new JButton("c");
            gbc.gridx = 4;
            gbc.gridy = 0;
            c.addActionListener(new GUI());
            panel.add(c,gbc);

            JButton addition = new JButton("+");
            gbc.gridx = 0;
            gbc.gridy = 1;
            addition.addActionListener(new GUI());
            panel.add(addition,gbc);

            JButton sub  = new JButton("-");
            gbc.gridx = 1;
            gbc.gridy = 1;
            sub.addActionListener(new GUI());
            panel.add(sub,gbc);

            JButton multi  = new JButton("*");
            gbc.gridx = 2;
            gbc.gridy = 1;
            multi.addActionListener(new GUI());
            panel.add(multi,gbc);

            JButton div  = new JButton("/");
            gbc.gridx = 3;
            gbc.gridy = 1;
            div.addActionListener(new GUI());
            panel.add(div,gbc);

            JButton one = new JButton("1");
            gbc.gridx = 0;
            gbc.gridy = 2;
            one.addActionListener(new GUI());
            panel.add(one,gbc);

            JButton two = new JButton("2");
            gbc.gridx = 1;
            gbc.gridy = 2;
            two.addActionListener(new GUI());
            panel.add(two,gbc);

            JButton thre = new JButton("3");
            gbc.gridx = 2;
            gbc.gridy = 2;
            thre.addActionListener(new GUI());
            panel.add(thre,gbc);

            JButton four = new JButton("4");
            gbc.gridx = 3;
            gbc.gridy = 2;
            four.addActionListener(new GUI());
            panel.add(four,gbc);

            JButton five = new JButton("5");
            gbc.gridx = 0;
            gbc.gridy = 3;
            five.addActionListener(new GUI());
            panel.add(five,gbc);

            JButton six = new JButton("6");
            gbc.gridx = 1;
            gbc.gridy = 3;
            six.addActionListener(new GUI());
            panel.add(six,gbc);

            JButton seven = new JButton("7");
            gbc.gridx = 2;
            gbc.gridy = 3;
            seven.addActionListener(new GUI());
            panel.add(seven,gbc);

            JButton eight = new JButton("8");
            gbc.gridx = 3;
            gbc.gridy = 3;
            eight.addActionListener(new GUI());
            panel.add(eight,gbc);

            JButton nine = new JButton("9");
            gbc.gridx = 0;
            gbc.gridy = 4;
            nine.addActionListener(new GUI());
            panel.add(nine,gbc);

            JButton zero = new JButton("0");
            gbc.gridx = 1;
            gbc.gridy = 4;
            zero.addActionListener(new GUI());
            panel.add(zero,gbc);

            JButton dot = new JButton(".");
            gbc.gridx = 2;
            gbc.gridy = 4;
            dot.addActionListener(new GUI());
            panel.add(dot,gbc);

            JButton eqals = new JButton("=");
            gbc.gridx = 3;
            gbc.gridy = 4;
            eqals.addActionListener(new GUI());
            panel.add(eqals,gbc);


            //frame setings
            frame.add(panel, BorderLayout.SOUTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("CALC");
            frame.pack();
            frame.setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
          String type =  e.getActionCommand();
          if (type.charAt(0) == 'c'){
                MathSpace.setText("");
          }
          else if (type.charAt(0) == '=') {
                 MathSpace.setText(evaluate(MathSpace.getText()));
          }
          else  {
               MathSpace.setText(MathSpace.getText() + type);
          }
        }

        public static String evaluate(String expression){

            char[] arr = expression.toCharArray();
            String FirstNumb = "", SecondNumber = "", Operand = "";
            double result = 0;

            for(int i = 0; i < arr.length; i++){

              if(Operand.isEmpty()) {
                      FirstNumb += arr[i];
              }
              else {
                      SecondNumber += arr[i];
              }

              if(arr[i] == '+' || arr[i] == '-' || arr[i] == '/' || arr[i] == '*') {
                            Operand += arr[i];
              }

            }
                if ((FirstNumb != null) && (FirstNumb.length() > 0)) {
                        FirstNumb = FirstNumb.substring(0, FirstNumb.length() - 1);
                }

                switch (Operand.charAt(0)){
                        case '+':
                        result = Math.round((Double.parseDouble(FirstNumb) + Double.parseDouble(SecondNumber)));
                        break;

                        case '-':
                        result = Math.round((Double.parseDouble(FirstNumb) - Double.parseDouble(SecondNumber)));
                        break;

                        case '*':
                        result = Math.round((Double.parseDouble(FirstNumb) * Double.parseDouble(SecondNumber)));
                        break;

                        case '/':
                        if(SecondNumber == "0"){
                               return "error";
                        }
                        result = Math.round((Double.parseDouble(FirstNumb) / Double.parseDouble(SecondNumber)));
                        break;
            }

            return FirstNumb + Operand + SecondNumber + "=" + result;
        }

    }


