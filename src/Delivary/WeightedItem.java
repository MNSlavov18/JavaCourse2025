package Delivary;

class WeightedItem extends DeliverableItem {
    private Material material;
    private double weight;
    private double pricePerKg;

    public WeightedItem(boolean toClientAddress, Material material, double weight, double pricePerKg) {
        super(toClientAddress);
        this.material = material;
        this.weight = weight > 0 ? weight : 1;
        this.pricePerKg = pricePerKg > 0 ? pricePerKg : 1;
    }

    @Override
    public double deliveryPrice() {
        double price = weight * pricePerKg;
        if (toClientAddress) {
            price += additionalPrice;
        }
        if (material.isFragile()) {
            price *= 1.01;
        }
        return price;
    }
}