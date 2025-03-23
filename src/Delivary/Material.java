package Delivary;

class Material {
    private String name;
    private boolean isFragile;

    public Material(String name, boolean isFragile) {
        this.name = name;
        this.isFragile = isFragile == true;
    }

    public boolean isFragile() {
        return isFragile;
    }
}
