package edu.sjsu.view;

import edu.sjsu.messages.ConfirmDepositMessage;
import edu.sjsu.messages.ConfirmTransferButton;
import edu.sjsu.messages.ConfirmWithdrawMessage;
import edu.sjsu.messages.Message;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * this class lays out the view for the checking account page
 */
public class SavingsViewer extends BankViewer {
    JLabel depositAmount;
    JLabel withdrawAmount;
    JLabel transferAmount;
    JLabel balanceAmount;

    /**
     * @param queue blocking queue storing the messages to be executed
     */
    public SavingsViewer(BlockingQueue<Message> queue) {
        super(queue);
        this.setTitle("Saving's Account");
        this.setBackground(new Color(7, 63, 120));
        this.setVisible(true);
        addAccountName();
        addBalancePanel();
        addDepositPanel();
        addWithdrawPanel();
        addTransferPanel();

    }

    /**
     * this method contains the code for the deposit panel, as well as the action
     * listener for the confirm button which adds a message to the blocking queue
     */
    public void addDepositPanel() {
        JPanel deposit = new JPanel();
        deposit.setBounds(this.getWidth() / 16, 5 * this.getHeight() / 12, this.getWidth() / 4, this.getHeight() / 3);
        deposit.setSize(this.getWidth() / 4, this.getHeight() / 3);

        deposit.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel depositText = new JLabel("Deposit");
        depositText.setFont(new Font("Sans Serif", Font.BOLD, 30));
        depositText.setForeground(Color.WHITE);
        depositText.setVerticalAlignment(SwingConstants.TOP);
        depositAmount = new JLabel("Amount to Deposit:");
        depositAmount.setFont(new Font("Sans Serif", Font.BOLD, 15));
        depositAmount.setForeground(Color.WHITE);
        depositAmount.setVisible(true);
        JTextField amount = new JTextField(5);
        JButton confirm = new JButton("Confirm");

        confirm.addActionListener(e -> {
            double depositAmount = Double.parseDouble(amount.getText());
            try {
                Message msg = new ConfirmDepositMessage(depositAmount);
                queue.put(msg);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });

        deposit.setLayout(new BoxLayout(deposit, BoxLayout.Y_AXIS));
        deposit.add(depositText);
        deposit.add(Box.createRigidArea(new Dimension(0, 60)));
        deposit.add(depositAmount);
        deposit.add(amount);
        deposit.add(Box.createRigidArea(new Dimension(0, 100)));
        deposit.add(confirm);
        deposit.setBackground(new Color(160, 212, 226));
        deposit.setVisible(true);
        this.add(deposit);
    }

    /**
     * this method contains the code for the withdraw panel, as well as the action
     * listener for the confirm button which adds a message to the blocking queue
     */
    public void addWithdrawPanel() {
        JPanel withdraw = new JPanel();
        withdraw.setBounds(6 * (this.getWidth() / 16), 5 * this.getHeight() / 12, this.getWidth() / 4, this.getHeight() / 3);
        withdraw.setSize(this.getWidth() / 4, this.getHeight() / 3);
        withdraw.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel withdrawText = new JLabel("Withdraw");
        withdrawText.setFont(new Font("Sans Serif", Font.BOLD, 30));
        withdrawText.setForeground(Color.WHITE);
        withdrawText.setVerticalAlignment(SwingConstants.TOP);
        withdrawAmount = new JLabel("Amount to Withdraw:");
        withdrawAmount.setFont(new Font("Sans Serif", Font.BOLD, 15));
        withdrawAmount.setForeground(Color.WHITE);
        withdrawAmount.setVisible(true);
        JTextField amount = new JTextField(5);
        JButton confirm = new JButton("Confirm");

        confirm.addActionListener(e -> {
            double withdrawAmount = Double.parseDouble(amount.getText());
            try {
                Message msg = new ConfirmWithdrawMessage(withdrawAmount);
                queue.put(msg);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });


        withdraw.setLayout(new BoxLayout(withdraw, BoxLayout.Y_AXIS));
        withdraw.add(withdrawText);
        withdraw.add(Box.createRigidArea(new Dimension(0, 60)));
        withdraw.add(withdrawAmount);
        withdraw.add(amount);
        withdraw.add(Box.createRigidArea(new Dimension(0, 100)));
        withdraw.add(confirm);
        withdraw.setBackground(new Color(160, 212, 226));
        withdraw.setVisible(true);
        this.add(withdraw);
    }

    /**
     * this method contains the code for the transfer panel, as well as the action
     * listener for the confirm button which adds a message to the blocking queue
     */
    public void addTransferPanel() {
        JPanel transfer = new JPanel();
        transfer.setBounds(11 * (this.getWidth() / 16), 5 * this.getHeight() / 12, this.getWidth() / 4, this.getHeight() / 3);
        transfer.setSize(this.getWidth() / 4, this.getHeight() / 3);
        transfer.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel transferText = new JLabel("Transfer to Checkings");
        transferText.setFont(new Font("Sans Serif", Font.BOLD, 25));
        transferText.setForeground(Color.WHITE);
        transferText.setVerticalAlignment(SwingConstants.TOP);
        transferAmount = new JLabel("Amount to Transfer:");
        transferAmount.setFont(new Font("Sans Serif", Font.BOLD, 15));
        transferAmount.setForeground(Color.WHITE);
        transferAmount.setVisible(true);
        JTextField amount = new JTextField(5);
        JButton confirm = new JButton("Confirm");

        confirm.addActionListener(e -> {
            double transferAmount = Double.parseDouble(amount.getText());
            try {
                Message msg = new ConfirmTransferButton(transferAmount);
                queue.put(msg);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });


        transfer.setLayout(new BoxLayout(transfer, BoxLayout.Y_AXIS));
        transfer.add(transferText);
        transfer.add(Box.createRigidArea(new Dimension(0, 60)));
        transfer.add(transferAmount);
        transfer.add(amount);
        transfer.add(Box.createRigidArea(new Dimension(0, 100)));
        transfer.add(confirm);
        transfer.setBackground(new Color(160, 212, 226));
        transfer.setVisible(true);
        this.add(transfer);
    }

    /**
     * this method contains the code that displays the current balance of the checking
     */
    public void addBalancePanel() {
        JPanel b = new JPanel();
        b.setBounds(this.getWidth() / 16, 3 * this.getHeight() / 12, this.getWidth() / 4, this.getHeight() / 6);
        b.setSize(this.getWidth() / 4, this.getHeight() / 8);
        JLabel balance = new JLabel("Saving's Balance:");
        balance.setFont(new Font("Sans Serif", Font.BOLD, 20));
        balance.setForeground(Color.WHITE);
        balance.setVisible(true);
        JLabel balanceAmount = new JLabel("$300");
        balanceAmount.setFont(new Font("Sans Serif", Font.BOLD, 30));
        b.setBackground(new Color(160, 212, 226));
        b.setVisible(true);
        b.setLayout(new BorderLayout());
        balance.setHorizontalAlignment(SwingConstants.CENTER);
        b.add(balance, BorderLayout.CENTER);
        balanceAmount.setHorizontalAlignment(SwingConstants.CENTER);
        b.add(balanceAmount, BorderLayout.AFTER_LAST_LINE);

        b.setVisible(true);
        this.add(b);
    }


}
