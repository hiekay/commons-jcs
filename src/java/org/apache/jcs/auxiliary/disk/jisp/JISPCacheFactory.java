package org.apache.jcs.auxiliary.disk.jisp;

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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.jcs.auxiliary.AuxiliaryCache;
import org.apache.jcs.auxiliary.AuxiliaryCacheAttributes;
import org.apache.jcs.auxiliary.AuxiliaryCacheFactory;
import org.apache.jcs.engine.behavior.ICompositeCacheManager;

/**
 * @version 1.0
 */

public class JISPCacheFactory
    implements AuxiliaryCacheFactory
{
    private final static Log log = LogFactory.getLog( JISPCacheFactory.class );

    private String name;

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.jcs.auxiliary.AuxiliaryCacheFactory#createCache(org.apache.jcs.auxiliary.AuxiliaryCacheAttributes,
     *      org.apache.jcs.engine.behavior.ICompositeCacheManager)
     */
    public AuxiliaryCache createCache( AuxiliaryCacheAttributes iaca, ICompositeCacheManager cacheMgr )
    {
        JISPCacheAttributes idca = (JISPCacheAttributes) iaca;
        JISPCacheManager dcm = JISPCacheManager.getInstance( idca );
        
        if ( log.isDebugEnabled() )
        {
            log.debug( "Created JISP, " + dcm );
        }
        
        return dcm.getCache( idca );
    }

    /**
     * Gets the name attribute of the JISPCacheFactory object
     * 
     * @return The name value
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Sets the name attribute of the JISPCacheFactory object
     * 
     * @param name
     *            The new name value
     */
    public void setName( String name )
    {
        this.name = name;
    }
}
