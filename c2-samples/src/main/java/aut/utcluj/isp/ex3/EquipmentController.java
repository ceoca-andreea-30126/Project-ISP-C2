package aut.utcluj.isp.ex3;

import java.util.*;

/**
 * @author stefan
 */
public class EquipmentController {

    /**
     * Add new equipment to the list of equipments
     *
     * @param equipment - equipment to be added
     */
    List<Equipment> equipments;
    public EquipmentController(){
        equipments=new ArrayList<>();
    }

    public void addEquipment(final Equipment equipment) {
        if(equipment == null) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        equipments.add(equipment);
    }

    /**
     * Get current list of equipments
     *
     * @return list of equipments
     */

    public List<Equipment> getEquipments() {
        if(equipments.isEmpty()) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        return equipments;
    }

    /**
     * Get number of equipments
     *
     * @return number of equipments
     */
    public int getNumberOfEquipments() {
        if(equipments.isEmpty()) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        return equipments.size();
    }

    /**
     * Group equipments by owner
     *
     * @return a dictionary where the key is the owner and value is represented by list of equipments he owns
     */
    Map<String ,List<Equipment>> equipmentMap = new HashMap<>();

    public Map<String, List<Equipment>> getEquipmentsGroupedByOwner() {

        //throw new UnsupportedOperationException("Not supported yet.");
        equipments.sort(Comparator.comparing(Equipment::getOwner));

        Equipment equipment1 = equipments.get(0);
        List<Equipment> equipmentList = new ArrayList<>();
        int i = 1;
//        while(i < equipments.size()) {
//            while (equipments.get(i).getOwner().equals(equipment1.getOwner())) {
//                equipmentList.add(equipments.get(i));
//                i++;
//            }
//            equipmentMap.put(equipments.get(i).getOwner(), equipmentList);
//            equipment1 = equipments.get(i);
//            i++;
//        }
        return equipmentMap;
    }

    /**
     * Remove a particular equipment from equipments list by serial number
     * @param serialNumber - unique serial number
     * @return deleted equipment instance or null if not found
     */
    public Equipment removeEquipmentBySerialNumber(final String serialNumber) {
        for(int i=0;i<equipments.size();i++)
            if(equipments.get(i).getSerialNumber().equals(serialNumber)) {
                Equipment x=equipments.get(i);
                equipments.remove(i);
                return x;
            }
        return null;
    }
}
