package Delivary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String materialName = bufferedReader.readLine();

        boolean isFragile = Integer.parseInt(bufferedReader.readLine().trim()) != 0;

        boolean toClientsAddress = Integer.parseInt(bufferedReader.readLine().trim()) != 0;

        double minPrice = Double.parseDouble(bufferedReader.readLine().trim());

        double weight = Double.parseDouble(bufferedReader.readLine().trim());

        double pricePerKg = Double.parseDouble(bufferedReader.readLine().trim());

        double additionalPrice = Double.parseDouble(bufferedReader.readLine().trim());

        DeliverableItem.setAdditionalPrice(additionalPrice);

        Material material = new Material(materialName, isFragile);
        Deliverable doc = new Document(toClientsAddress == true, minPrice);
        System.out.println(doc.deliveryPrice());

        Deliverable weightedItem = new WeightedItem(toClientsAddress == true, material, weight, pricePerKg);
        System.out.println(weightedItem.deliveryPrice());
    }
}
