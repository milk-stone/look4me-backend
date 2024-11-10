package com.itec0401.backend.domain.clothing.entity.type;

public enum StyleType {
    DAILY, WORK, DATE, CEREMONY, TRAVEL,
    HOMEWEAR, PARTY, EXERCISE, SPECIAL_DAY, SCHOOL,
    OTHER, INVALID;

    public static StyleType convertString(String styleType) {
        for (StyleType style : StyleType.values()) {
            if (style.name().equalsIgnoreCase(styleType)) {
                return style;
            }
        }
        return INVALID;
    }
}
