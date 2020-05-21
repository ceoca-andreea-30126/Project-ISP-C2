package aut.utcluj.isp.ex4;

//import aut.utcluj.isp.ex5.EquipmentHistory;

import java.time.LocalDateTime;

/**
 * @author stefan
 */
public class Equipment {
    private String name;
    private String serialNumber;
    private String currentOwner;
    private boolean taken=false;
    private EquipmentHistory equipmentHistory;

    public Equipment(String serialNumber) {
//        throw new UnsupportedOperationException("Not supported yet.");
        this.name = null;
        this.serialNumber = serialNumber;
        this.currentOwner = null;
        this.taken = false;
        equipmentHistory = new EquipmentHistory();
    }

    public Equipment(String name, String serialNumber) {
//        throw new UnsupportedOperationException("Not supported yet.");
        this.name = name;
        this.serialNumber = serialNumber;
        this.currentOwner = null;
        this.taken = false;
        equipmentHistory = new EquipmentHistory();
    }

    public Equipment(String name, String serialNumber, String owner) {
//        throw new UnsupportedOperationException("Not supported yet.");
        this.name = name;
        this.serialNumber = serialNumber;
        this.currentOwner = owner;
        this.taken = true;
        equipmentHistory = new EquipmentHistory();
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getCurrentOwner() {
        return currentOwner;
    }

    public boolean isTaken() {
        return taken;
    }

    /**
     * Provide equipment to a specific user starting with @param providedDate
     * If equipment is already taken, throw {@link EquipmentAlreadyProvidedException}
     * If equipment is not taken, update taken status, the current user and update also equipment history
     *
     * @param owner        - new owner of the equipment
     * @param providedDate - provided date
     */
    public void provideEquipmentToUser(final String owner, final LocalDateTime providedDate) {
        if (taken==true)
            throw new EquipmentAlreadyProvidedException();
        equipmentHistory.addEquipmentHistory(owner, Operation.PROVIDE, providedDate);
        currentOwner = owner;
        taken = true;
    }

    /**
     * If equipment is not taken by anybody, throw {@link EquipmentNotProvidedException}
     * If equipment is taken, the current user of the equipment should be removed, and taken status should be set to false
     */
    public void returnEquipmentToOffice() {
        if (taken==false)
            throw new EquipmentNotProvidedException();
        equipmentHistory.addEquipmentHistory(this.currentOwner, Operation.RETURN, LocalDateTime.now());
        taken = false;
        currentOwner = null;
    }
}
