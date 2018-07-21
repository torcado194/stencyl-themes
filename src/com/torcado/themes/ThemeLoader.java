package com.torcado.themes;

import java.awt.Color;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import stencyl.sw.editors.snippet.designer.block.BlockTheme;




public class ThemeLoader 
{
	
	private static final Logger log = Logger.getLogger(ThemeExtension.class);
	
	public static final Map<String, BlockTheme> DarkFlat = new HashMap();
	
    static
    {
        DarkFlat.put("ORANGE",    new BlockTheme( new Color(127,  36,  65), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat.put("ORANGE2",   new BlockTheme( new Color(101,  33,  56), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat.put("BLUE",      new BlockTheme( new Color( 54,  75, 126), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat.put("LBLUE",     new BlockTheme( new Color( 23,  97, 146), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat.put("GREEN",     new BlockTheme( new Color( 49, 100, 109), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat.put("LIME",      new BlockTheme( new Color( 59,  97,  60), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat.put("PURPLE",    new BlockTheme( new Color(104,  60, 111), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat.put("RED",       new BlockTheme( new Color(170,  66,  64), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat.put("GRAY",      new BlockTheme( new Color( 83,  83,  89), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
        DarkFlat.put("DARK_GRAY", new BlockTheme( new Color( 68,  68,  76), new Color(44, 43, 63), new Color(44, 43, 63), new Color(44, 43, 63) ));
    }
	
	public static void run() throws NoSuchFieldException, IllegalAccessException {
		
		for (Map.Entry<String, BlockTheme> entry : DarkFlat.entrySet()) {
		    String color = entry.getKey();
		    BlockTheme theme = entry.getValue();
		    
		    Field field = BlockTheme.class.getDeclaredField( color );
	        field.setAccessible( true );
	        
	        Field modifiersField = Field.class.getDeclaredField( "modifiers" );
	        modifiersField.setAccessible( true );
	        modifiersField.setInt( field, field.getModifiers() & ~Modifier.FINAL );
	        
	        field.set( null, theme );
		}
		
	}
}



