package com.itec0401.backend.domain.clothing.entity.type;

public enum TextileType {
    COTTON, LINEN, POLYESTER, KNIT_WOOL, FUR,
    TWEED, NYLON, DENIM, LEATHER, SUEDE,
    VELVET, CHIFFON, SILK, CORDUROY, METALLIC,
    LACE, OTHER;

    public static TextileType convertString(String textile){
        for (TextileType textileType : TextileType.values()) {
            if (textileType.name().equals(textile)) {
                return textileType;
            }
        }
        return OTHER;
    }
}
