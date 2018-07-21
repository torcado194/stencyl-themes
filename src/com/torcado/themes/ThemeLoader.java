package com.torcado.themes;

import java.awt.Color;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import stencyl.sw.editors.snippet.designer.block.BlockTheme;
import stencyl.sw.lnf.Theme;

public class ThemeLoader 
{

    private static final Logger log = Logger.getLogger(ThemeExtension.class);

    public static final Map<String, BlockTheme> DarkFlat_Block = new HashMap();
    public static final Map<String, Color> DarkFlat_Main = new HashMap();

    static
    {
        DarkFlat_Block.put("ORANGE",    new BlockTheme( new Color(127,  36,  65), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat_Block.put("ORANGE2",   new BlockTheme( new Color(101,  33,  56), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat_Block.put("BLUE",      new BlockTheme( new Color( 54,  75, 126), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat_Block.put("LBLUE",     new BlockTheme( new Color( 23,  97, 146), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat_Block.put("GREEN",     new BlockTheme( new Color( 49, 100, 109), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat_Block.put("LIME",      new BlockTheme( new Color( 59,  97,  60), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat_Block.put("PURPLE",    new BlockTheme( new Color(104,  60, 111), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat_Block.put("RED",       new BlockTheme( new Color(170,  66,  64), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat_Block.put("GRAY",      new BlockTheme( new Color( 83,  83,  89), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat_Block.put("DARK_GRAY", new BlockTheme( new Color( 68,  68,  76), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));

        DarkFlat_Main.put("TEXT_COLOR",             new Color(255, 0, 0));
        DarkFlat_Main.put("APP_COLOR",              new Color(255, 128, 0));
        DarkFlat_Main.put("APP_COLOR2",             new Color(255, 0, 128));
        DarkFlat_Main.put("ROUNDED_LABEL_COLOR",    new Color(255, 128, 128));
        DarkFlat_Main.put("BORDER_COLOR",           new Color(128, 0, 0));
        DarkFlat_Main.put("BG_COLOR",               new Color(128, 128, 0));
        DarkFlat_Main.put("INPUT_COLOR",            new Color(128, 0, 128));
        DarkFlat_Main.put("NEUTRAL_BG_COLOR",       new Color(44, 43, 63));
        DarkFlat_Main.put("NEUTRAL_BG_COLOR2",      new Color(255, 0, 255));
        DarkFlat_Main.put("LIGHT_BG_COLOR",         new Color(0, 0, 255));
        DarkFlat_Main.put("LIGHT_BG_COLOR2",        new Color(0, 255, 0));
        DarkFlat_Main.put("LIGHT_BG_COLOR3",        new Color(0, 255, 255));
        DarkFlat_Main.put("EDITOR_BG_COLOR",        new Color(0, 0, 128));
        DarkFlat_Main.put("DARK_BG_COLOR",          new Color(0, 128, 0));
        DarkFlat_Main.put("LIGHT_BUTTON_BAR_START", new Color(0, 128, 255));
        DarkFlat_Main.put("LIGHT_BUTTON_BAR_END",   new Color(0, 50, 0));
        DarkFlat_Main.put("BUTTON_BAR_START",       new Color(0, 128, 50));
        DarkFlat_Main.put("BUTTON_BAR_END",         new Color(50, 128, 0));
        DarkFlat_Main.put("COMMAND_BAR_START",      new Color(50, 128, 50));
        DarkFlat_Main.put("COMMAND_BAR_MID",        new Color(0, 50, 0));
        DarkFlat_Main.put("COMMAND_BAR_END",        new Color(0, 50, 50));
        DarkFlat_Main.put("TAB_START",              new Color(50, 80, 50));
        DarkFlat_Main.put("TAB_END",                new Color(0, 80, 0));
        DarkFlat_Main.put("DIALOG_BORDER",          new Color(80, 80, 128));
        DarkFlat_Main.put("RED_START",              new Color(128, 80, 0));
        DarkFlat_Main.put("RED_END",                new Color(80, 128, 0));
        DarkFlat_Main.put("GREEN_START",            new Color(0, 128, 200));
        DarkFlat_Main.put("GREEN_END",              new Color(80, 128, 50));
    }

    public static void run() throws NoSuchFieldException, IllegalAccessException {

        for (Map.Entry<String, BlockTheme> entry : DarkFlat_Block.entrySet()) {
            String color = entry.getKey();
            BlockTheme theme = entry.getValue();

            Field field = BlockTheme.class.getDeclaredField( color );
            field.setAccessible( true );

            Field modifiersField = Field.class.getDeclaredField( "modifiers" );
            modifiersField.setAccessible( true );
            modifiersField.setInt( field, field.getModifiers() & ~Modifier.FINAL );

            field.set( null, theme );
        }
        
        for (Map.Entry<String, Color> entry : DarkFlat_Main.entrySet()) {
            String color = entry.getKey();
            Color theme = entry.getValue();

            Field field = Theme.class.getDeclaredField( color );
            field.setAccessible( true );

            Field modifiersField = Field.class.getDeclaredField( "modifiers" );
            modifiersField.setAccessible( true );
            modifiersField.setInt( field, field.getModifiers() & ~Modifier.FINAL );

            field.set( null, theme );
        }

    }
}



