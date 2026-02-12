/****
    Author: Amiangshu Bosu
    Date: September 2nd
    */
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class MacAddressPrinter {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println("Attempting to retrieve MAC address(es):");

        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ni = networkInterfaces.nextElement();
                byte[] hardwareAddress = ni.getHardwareAddress();

                if (hardwareAddress != null) {
                    StringBuilder macAddressBuilder = new StringBuilder();
                    for (int i = 0; i < hardwareAddress.length; i++) {
                        macAddressBuilder.append(String.format("%02X%s", hardwareAddress[i], (i < hardwareAddress.length - 1) ? "-" : ""));
                    }
                    System.out.println("MAC Address for " + ni.getDisplayName() + ": " + macAddressBuilder.toString());
                }
            }
        } catch (SocketException e) {
            System.err.println("Error accessing network interfaces: " + e.getMessage());
        }
    }
}