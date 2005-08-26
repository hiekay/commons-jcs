package org.apache.jcs.engine.behavior;

/*
 * Copyright 2001-2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.IOException;
import java.io.Serializable;

/**
 * This is the top level interface for all cache like structures. It defines the
 * methods used internally by JCS to access, modify, and instrument such
 * structures. This allows for a suite of reusable components for accessing such
 * structures, for example asynchronous access via an event queue.
 * 
 * @version $Id$
 */
public interface ICache
    extends ICacheType
{
    /** Puts an item to the cache. 
     * @param ce
     * @throws IOException*/
    public void update( ICacheElement ce )
        throws IOException;

    /** Gets an item from the cache. 
     * @param key
     * @return
     * @throws IOException*/
    public ICacheElement get( Serializable key )
        throws IOException;

    /** Removes an item from the cache. 
     * @param key
     * @return
     * @throws IOException*/
    public boolean remove( Serializable key )
        throws IOException;

    /** Removes all cached items from the cache. 
     * @throws IOException*/
    public void removeAll()
        throws IOException;

    /** Prepares for shutdown. 
     * @throws IOException*/
    public void dispose()
        throws IOException;

    /** Returns the current cache size. 
     * @return*/
    public int getSize();

    /** Returns the cache status. 
     * @return*/
    public int getStatus();

    /** Returns the cache stats. 
     * @return*/
    public String getStats();

    /** Returns the cache name. 
     * @return*/
    public String getCacheName();
}
