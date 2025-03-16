package Manufacturer;
import java.io.*;

import static java.util.stream.Collectors.joining;



class Manufacturer {
        String manufacturerName;
        boolean isLongTermWarranty;

        Manufacturer(String manufacturerName, boolean isLongTermWarranty) {
            this.manufacturerName = manufacturerName;
            this.isLongTermWarranty = isLongTermWarranty;
        }
    }
    class ElectricDevice {
        Manufacturer manufacturer;
        int minWarranty;

        ElectricDevice(Manufacturer manufacturer, int minWarranty) {
            this.manufacturer = manufacturer;
            this.minWarranty = Math.max(minWarranty, 6);
        }

        int warranty() {
            return minWarranty + (manufacturer.isLongTermWarranty ? 12 : 0);
        }
    }

    class Cooker extends ElectricDevice {
        boolean isGas;

        Cooker(Manufacturer manufacturer, int minWarranty, boolean isGas) {
            super(manufacturer, minWarranty);
            this.isGas = isGas;
        }

        @Override
        int warranty() {
            return super.warranty() + (isGas ? 12 : 0);
        }
    }

    class WashingMachine extends ElectricDevice {
        boolean isDryer;

        WashingMachine(Manufacturer manufacturer, int minWarranty, boolean isDryer) {
            super(manufacturer, minWarranty);
            this.isDryer = isDryer;
        }

        @Override
        int warranty() {
            return super.warranty() + (isDryer ? minWarranty / 2 : 0);
        }
    }
public class ManufacturerSalution {
    public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String manufacturerName = bufferedReader.readLine();

            boolean isLongTermWarranty = Integer.parseInt(bufferedReader.readLine().trim()) != 0;

            int minWarranty = Integer.parseInt(bufferedReader.readLine().trim());

            boolean isGas = Integer.parseInt(bufferedReader.readLine().trim()) != 0;

            boolean isDryer = Integer.parseInt(bufferedReader.readLine().trim()) != 0;

            Manufacturer manufacturer = new Manufacturer(manufacturerName, isLongTermWarranty);
            ElectricDevice electricDevice = new ElectricDevice(manufacturer, minWarranty);
            System.out.println(electricDevice.warranty());

            electricDevice = new Cooker(manufacturer, minWarranty, isGas);
            System.out.println(electricDevice.warranty());

            electricDevice = new WashingMachine(manufacturer, minWarranty, isDryer);
            System.out.println(electricDevice.warranty());

            bufferedReader.close();

            bufferedReader.close();
        }
    }

