/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2017, Arnaud Roques
 *
 * Project Info:  http://plantuml.com
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * Original Author:  Arnaud Roques
 * 
 * Revision $Revision: 3834 $
 *
 */
package net.sourceforge.plantuml.graphic;

import net.sourceforge.plantuml.command.regex.Matcher2;
import net.sourceforge.plantuml.command.regex.MyPattern;
import net.sourceforge.plantuml.command.regex.Pattern2;

class SizeChange implements FontChange {

	static private final Pattern2 sizePattern = MyPattern.cmpile("(?i)" + Splitter.fontSizePattern2);

	private final Integer size;

	SizeChange(String s) {
		final Matcher2 matcherSize = sizePattern.matcher(s);
		if (matcherSize.find() == false) {
			throw new IllegalArgumentException();
		}
		size = new Integer(matcherSize.group(1));
	}

	Integer getSize() {
		return size;
	}

	public FontConfiguration apply(FontConfiguration initial) {
		return initial.changeSize(size);
	}

}
