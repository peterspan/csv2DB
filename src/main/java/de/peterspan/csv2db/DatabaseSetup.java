/**
 *  Copyright 2012-2013 Frederik Hahne, Christoph Stiehm
 *
 * 	This file is part of csv2db.
 *
 *  csv2db is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  csv2db is distributed in the hope that it will be useful,
 * 	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with csv2db.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.peterspan.csv2db;

import java.sql.Connection;

public class DatabaseSetup {

	
	public static void setup(Connection con){
		try{
			
		}catch(Exception e){
			System.out.println("Exception during setup "+e+" "+e.getStackTrace());
		}
		
	}
}
