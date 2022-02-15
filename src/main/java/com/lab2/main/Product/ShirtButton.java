package com.lab2.main.Product;

import javafx.scene.paint.Color;

import java.util.Objects;

public class ShirtButton extends Product {

    private Color color;

    public ShirtButton(int id, String name, float price, Color color) {
        super(id, name, price);
        this.color = color;
    }

    public ShirtButton(ShirtButton other){
        super(other.getId(),other.getName(),other.getPrice());
        this.color = other.color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShirtButton that = (ShirtButton) o;
        return Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }

    @Override
    public String toString() {
        return "ShirtButton{" +
                super.toString() +
                "color=" + color +
                '}';
    }
}
