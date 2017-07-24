/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.zookeeper.server.quorum.flexible;

import java.util.Set;
import java.util.Map;

import org.apache.zookeeper.server.quorum.QuorumPeer.QuorumServer;

/**
 * All quorum validators have to implement a method called
 * containsQuorum, which verifies if a HashSet of server 
 * identifiers constitutes a quorum.
 *
 */
// 集群节点信息
public interface QuorumVerifier {
    long getWeight(long id);

    /**
     * 校验set的所有成员能否构成一个法定人数（合理投票）
     * @param set
     * @return
     */
    boolean containsQuorum(Set<Long> set);
    long getVersion();
    void setVersion(long ver);

    /**
     * 所有成员
     * @return
     */
    Map<Long, QuorumServer> getAllMembers();

    /**
     * 所有投票成员
     * @return
     */
    Map<Long, QuorumServer> getVotingMembers();

    /**
     * 观察者
     * @return
     */
    Map<Long, QuorumServer> getObservingMembers();
    boolean equals(Object o);
    String toString();
}
