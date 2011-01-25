/*
 * SICCI for Xcode - Hudson Plugin for Xcode projects
 * 
 * Copyright (C) 2011 Benedikt Biallowons, SIC! Software GmbH
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package com.sic.bb.hudson.plugins.xcodeplugin.util;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class PluginUtils {
	//private static final String[] REGEXSPECIALCHARS = new String[] {"(",")","{","}","[","]","^","$","*",".","?","|"};

	public static String stringToRegex(String string) {
        /*for(String regexChar: REGEXSPECIALCHARS)
        	string = string.replace(regexChar, "\\" + regexChar);
        
        return string;*/
		
		return Pattern.quote(string);
	}
	
	public static Pattern createPattern(List<String> stringList) {
	    StringBuilder regex = new StringBuilder();
	    
	    if(stringList != null) {
	      regex.append('(');
	      
	      for(String item: stringList) {
	        if(StringUtils.isBlank(item))
	          continue;
	        
	        regex.append(stringToRegex(item));
	        regex.append('|');
	      }
	      
	      regex.deleteCharAt(regex.length() - 1);
	      regex.append(')');
	    }
	    
	    return Pattern.compile(regex.toString());
	}
}
