package com.torcado.themes;

import java.awt.Color;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.*;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.polydes.common.res.ResourceLoader;
import com.polydes.common.res.Resources;

import stencyl.sw.editors.snippet.designer.block.BlockTheme;
import stencyl.sw.lnf.Theme;

import com.explodingpixels.macwidgets.plaf.IAppScrollBarArtworkUtils;

public class ThemeLoader 
{

    private static final Logger log = Logger.getLogger(ThemeExtension.class);
    
    private static Resources res = ResourceLoader.getResources("com.torcado.themes");

    public static final Map<String, BlockTheme> DarkFlat_Block = new HashMap();
    public static final Map<String, Color> DarkFlat_Main = new HashMap();
    public static final Map<String, String> DarkFlat_Scroll = new HashMap();
    
    public static final Map<String, BlockTheme> DarkNeon_Block = new HashMap();
    public static final Map<String, Color> DarkNeon_Main = new HashMap();
    
    public static final Map<String, BlockTheme> Default_Block = new HashMap();
    public static final Map<String, Color> Default_Main = new HashMap();
    
    public static final Map<String, Color> DefaultGrayBG_Main = new HashMap();

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
        DarkFlat_Block.put("GRAY",      new BlockTheme( new Color( 87,  87, 107), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat_Block.put("DARK_GRAY", new BlockTheme( new Color(106, 106, 124), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat_Block.put("L_GRAY",    new BlockTheme( new Color( 66,  66,  79), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        
        DarkFlat_Main.put("TEXT_COLOR",             new Color(255, 255, 255)); // main text, not block text
        DarkFlat_Main.put("APP_COLOR",              new Color( 72,  64,  94)); // border in code editor view
        DarkFlat_Main.put("APP_COLOR2",             new Color(111, 111, 111)); // text in palette headers
        DarkFlat_Main.put("ROUNDED_LABEL_COLOR",    new Color(124, 123, 153)); // on popups, not in palette
        DarkFlat_Main.put("BORDER_COLOR",           new Color( 23,  22,  33)); // popups, and single pixel around most window sections
        DarkFlat_Main.put("BG_COLOR",               new Color( 72,  64,  94)); // events list background, behavior icon background
        DarkFlat_Main.put("INPUT_COLOR",            new Color(225, 225, 225)); // input background (i could only find this behind the Font and Style dropdowns on the font window)
        DarkFlat_Main.put("NEUTRAL_BG_COLOR",       new Color( 44,  43,  63)); // ?
        DarkFlat_Main.put("NEUTRAL_BG_COLOR2",      new Color(255,   0, 255)); // -- ?
        DarkFlat_Main.put("LIGHT_BG_COLOR",         new Color( 71,  70, 102)); // design mode background
        DarkFlat_Main.put("LIGHT_BG_COLOR2",        new Color(109, 108, 142)); // attribute property background
        DarkFlat_Main.put("LIGHT_BG_COLOR3",        new Color( 71,  70, 102)); // settings page backgrounds, font properties background
        DarkFlat_Main.put("EDITOR_BG_COLOR",        new Color( 44,  43,  63)); // background on dashboard behind items, and side panel in scene designer
        DarkFlat_Main.put("DARK_BG_COLOR",          new Color( 72,  64,  94)); // scene inspector background
        DarkFlat_Main.put("LIGHT_BUTTON_BAR_START", new Color(109, 108, 142)); // settings page tab backgrounds, font tabs background 
        DarkFlat_Main.put("LIGHT_BUTTON_BAR_END",   new Color(109, 108, 142)); // ^
        DarkFlat_Main.put("BUTTON_BAR_START",       new Color( 71,  70, 102)); // tabs, main bottom bar, bottom bar on dialog popup
        DarkFlat_Main.put("BUTTON_BAR_END",         new Color( 71,  70, 102)); // ^
        DarkFlat_Main.put("COMMAND_BAR_START",      new Color(109, 108, 142)); // behind behavior name and "add to _"
        DarkFlat_Main.put("COMMAND_BAR_MID",        new Color(109, 108, 142)); // ^
        DarkFlat_Main.put("COMMAND_BAR_END",        new Color(109, 108, 142)); // ^
        DarkFlat_Main.put("TAB_START",              new Color( 72,  64,  94)); // selected tab in scene editor panels
        DarkFlat_Main.put("TAB_END",                new Color( 72,  64,  94)); // ^
        DarkFlat_Main.put("DIALOG_BORDER",          new Color( 44,  43,  63)); // single pixel on left/right of popup
        DarkFlat_Main.put("RED_START",              new Color(178,  66,  66)); // "delete/remove" button background
        DarkFlat_Main.put("RED_END",                new Color(178,  66,  66)); // ^
        DarkFlat_Main.put("GREEN_START",            new Color(100,  98, 142)); // button color for "create new _"
        DarkFlat_Main.put("GREEN_END",              new Color(100,  98, 142)); // ^
        
        //DarkFlat_Scroll.put("h_scroller.png", Paths.get("com/torcado/themes/res/h_scroller.png"));
        //DarkFlat_Scroll.put("V_SCROLLERS", "/com/torcado/themes/res/v_scroller.png");
        
        
        DarkNeon_Block.put("ORANGE",    new BlockTheme(new Color(94, 43, 67), new Color(170, 41, 77), new Color(170, 41, 77), new Color(170, 41, 77) ));
        DarkNeon_Block.put("ORANGE2",   new BlockTheme(new Color(79, 39, 60), new Color(137, 31, 63), new Color(137, 31, 63), new Color(137, 31, 63) ));
        DarkNeon_Block.put("BLUE",      new BlockTheme(new Color(55, 68, 107), new Color(91, 116, 229), new Color(91, 116, 229), new Color(91, 116, 229) ));
        DarkNeon_Block.put("LBLUE",     new BlockTheme(new Color(37, 84, 122), new Color(3, 146, 186), new Color(3, 146, 186), new Color(3, 146, 186) ));
        DarkNeon_Block.put("GREEN",     new BlockTheme(new Color(51, 84, 86), new Color(29, 137, 118), new Color(29, 137, 118), new Color(29, 137, 118) ));
        DarkNeon_Block.put("LIME",      new BlockTheme(new Color(51, 86, 66), new Color(59, 153, 67), new Color(59, 153, 67), new Color(59, 153, 67) ));
        DarkNeon_Block.put("PURPLE",    new BlockTheme(new Color(86, 59, 97), new Color(174, 78, 196), new Color(174, 78, 196), new Color(174, 78, 196) ));
        DarkNeon_Block.put("RED",       new BlockTheme(new Color(130, 61, 66), new Color(229, 86, 64), new Color(229, 86, 64), new Color(229, 86, 64) ));
        DarkNeon_Block.put("GRAY",      new BlockTheme(new Color(85, 85, 104), new Color(125, 125, 165), new Color(125, 125, 165), new Color(125, 125, 165) ));
        DarkNeon_Block.put("DARK_GRAY", new BlockTheme(new Color(96, 86, 122), new Color(141, 141, 188), new Color(141, 141, 188), new Color(141, 141, 188) ));
        DarkNeon_Block.put("LGRAY",    new BlockTheme(new Color(66,  66,  79), new Color(103, 103, 132), new Color(103, 103, 132), new Color(103, 103, 132) ));
        
        
        Default_Block.put("ORANGE",    new BlockTheme( new Color(200, 140, 55), new Color(150, 100, 60), new Color(210, 150, 65), new Color(220, 160, 75) ));
        Default_Block.put("ORANGE2",   new BlockTheme( new Color(180, 126, 50), new Color(135, 90, 54), new Color(189, 135, 59), new Color(198, 144, 68) ));
        Default_Block.put("BLUE",      new BlockTheme( new Color(74, 108, 150), new Color(52, 76, 148), new Color(114, 145, 180), new Color(80, 118, 180) ));
        Default_Block.put("LBLUE",     new BlockTheme( new Color(4, 128, 200), new Color(3, 98, 156), new Color(38, 163, 235), new Color(4, 138, 215) ));
        Default_Block.put("GREEN",     new BlockTheme( new Color(50, 131, 90), new Color(50, 92, 64), new Color(54, 156, 116), new Color(50, 149, 104) ));
        Default_Block.put("LIME",      new BlockTheme( new Color(116, 140, 81), new Color(78, 100, 15), new Color(116, 160, 74), new Color(116, 160, 51) ));
        Default_Block.put("PURPLE",    new BlockTheme( new Color(137, 74, 137), new Color(95, 51, 102), new Color(154, 114, 153), new Color(134, 80, 145) ));
        Default_Block.put("RED",       new BlockTheme( new Color(187, 74, 97), new Color(135, 51, 60), new Color(214, 114, 90), new Color(194, 80, 90) ));
        Default_Block.put("GRAY",      new BlockTheme( new Color(100, 100, 100), new Color(81, 81, 81), new Color(120, 120, 120), new Color(130, 130, 130) ));
        Default_Block.put("DARK_GRAY", new BlockTheme( new Color(110, 110, 110).darker(), new Color(89, 89, 89).darker(), new Color(132, 132, 132).darker(), new Color(143, 143, 143).darker() ));

        Default_Main.put("TEXT_COLOR",             Color.WHITE);
        Default_Main.put("APP_COLOR",              Color.GRAY);
        Default_Main.put("APP_COLOR2",             new Color(111, 111, 111));
        Default_Main.put("ROUNDED_LABEL_COLOR",    Color.GRAY);
        Default_Main.put("BORDER_COLOR",           new Color(45, 45, 45));
        Default_Main.put("BG_COLOR",               Color.DARK_GRAY);
        Default_Main.put("INPUT_COLOR",            Color.LIGHT_GRAY);
        Default_Main.put("NEUTRAL_BG_COLOR",       new Color(135, 132, 122));
        Default_Main.put("NEUTRAL_BG_COLOR2",      new Color(119, 119, 110));
        Default_Main.put("LIGHT_BG_COLOR",         new Color(92, 92, 92));
        Default_Main.put("LIGHT_BG_COLOR2",        new Color(98, 98, 92));
        Default_Main.put("LIGHT_BG_COLOR3",        new Color(78, 78, 80));
        Default_Main.put("EDITOR_BG_COLOR",        new Color(64, 64, 74));
        Default_Main.put("DARK_BG_COLOR",          new Color(68, 68, 68));
        Default_Main.put("LIGHT_BUTTON_BAR_START", new Color(227, 227, 227));
        Default_Main.put("LIGHT_BUTTON_BAR_END",   new Color(171, 171, 171));
        Default_Main.put("BUTTON_BAR_START",       new Color(207, 207, 207));
        Default_Main.put("BUTTON_BAR_END",         new Color(141, 141, 141));
        Default_Main.put("COMMAND_BAR_START",      new Color(65, 65, 65));
        Default_Main.put("COMMAND_BAR_MID",        new Color(50, 50, 50));
        Default_Main.put("COMMAND_BAR_END",        new Color(40, 40, 40));
        Default_Main.put("TAB_START",              new Color(187, 197, 217));
        Default_Main.put("TAB_END",                new Color(141, 161, 181));
        Default_Main.put("DIALOG_BORDER",          new Color(80, 80, 80));
        Default_Main.put("RED_START",              new Color(150, 70, 70));
        Default_Main.put("RED_END",                new Color(150, 70, 70).darker().darker());
        Default_Main.put("GREEN_START",            new Color(70, 120, 70));
        Default_Main.put("GREEN_END",              new Color(70, 120, 70).darker().darker());
        
        
        DefaultGrayBG_Main.put("TEXT_COLOR",             Color.WHITE);
        DefaultGrayBG_Main.put("APP_COLOR",              Color.GRAY);
        DefaultGrayBG_Main.put("APP_COLOR2",             new Color(111, 111, 111));
        DefaultGrayBG_Main.put("ROUNDED_LABEL_COLOR",    Color.GRAY);
        DefaultGrayBG_Main.put("BORDER_COLOR",           new Color(45, 45, 45));
        DefaultGrayBG_Main.put("BG_COLOR",               Color.DARK_GRAY);
        DefaultGrayBG_Main.put("INPUT_COLOR",            Color.LIGHT_GRAY);
        DefaultGrayBG_Main.put("NEUTRAL_BG_COLOR",       new Color(128, 128, 128));
        DefaultGrayBG_Main.put("NEUTRAL_BG_COLOR2",      new Color(119, 119, 110));
        DefaultGrayBG_Main.put("LIGHT_BG_COLOR",         new Color(92, 92, 92));
        DefaultGrayBG_Main.put("LIGHT_BG_COLOR2",        new Color(98, 98, 92));
        DefaultGrayBG_Main.put("LIGHT_BG_COLOR3",        new Color(78, 78, 80));
        DefaultGrayBG_Main.put("EDITOR_BG_COLOR",        new Color(64, 64, 74));
        DefaultGrayBG_Main.put("DARK_BG_COLOR",          new Color(68, 68, 68));
        DefaultGrayBG_Main.put("LIGHT_BUTTON_BAR_START", new Color(227, 227, 227));
        DefaultGrayBG_Main.put("LIGHT_BUTTON_BAR_END",   new Color(171, 171, 171));
        DefaultGrayBG_Main.put("BUTTON_BAR_START",       new Color(207, 207, 207));
        DefaultGrayBG_Main.put("BUTTON_BAR_END",         new Color(141, 141, 141));
        DefaultGrayBG_Main.put("COMMAND_BAR_START",      new Color(65, 65, 65));
        DefaultGrayBG_Main.put("COMMAND_BAR_MID",        new Color(50, 50, 50));
        DefaultGrayBG_Main.put("COMMAND_BAR_END",        new Color(40, 40, 40));
        DefaultGrayBG_Main.put("TAB_START",              new Color(187, 197, 217));
        DefaultGrayBG_Main.put("TAB_END",                new Color(141, 161, 181));
        DefaultGrayBG_Main.put("DIALOG_BORDER",          new Color(80, 80, 80));
        DefaultGrayBG_Main.put("RED_START",              new Color(150, 70, 70));
        DefaultGrayBG_Main.put("RED_END",                new Color(150, 70, 70).darker().darker());
        DefaultGrayBG_Main.put("GREEN_START",            new Color(70, 120, 70));
        DefaultGrayBG_Main.put("GREEN_END",              new Color(70, 120, 70).darker().darker());
    }

    public static void run(String ThemeName) throws NoSuchFieldException, IllegalAccessException {
    	
    	Map<String, BlockTheme> block = null;
    	Map<String, Color> main = null;
    	
    	if(ThemeName.equals("DarkFlat")) {
    		block = DarkFlat_Block;
    		main = DarkFlat_Main;
    	} else if(ThemeName.equals("DarkNeon")){
    		block = DarkNeon_Block;
    		main = DarkFlat_Main;
    	} else if(ThemeName.equals("Default_GrayBG")){
    		block = Default_Block;
    		main = DefaultGrayBG_Main;
    	} else {
    		block = Default_Block;
    		main = Default_Main;
    	}

        for (Map.Entry<String, BlockTheme> entry : block.entrySet()) {
            String color = entry.getKey();
            BlockTheme theme = entry.getValue();
            
            Field field;
            try {
            	field = BlockTheme.class.getDeclaredField( color );
            } catch (NoSuchFieldException e) {
                continue;
            }
            
            field.setAccessible( true );

            Field modifiersField = Field.class.getDeclaredField( "modifiers" );
            modifiersField.setAccessible( true );
            modifiersField.setInt( field, field.getModifiers() & ~Modifier.FINAL );

            field.set( null, theme );
        }

        for (Map.Entry<String, Color> entry : main.entrySet()) {
            String color = entry.getKey();
            Color theme = entry.getValue();

            Field field;
            try {
            	field = Theme.class.getDeclaredField( color );
            } catch (NoSuchFieldException e) {
                continue;
            }
            
            field.setAccessible( true );

            Field modifiersField = Field.class.getDeclaredField( "modifiers" );
            modifiersField.setAccessible( true );
            modifiersField.setInt( field, field.getModifiers() & ~Modifier.FINAL );

            field.set( null, theme );
        }
        
       /* URL url = ThemeLoader.class.getResource("/com/torcado/themes/res/v_scroller.png");
        
        log.info(url);
        
        for (Map.Entry<String, String> entry : DarkFlat_Scroll.entrySet()) {
            String name = entry.getKey();
            String path = entry.getValue();

            Field field = IAppScrollBarArtworkUtils.class.getDeclaredField( name );
            field.setAccessible( true );

            Field modifiersField = Field.class.getDeclaredField( "modifiers" );
            modifiersField.setAccessible( true );
            modifiersField.setInt( field, field.getModifiers() & ~Modifier.FINAL );

            field.set( null, path );
        }*/

    }
}



