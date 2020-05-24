package aut.utcluj.isp.guiInterface;

import aut.utcluj.isp.ex3.Equipment;
import aut.utcluj.isp.ex3.EquipmentController;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class OwnerGui extends JFrame {

    private JList<String> listOwners;
    private JTextField ownerText;

    EquipmentController controller = new EquipmentController();
    Map<String, List<Equipment>> ownerMap;

   public OwnerGui(){
       setTitle("Owner List");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       init();
       setSize(400, 500);
       setVisible(true);
       setLocationRelativeTo(null);
   }
    public void init() {

        this.setLayout(null);
        int width = 80;
        int height = 20;

        getContentPane().setBackground(Color.pink);

        listOwners = new JList<>();
        listOwners.setForeground(Color.BLACK);
        listOwners.setBackground(Color.white);
        listOwners.setFont(new Font(Font.DIALOG,Font.PLAIN,20));
        listOwners.setBounds(10, 38, width + 40, height + 300);

        JLabel ownerLabel = new JLabel("Owner:");
        ownerLabel.setBounds(10, 10, width, height);

        JLabel textLabel = new JLabel("Name: ");
        textLabel.setBounds(180,78,width,height);

        ownerText=new JTextField();
        ownerText.setBounds(180,100,width+20,height);

        JButton addButton = new JButton("Add");
        addButton.setBounds(150,140,width,height);
        addButton.addActionListener(e -> {
            controller.addEquipment(new Equipment("Dell","SN"+ new Random().nextInt(100),ownerText.getText()));
            ownerMap=controller.getEquipmentsGroupedByOwner();
            String[] ownerString = new String[ownerMap.size()];
            int i=0;
            for (Map.Entry<String,List<Equipment>> aux : ownerMap.entrySet())
            {
                ownerString[i]=aux.getKey();
                i++;
            }

            listOwners.setListData(ownerString);
        });

        JButton removeButton = new JButton("Remove");
        removeButton.setBounds(250,140,width,height);
        removeButton.addActionListener(e -> {

            ownerMap.remove(listOwners.getSelectedValue());

            String[] ownerString = new String[ownerMap.size()];
            int i=0;
            for (Map.Entry<String,List<Equipment>> aux : ownerMap.entrySet())
            {
                ownerString[i]=aux.getKey();
                i++;
            }

            listOwners.setListData(ownerString);

        });

        JButton selectButton = new JButton("Select Owner");
        selectButton.setBounds(180,200,width+50,height+20);
        selectButton.addActionListener(e -> {
            new EquipmentGui(controller,listOwners.getSelectedValue());
        });

        add(listOwners);
        add(ownerLabel);
        add(textLabel);
        add(ownerText);
        add(addButton);
        add(removeButton);
        add(selectButton);
    }

}
