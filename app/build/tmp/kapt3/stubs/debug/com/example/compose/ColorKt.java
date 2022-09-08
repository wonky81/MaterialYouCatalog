package com.example.compose;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\bt\"\u0016\u0010\u0000\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\"\u0016\u0010\t\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\n\u0010\u0003\"\u0016\u0010\u000b\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\f\u0010\u0003\"\u0016\u0010\r\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u000e\u0010\u0003\"\u0016\u0010\u000f\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\u0003\"\u0016\u0010\u0011\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0012\u0010\u0003\"\u0016\u0010\u0013\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0014\u0010\u0003\"\u0016\u0010\u0015\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0016\u0010\u0003\"\u0016\u0010\u0017\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0018\u0010\u0003\"\u0016\u0010\u0019\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u001a\u0010\u0003\"\u0016\u0010\u001b\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u001c\u0010\u0003\"\u0016\u0010\u001d\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u001e\u0010\u0003\"\u0016\u0010\u001f\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b \u0010\u0003\"\u0016\u0010!\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\"\u0010\u0003\"\u0016\u0010#\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b$\u0010\u0003\"\u0016\u0010%\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b&\u0010\u0003\"\u0016\u0010\'\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b(\u0010\u0003\"\u0016\u0010)\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b*\u0010\u0003\"\u0016\u0010+\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b,\u0010\u0003\"\u0016\u0010-\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b.\u0010\u0003\"\u0016\u0010/\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b0\u0010\u0003\"\u0016\u00101\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b2\u0010\u0003\"\u0016\u00103\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b4\u0010\u0003\"\u0016\u00105\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b6\u0010\u0003\"\u0016\u00107\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b8\u0010\u0003\"\u0016\u00109\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b:\u0010\u0003\"\u0016\u0010;\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b<\u0010\u0003\"\u0016\u0010=\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b>\u0010\u0003\"\u0016\u0010?\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b@\u0010\u0003\"\u0016\u0010A\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bB\u0010\u0003\"\u0016\u0010C\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bD\u0010\u0003\"\u0016\u0010E\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bF\u0010\u0003\"\u0016\u0010G\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bH\u0010\u0003\"\u0016\u0010I\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bJ\u0010\u0003\"\u0016\u0010K\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bL\u0010\u0003\"\u0016\u0010M\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bN\u0010\u0003\"\u0016\u0010O\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bP\u0010\u0003\"\u0016\u0010Q\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bR\u0010\u0003\"\u0016\u0010S\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bT\u0010\u0003\"\u0016\u0010U\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bV\u0010\u0003\"\u0016\u0010W\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bX\u0010\u0003\"\u0016\u0010Y\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bZ\u0010\u0003\"\u0016\u0010[\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\\\u0010\u0003\"\u0016\u0010]\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b^\u0010\u0003\"\u0016\u0010_\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b`\u0010\u0003\"\u0016\u0010a\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bb\u0010\u0003\"\u0016\u0010c\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bd\u0010\u0003\"\u0016\u0010e\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bf\u0010\u0003\"\u0016\u0010g\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bh\u0010\u0003\"\u0016\u0010i\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bj\u0010\u0003\"\u0016\u0010k\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bl\u0010\u0003\"\u0016\u0010m\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bn\u0010\u0003\"\u0016\u0010o\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bp\u0010\u0003\"\u0016\u0010q\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\br\u0010\u0003\"\u0016\u0010s\u001a\u00020\u0001\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\bt\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006u"}, d2 = {"md_theme_dark_background", "Landroidx/compose/ui/graphics/Color;", "getMd_theme_dark_background", "()J", "J", "md_theme_dark_error", "getMd_theme_dark_error", "md_theme_dark_errorContainer", "getMd_theme_dark_errorContainer", "md_theme_dark_inverseOnSurface", "getMd_theme_dark_inverseOnSurface", "md_theme_dark_inversePrimary", "getMd_theme_dark_inversePrimary", "md_theme_dark_inverseSurface", "getMd_theme_dark_inverseSurface", "md_theme_dark_onBackground", "getMd_theme_dark_onBackground", "md_theme_dark_onError", "getMd_theme_dark_onError", "md_theme_dark_onErrorContainer", "getMd_theme_dark_onErrorContainer", "md_theme_dark_onPrimary", "getMd_theme_dark_onPrimary", "md_theme_dark_onPrimaryContainer", "getMd_theme_dark_onPrimaryContainer", "md_theme_dark_onSecondary", "getMd_theme_dark_onSecondary", "md_theme_dark_onSecondaryContainer", "getMd_theme_dark_onSecondaryContainer", "md_theme_dark_onSurface", "getMd_theme_dark_onSurface", "md_theme_dark_onSurfaceVariant", "getMd_theme_dark_onSurfaceVariant", "md_theme_dark_onTertiary", "getMd_theme_dark_onTertiary", "md_theme_dark_onTertiaryContainer", "getMd_theme_dark_onTertiaryContainer", "md_theme_dark_outline", "getMd_theme_dark_outline", "md_theme_dark_primary", "getMd_theme_dark_primary", "md_theme_dark_primaryContainer", "getMd_theme_dark_primaryContainer", "md_theme_dark_secondary", "getMd_theme_dark_secondary", "md_theme_dark_secondaryContainer", "getMd_theme_dark_secondaryContainer", "md_theme_dark_shadow", "getMd_theme_dark_shadow", "md_theme_dark_surface", "getMd_theme_dark_surface", "md_theme_dark_surfaceTint", "getMd_theme_dark_surfaceTint", "md_theme_dark_surfaceVariant", "getMd_theme_dark_surfaceVariant", "md_theme_dark_tertiary", "getMd_theme_dark_tertiary", "md_theme_dark_tertiaryContainer", "getMd_theme_dark_tertiaryContainer", "md_theme_light_background", "getMd_theme_light_background", "md_theme_light_error", "getMd_theme_light_error", "md_theme_light_errorContainer", "getMd_theme_light_errorContainer", "md_theme_light_inverseOnSurface", "getMd_theme_light_inverseOnSurface", "md_theme_light_inversePrimary", "getMd_theme_light_inversePrimary", "md_theme_light_inverseSurface", "getMd_theme_light_inverseSurface", "md_theme_light_onBackground", "getMd_theme_light_onBackground", "md_theme_light_onError", "getMd_theme_light_onError", "md_theme_light_onErrorContainer", "getMd_theme_light_onErrorContainer", "md_theme_light_onPrimary", "getMd_theme_light_onPrimary", "md_theme_light_onPrimaryContainer", "getMd_theme_light_onPrimaryContainer", "md_theme_light_onSecondary", "getMd_theme_light_onSecondary", "md_theme_light_onSecondaryContainer", "getMd_theme_light_onSecondaryContainer", "md_theme_light_onSurface", "getMd_theme_light_onSurface", "md_theme_light_onSurfaceVariant", "getMd_theme_light_onSurfaceVariant", "md_theme_light_onTertiary", "getMd_theme_light_onTertiary", "md_theme_light_onTertiaryContainer", "getMd_theme_light_onTertiaryContainer", "md_theme_light_outline", "getMd_theme_light_outline", "md_theme_light_primary", "getMd_theme_light_primary", "md_theme_light_primaryContainer", "getMd_theme_light_primaryContainer", "md_theme_light_secondary", "getMd_theme_light_secondary", "md_theme_light_secondaryContainer", "getMd_theme_light_secondaryContainer", "md_theme_light_shadow", "getMd_theme_light_shadow", "md_theme_light_surface", "getMd_theme_light_surface", "md_theme_light_surfaceTint", "getMd_theme_light_surfaceTint", "md_theme_light_surfaceVariant", "getMd_theme_light_surfaceVariant", "md_theme_light_tertiary", "getMd_theme_light_tertiary", "md_theme_light_tertiaryContainer", "getMd_theme_light_tertiaryContainer", "seed", "getSeed", "app_debug"})
public final class ColorKt {
    private static final long md_theme_light_primary = 0L;
    private static final long md_theme_light_onPrimary = 0L;
    private static final long md_theme_light_primaryContainer = 0L;
    private static final long md_theme_light_onPrimaryContainer = 0L;
    private static final long md_theme_light_secondary = 0L;
    private static final long md_theme_light_onSecondary = 0L;
    private static final long md_theme_light_secondaryContainer = 0L;
    private static final long md_theme_light_onSecondaryContainer = 0L;
    private static final long md_theme_light_tertiary = 0L;
    private static final long md_theme_light_onTertiary = 0L;
    private static final long md_theme_light_tertiaryContainer = 0L;
    private static final long md_theme_light_onTertiaryContainer = 0L;
    private static final long md_theme_light_error = 0L;
    private static final long md_theme_light_errorContainer = 0L;
    private static final long md_theme_light_onError = 0L;
    private static final long md_theme_light_onErrorContainer = 0L;
    private static final long md_theme_light_background = 0L;
    private static final long md_theme_light_onBackground = 0L;
    private static final long md_theme_light_surface = 0L;
    private static final long md_theme_light_onSurface = 0L;
    private static final long md_theme_light_surfaceVariant = 0L;
    private static final long md_theme_light_onSurfaceVariant = 0L;
    private static final long md_theme_light_outline = 0L;
    private static final long md_theme_light_inverseOnSurface = 0L;
    private static final long md_theme_light_inverseSurface = 0L;
    private static final long md_theme_light_inversePrimary = 0L;
    private static final long md_theme_light_shadow = 0L;
    private static final long md_theme_light_surfaceTint = 0L;
    private static final long md_theme_dark_primary = 0L;
    private static final long md_theme_dark_onPrimary = 0L;
    private static final long md_theme_dark_primaryContainer = 0L;
    private static final long md_theme_dark_onPrimaryContainer = 0L;
    private static final long md_theme_dark_secondary = 0L;
    private static final long md_theme_dark_onSecondary = 0L;
    private static final long md_theme_dark_secondaryContainer = 0L;
    private static final long md_theme_dark_onSecondaryContainer = 0L;
    private static final long md_theme_dark_tertiary = 0L;
    private static final long md_theme_dark_onTertiary = 0L;
    private static final long md_theme_dark_tertiaryContainer = 0L;
    private static final long md_theme_dark_onTertiaryContainer = 0L;
    private static final long md_theme_dark_error = 0L;
    private static final long md_theme_dark_errorContainer = 0L;
    private static final long md_theme_dark_onError = 0L;
    private static final long md_theme_dark_onErrorContainer = 0L;
    private static final long md_theme_dark_background = 0L;
    private static final long md_theme_dark_onBackground = 0L;
    private static final long md_theme_dark_surface = 0L;
    private static final long md_theme_dark_onSurface = 0L;
    private static final long md_theme_dark_surfaceVariant = 0L;
    private static final long md_theme_dark_onSurfaceVariant = 0L;
    private static final long md_theme_dark_outline = 0L;
    private static final long md_theme_dark_inverseOnSurface = 0L;
    private static final long md_theme_dark_inverseSurface = 0L;
    private static final long md_theme_dark_inversePrimary = 0L;
    private static final long md_theme_dark_shadow = 0L;
    private static final long md_theme_dark_surfaceTint = 0L;
    private static final long seed = 0L;
    
    public static final long getMd_theme_light_primary() {
        return 0L;
    }
    
    public static final long getMd_theme_light_onPrimary() {
        return 0L;
    }
    
    public static final long getMd_theme_light_primaryContainer() {
        return 0L;
    }
    
    public static final long getMd_theme_light_onPrimaryContainer() {
        return 0L;
    }
    
    public static final long getMd_theme_light_secondary() {
        return 0L;
    }
    
    public static final long getMd_theme_light_onSecondary() {
        return 0L;
    }
    
    public static final long getMd_theme_light_secondaryContainer() {
        return 0L;
    }
    
    public static final long getMd_theme_light_onSecondaryContainer() {
        return 0L;
    }
    
    public static final long getMd_theme_light_tertiary() {
        return 0L;
    }
    
    public static final long getMd_theme_light_onTertiary() {
        return 0L;
    }
    
    public static final long getMd_theme_light_tertiaryContainer() {
        return 0L;
    }
    
    public static final long getMd_theme_light_onTertiaryContainer() {
        return 0L;
    }
    
    public static final long getMd_theme_light_error() {
        return 0L;
    }
    
    public static final long getMd_theme_light_errorContainer() {
        return 0L;
    }
    
    public static final long getMd_theme_light_onError() {
        return 0L;
    }
    
    public static final long getMd_theme_light_onErrorContainer() {
        return 0L;
    }
    
    public static final long getMd_theme_light_background() {
        return 0L;
    }
    
    public static final long getMd_theme_light_onBackground() {
        return 0L;
    }
    
    public static final long getMd_theme_light_surface() {
        return 0L;
    }
    
    public static final long getMd_theme_light_onSurface() {
        return 0L;
    }
    
    public static final long getMd_theme_light_surfaceVariant() {
        return 0L;
    }
    
    public static final long getMd_theme_light_onSurfaceVariant() {
        return 0L;
    }
    
    public static final long getMd_theme_light_outline() {
        return 0L;
    }
    
    public static final long getMd_theme_light_inverseOnSurface() {
        return 0L;
    }
    
    public static final long getMd_theme_light_inverseSurface() {
        return 0L;
    }
    
    public static final long getMd_theme_light_inversePrimary() {
        return 0L;
    }
    
    public static final long getMd_theme_light_shadow() {
        return 0L;
    }
    
    public static final long getMd_theme_light_surfaceTint() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_primary() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_onPrimary() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_primaryContainer() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_onPrimaryContainer() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_secondary() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_onSecondary() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_secondaryContainer() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_onSecondaryContainer() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_tertiary() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_onTertiary() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_tertiaryContainer() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_onTertiaryContainer() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_error() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_errorContainer() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_onError() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_onErrorContainer() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_background() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_onBackground() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_surface() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_onSurface() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_surfaceVariant() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_onSurfaceVariant() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_outline() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_inverseOnSurface() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_inverseSurface() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_inversePrimary() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_shadow() {
        return 0L;
    }
    
    public static final long getMd_theme_dark_surfaceTint() {
        return 0L;
    }
    
    public static final long getSeed() {
        return 0L;
    }
}