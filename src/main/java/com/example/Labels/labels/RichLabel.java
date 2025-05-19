package com.example.Labels.labels;

import java.awt.*;

public class RichLabel implements Label{
    private String value;
    private Color color;
    private int size;
    private String font;
    @Override
    public String getText() {
        return value;
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
