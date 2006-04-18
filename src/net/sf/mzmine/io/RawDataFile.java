/*
 * Copyright 2006 Okinawa Institute of Science and Technology
 * 
 * This file is part of MZmine.
 * 
 * MZmine is free software; you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * MZmine is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * MZmine; if not, write to the Free Software Foundation, Inc., 51 Franklin St,
 * Fifth Floor, Boston, MA 02110-1301 USA
 */


package net.sf.mzmine.io;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 * Class representing a raw data file, no matter what format it is using.
 * 
 * Data file must be Serializable, because it may be passed as a parameter to remote nodes
 *
 */
public interface RawDataFile extends Serializable {

    public enum PreloadLevel { NO_PRELOAD, PRELOAD_ALL_SCANS };
    
    public File getFileName();
    
    public int getNumOfScans();
    public int[] getMSLevels();
    public int[] getScanNumbers(int msLevel);

    /**
     * This method may parse the RAW data file, therefore it may be quite slow.
     * @param scan Desired can number
     * @return Desired scan
     */
    public Scan getScan(int scan) throws IOException;
   
    public String getDataDescription();

    public double getDataMinMZ();
    public double getDataMaxMZ();
    public double getDataMaxIntensity();
    
    /**
     * @return filename
     */
    public String toString();
        
}
