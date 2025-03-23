package Delivary;

class Document extends DeliverableItem {
    private double minPrice;

    public Document(boolean toClientAddress, double minPrice) {
        super(toClientAddress);
        this.minPrice = minPrice > 0 ? minPrice : 1;
    }

    @Override
    public double deliveryPrice() {
        if (toClientAddress) {
            return minPrice + additionalPrice;
        } else {
            return minPrice;
        }
    }
}