/**
 * @copyright
 * ====================================================================
 *    Licensed to the Apache Software Foundation (ASF) under one
 *    or more contributor license agreements.  See the NOTICE file
 *    distributed with this work for additional information
 *    regarding copyright ownership.  The ASF licenses this file
 *    to you under the Apache License, Version 2.0 (the
 *    "License"); you may not use this file except in compliance
 *    with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing,
 *    software distributed under the License is distributed on an
 *    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *    KIND, either express or implied.  See the License for the
 *    specific language governing permissions and limitations
 *    under the License.
 * ====================================================================
 * @endcopyright
 */

package org.apache.subversion.javahl;

import org.apache.subversion.javahl.types.*;
import org.apache.subversion.javahl.callback.*;

import java.util.Date;
import java.util.Map;

/**
 * Encapsulates an RA session object and related operations.
 * @see subversion/include/svn_ra.h#svn_ra_open
 * @since 1.9
 */
public interface ISVNRemote
{
    /**
     * Release the native peer (should not depend on finalize).
     * Also invalidates any existing editors related to this session.
     */
    public void dispose();

    /**
     * @return latest revision
     */
    public long getLatestRevision();
    
    /**
     * @return repository UUID
     */
    public String getUUID();
    
    /**
     * @return parent url for this session
     */
    public String getUrl();
    
    /**
     * @param date
     *            The date
     * @return The latest revision at date
     */
    public long getDatedRevision(Date date) throws SubversionException;
    
    /**
     * @param timestamp (in nano seconds) used as a cutoff time 
     * @return the latest revision at that moment
     */
    public long getDatedRevision(long timestamp) throws SubversionException;

    public Map<String, Lock> getLocks(String path, Depth depth)
            throws SubversionException;

    public NodeKind checkPath(String path, Revision revision)
            throws SubversionException;
}