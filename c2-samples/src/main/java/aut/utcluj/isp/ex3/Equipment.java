package aut.utcluj.isp.ex3;

/**
 * @author stefan
 */
public class Equipment {
    private String name;
    private String serialNumber;
    private String owner;
    private boolean taken;

    public Equipment(String serialNumber) {
        if (serialNumber.isEmpty())
            throw new UnsupportedOperationException("Not supported yet.");
        this.name = "NONE";
        this.serialNumber = serialNumber;
        this.owner = null;
        this.taken = false;
    }

    public Equipment(String name, String serialNumber) {
        if (name.isEmpty() || serialNumber.isEmpty())
            throw new UnsupportedOperationException("Not supported yet.");
        this.name = name;
        this.serialNumber = serialNumber;
        this.owner = null;
        this.taken = false;
    }

    public Equipment(String name, String serialNumber, String owner) {
        if (name.isEmpty() || serialNumber.isEmpty() || owner.isEmpty())
            throw new UnsupportedOperationException("Not supported yet.");
        this.name = name;
        this.serialNumber = serialNumber;
        this.owner = owner;
        this.taken = true;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getOwner() {
        return owner;
    }

    public boolean isTaken() {
        return taken;
    }

    /**
     * Provide the owner of the equipment
     * Equipment should be set as taken
     *
     * @param owner - owner name
     */
    public void provideEquipmentToUser(final String owner) {
        if (owner.isEmpty())
            throw new UnsupportedOperationException("Not supported yet.");
        taken = true;
        this.owner = owner;
    }

    /**
     * Equipment is returned to the office
     * Equipment should not be set as taken
     * Remove the owner
     */
    public void returnEquipmentToOffice() {
        taken = false;
        this.owner = null;
    }
}
