package Delivary;

abstract class DeliverableItem implements Deliverable {
    protected boolean toClientAddress;
    protected static double additionalPrice;

    public DeliverableItem(boolean toClientAddress) {
        this.toClientAddress = toClientAddress;
    }

    public static void setAdditionalPrice(double price) {
        additionalPrice = price > 0 ? price : 1;
    }
}