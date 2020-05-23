package aut.utcluj.isp.guiInterface;

import aut.utcluj.isp.ex3.Equipment;
import aut.utcluj.isp.ex3.EquipmentController;
import aut.utcluj.isp.ex4.Operation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class EquipmentGui extends JFrame {

    EquipmentController controller;
    String owner;

    JLabel equipments,nameLabel,operationLabel;
    JButton addEquipment, removeEquipment, refreshData;
    JTable table;
    JTextField nameText, operationText;

    EquipmentGui(EquipmentController controller, String owner) throws InterruptedException {

        this.controller = controller;
        this.owner = owner;

        setTitle("Equipment List");
        init();
        setSize(500, 500);
        setVisible(true);
    }

    public void init() throws InterruptedException {

        this.setLayout(null);
        int width = 80;
        int height = 20;

        /*String[] columnNames = {"Name",
                "Serial Number",
                "Owner",
                "Operation",
                "DateTime"};

        Object[][] data = {
                {"Name", "Serial Number",
                        "Owner", "Operation", "DateTime"},

        };*/


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

        equipments = new JLabel("Equipments:");
        equipments.setBounds(200, 10, width, height);

        addEquipment = new JButton("Add Equipment");
        addEquipment.setBounds(50, 270, width + 80, height + 30);
        addEquipment.addActionListener(e -> {
            String sn="SN" + new Random().nextInt(100);
            tableModel.insertRow(tableModel.getRowCount(), new Object[]{nameText.getText(), sn,
                    owner, operationText.getText(), LocalDateTime.now()});
            controller.addEquipment(new Equipment(nameText.getText(),sn,owner));
        });

        nameLabel=new JLabel("Name");
        nameLabel.setBounds(50,350,width,height);

        operationLabel=new JLabel("Operation");
        operationLabel.setBounds(50,380,width,height);

        nameText=new JTextField();
        nameText.setBounds(130,350,width+30,height);

        operationText=new JTextField();
        operationText.setBounds(130,380,width+30,height);

        removeEquipment = new JButton("Remove Equipment");
        removeEquipment.setBounds(250, 270, width + 80, height + 30);
        removeEquipment.addActionListener(e -> {
            controller.removeEquipmentBySerialNumber(table.getValueAt(table.getSelectedRow(),1).toString());
            tableModel.removeRow(table.getSelectedRow());
        });

        add(equipments);
        add(table);
        add(addEquipment);
        add(nameLabel);
        add(operationLabel);
        add(nameText);
        add(operationText);
        add(removeEquipment);
    }
}
