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

import org.apache.jcs.engine.stats.behavior.IStats;

/**
 * Interface for a cache event queue. An event queue is used to propagate
 * ordered cache events to one and only one target listener.
 *  
 */
public interface ICacheEventQueue
{

    /**
     * Does not use a thread pool.
     */
    public static final int SINGLE_QUEUE_TYPE = 0;

    /**
     * Uses a thread pool
     */
    public static final int POOLED_QUEUE_TYPE = 1;

    /**
     * Returnt he type of event queue we are using, either single or pooled.
     * 
     * @return
     */
    public abstract int getQueueType();

    /**
     * Adds a feature to the PutEvent attribute of the ICacheEventQueue object
     * 
     * @param ce
     *            The feature to be added to the PutEvent attribute
     * @throws IOException
     */
    public void addPutEvent( ICacheElement ce )
        throws IOException;

    /**
     * Adds a feature to the RemoveEvent attribute of the ICacheEventQueue
     * object
     * 
     * @param key
     *            The feature to be added to the RemoveEvent attribute
     * @throws IOException
     */
    public void addRemoveEvent( Serializable key )
        throws IOException;

    /**
     * Adds a feature to the RemoveAllEvent attribute of the ICacheEventQueue
     * object
     * @throws IOException
     */
    public void addRemoveAllEvent()
        throws IOException;

    /**
     * Adds a feature to the DisposeEvent attribute of the ICacheEventQueue
     * object
     * @throws IOException
     */
    public void addDisposeEvent()
        throws IOException;

    /**
     * Gets the listenerId attribute of the ICacheEventQueue object
     * 
     * @return The listenerId value
     */
    public long getListenerId();

    /** Description of the Method */
    public void destroy();

    /**
     * Gets the alive attribute of the ICacheEventQueue object. Alive just
     * indicates that there are active threads. This is less important that if
     * the queue is working.
     * 
     * @return The alive value
     */
    public boolean isAlive();

    /**
     * A Queue is working unless it has reached its max failure count.
     * 
     * @return boolean
     */
    public boolean isWorking();

    /**
     * Are there elements in the queue.
     * 
     * @return true if there are stil elements.
     */
    public boolean isEmpty();
    
    /**
     * Returns the historical and statistical data for an event queue cache.
     * 
     * @return
     */
    public IStats getStatistics();
}
