/*
 * FindBugs - Find Bugs in Java programs
 * Copyright (C) 2006, University of Maryland
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package edu.umd.cs.findbugs.filter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pugh
 */
public abstract class RelationalOp {

	public abstract boolean check(Comparable x, Comparable y);

	final String value;

	private static final Map<String, RelationalOp> map = new HashMap<String, RelationalOp>();
	public static RelationalOp byName(String s) {
		return map.get(s);
	}
	public static Collection<RelationalOp> values() {
		return map.values();
	}
	private RelationalOp(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}

	public static final RelationalOp EQ = new RelationalOp("==") {
		public boolean check(Comparable x, Comparable y) {
			return x.compareTo(y) == 0;
		}

	};

	public static final RelationalOp LEQ = new RelationalOp("<=") {
		public boolean check(Comparable x, Comparable y) {
			return x.compareTo(y) <= 0;
		}

	};

	public static final RelationalOp NEQ = new RelationalOp("!=") {
		public boolean check(Comparable x, Comparable y) {
			return x.compareTo(y) != 0;
		}

	};

	public static final RelationalOp GEQ = new RelationalOp(">=") {
		public boolean check(Comparable x, Comparable y) {
			return x.compareTo(y) >= 0;
		}

	};

	public static final RelationalOp LT = new RelationalOp("<") {
		public boolean check(Comparable x, Comparable y) {
			return x.compareTo(y) < 0;
		}

	};

	public static final RelationalOp GT = new RelationalOp(">") {
		public boolean check(Comparable x, Comparable y) {
			return x.compareTo(y) > 0;
		}

	};

}
