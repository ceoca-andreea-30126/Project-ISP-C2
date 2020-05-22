package aut.utcluj.isp.guiInterface;

import aut.utcluj.isp.ex3.Equipment;
import aut.utcluj.isp.ex3.EquipmentController;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class EquipmentGui extends JFrame {

    EquipmentController controller;

    JLabel equipments;

    JList<String> listEquipments, equipmentHistory;
    JButton addEquipment,removeEquipment;
    JTable table;

    EquipmentGui(EquipmentController controller) throws InterruptedException {

        this.controller=controller;

        setTitle("Equipment List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        setSize(500, 500);
        setVisible(true);
    }

    public void init() throws InterruptedException {

        this.setLayout(null);
        int width = 80;
        int height = 20;

        table = new JTable();
        table.setBounds(10,38,width + 300, height + 300);
        String[] columnNames = {"Name",
                "Serial Number",
                "Owner",
                "Operation",
                "DateTime"};

        equipments = new JLabel("Equipments:");
        equipments.setBounds(200, 10, width, height);


        add(table);
        add(equipments);
    }
}
