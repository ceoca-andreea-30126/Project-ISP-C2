package aut.utcluj.isp.ex2;

/**
 * @author stefan
 */
public class Notebook extends Equipment {
    private String osVersion;

    public Notebook(String name, String serialNumber, String osVersion) {
        super(name, serialNumber);
        if (osVersion.isEmpty())
            throw new UnsupportedOperationException("Not supported yet.");
        this.osVersion = osVersion;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public String start() {
        return "Notebook " + super.getName() + " started";
    }
}
