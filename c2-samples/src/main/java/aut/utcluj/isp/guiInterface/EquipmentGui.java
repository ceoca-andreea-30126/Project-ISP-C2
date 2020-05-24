package aut.utcluj.isp.guiInterface;

import aut.utcluj.isp.ex3.Equipment;
import aut.utcluj.isp.ex3.EquipmentController;
import aut.utcluj.isp.ex4.Operation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class EquipmentGui extends JFrame {

    private EquipmentController controller;
    private String owner;

    private JTextField nameText;
    private JComboBox<String> comboBox1;

    private JPanel jPanel;

    EquipmentGui(EquipmentController controller, String owner) {

        this.controller = controller;
        this.owner = owner;

        setTitle("Equipment List");
        init();
        setSize(500, 500);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void init() {

        this.setLayout(null);
        int width = 80;
        int height = 20;

        getContentPane().setBackground(Color.CYAN);

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        table.setBounds(30, 50, width + 355, height + 150);

        tableModel.addColumn("Name");
        tableModel.addColumn("Serial Number");
        tableModel.addColumn("Owner");
        tableModel.addColumn("Operation");
        tableModel.addColumn("DateTime");
        tableModel.insertRow(0, new Object[]{"Name", "Serial Number", "Owner", "Operation", "DateTime"});

        for (Map.Entry<String, List<Equipment>> stringListEntry : controller.getEquipmentsGroupedByOwner().entrySet()) {
            if (stringListEntry.getKey().equals(owner)) {
                for (Equipment equipment : stringListEntry.getValue()) {
                        tableModel.insertRow(tableModel.getRowCount(), new Object[]{equipment.getName(), equipment.getSerialNumber(), equipment.getOwner(),
                                Operation.PROVIDE, LocalDateTime.now()});
                }
            }
        }

        JLabel equipments = new JLabel("Equipments:");
        equipments.setBounds(200, 10, width, height);

        JButton addEquipment = new JButton("Add Equipment");
        addEquipment.setBounds(50, 270, width + 80, height + 30);
        addEquipment.addActionListener(e -> {
            String sn="SN" + new Random().nextInt(100);
            tableModel.insertRow(tableModel.getRowCount(), new Object[]{nameText.getText(), sn,
                    owner, comboBox1.getItemAt(comboBox1.getSelectedIndex()), LocalDateTime.now()});
            controller.addEquipment(new Equipment(nameText.getText(),sn,owner));
        });

        String[]selectOperation={Operation.RETURN.toString(),Operation.PROVIDE.toString()};
        comboBox1=new JComboBox<>(selectOperation);
        comboBox1.setBounds(130,400,width+30,height);

        JLabel operationLabel = new JLabel("Operation");
        operationLabel.setBounds(50,400,width,height);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50,350,width,height);

        nameText=new JTextField();
        nameText.setBounds(130,350,width+30,height);

        JButton removeEquipment = new JButton("Remove Equipment");
        removeEquipment.setBounds(250, 270, width + 80, height + 30);
        removeEquipment.addActionListener(e -> {
            controller.removeEquipmentBySerialNumber(table.getValueAt(table.getSelectedRow(),1).toString());
            tableModel.removeRow(table.getSelectedRow());
        });

        add(equipments);
        add(table);
        add(addEquipment);
        add(nameLabel);
        add(nameText);
        add(operationLabel);
        add(removeEquipment);
        add(comboBox1);
    }
}
