package aut.utcluj.isp.guiInterface;

import aut.utcluj.isp.ex3.Equipment;
import aut.utcluj.isp.ex3.EquipmentController;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class OwnerGui extends JFrame {
    JLabel ownerLabel, textLabel;
    JList<String> listOwners;
    JTextField ownerText;
    JButton addButton, removeButton , selectButton;

    EquipmentController controller = new EquipmentController();
    Map<String, List<Equipment>> ownerMap;

   public OwnerGui(){
       setTitle("Owner List");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       init();
       setSize(400, 500);
       setVisible(true);
   }
    public void init() {

        this.setLayout(null);
        int width = 80;
        int height = 20;

        listOwners = new JList<>();
        listOwners.setBounds(10, 38, width + 40, height + 300);


        ownerLabel = new JLabel("Owner:");
        ownerLabel.setBounds(10, 10, width, height);

        textLabel=new JLabel("Name: ");
        textLabel.setBounds(180,78,width,height);

        ownerText=new JTextField();
        ownerText.setBounds(180,100,width+20,height);

        addButton=new JButton("Add");
        addButton.setBounds(150,140,width,height);
        addButton.addActionListener(e -> {
            controller.addEquipment(new Equipment("None","SN"+ new Random().nextInt(100),ownerText.getText()));
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

        removeButton=new JButton("Remove");
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

        selectButton=new JButton("Select Owner");
        selectButton.setBounds(180,200,width+50,height+20);
        selectButton.addActionListener(e -> {
            try {
                new EquipmentGui(controller);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
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
