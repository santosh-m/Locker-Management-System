package model;

public class Size {

    private double width;
    private double height;

    public Size(final double width, final double height) {
        this.width = width;
        this.height = height;
    }

    public boolean canAccomodate(Size size) {
        if(this.height <= size.height && this.width <= size.width){
            return true;
        }
        else{
            return false;
        }
    }
}
