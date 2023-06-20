package dev.aronba.opengym;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

public enum Theme {
    FlatLafDark,
    FlatLafLight,
    FlatLafMacLight,
    FlatLafMacDark,
    FlatLafIntellij,
    FlatLafDarcula;
    public static FlatLaf getTheme(Theme theme) {
        return switch (theme) {
            case FlatLafDark -> new FlatDarkLaf();
            case FlatLafLight -> new FlatLightLaf();
            case FlatLafMacLight -> new FlatMacLightLaf();
            case FlatLafMacDark -> new FlatMacDarkLaf();
            case FlatLafIntellij -> new FlatIntelliJLaf();
            case FlatLafDarcula -> new FlatDarculaLaf();
        };
    }
}
