package com.example.Labels.labels;

import java.awt.*;

public class RichLabel implements Label {
    private String value;
    private Color color;
    private int size;
    private String font;

    public RichLabel(String value, String font, int size, Color color) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        this.value = value;
        this.font = font != null ? font : "Arial";
        this.size = size > 0 ? size : 12;
        this.color = color != null ? color : Color.BLACK;
    }

    @Override
    public String getText() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public String getFont() {
        return font;
    }

    public void setColor(Color color) {
        this.color = color != null ? color : Color.BLACK;
    }

    public void setSize(int size) {
        this.size = size > 0 ? size : this.size;
    }

    public void setFont(String font) {
        this.font = font != null ? font : this.font;
    }
}

///version with flyweight

//class RichLabel implements Label{
//    private String value;
//    private TextStyle textStyle;
//    @Override
//    public String getText() {
//        return value;
//    }
//}
//
//class TextStyle {
//    private int size;
//    private String font;
//    private Color color;
//
//    public TextStyle(int size, String font, Color color) {
//        Null checks to be added
//        this.size = size;
//        this.font = font;
//        this.color = color;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        TextStyle textStyle = (TextStyle) o;
//        return size == textStyle.size && Objects.equals(font, textStyle.font) && Objects.equals(color, textStyle.color);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(size, font, color);
//    }
//}
//
//class TextStyleFactory{
//    private static final Map<Integer, TextStyle> cache = new HashMap<>();
//
//    public static TextStyle getTextStyle(int size, String font, Color color){
//        int styleId = Objects.hash(size, font, color);
//        if(!cache.containsKey(styleId)){
//            cache.put(styleId, new TextStyle(size, font, color));
//        }
//        return cache.get(styleId);
//    }
//}
