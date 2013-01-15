// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package org.apache.cloudstack.storage.datastore;

import org.apache.cloudstack.engine.subsystem.api.storage.DataStream;
import org.apache.cloudstack.engine.subsystem.api.storage.DataObjectType;
import org.apache.cloudstack.engine.subsystem.api.storage.DataStore;
import org.apache.cloudstack.engine.subsystem.api.storage.DataStoreRole;
import org.apache.cloudstack.engine.subsystem.api.storage.VolumeInfo;
import org.apache.cloudstack.storage.db.ObjectInDataStoreVO;
import org.apache.cloudstack.storage.image.TemplateInfo;
import org.apache.cloudstack.storage.snapshot.SnapshotInfo;
import org.apache.cloudstack.storage.volume.ObjectInDataStoreStateMachine;
import org.apache.cloudstack.storage.volume.ObjectInDataStoreStateMachine.Event;

import com.cloud.utils.fsm.NoTransitionException;

public interface ObjectInDataStoreManager {
    public TemplateInfo create(TemplateInfo template, DataStore dataStore);
    public VolumeInfo create(VolumeInfo volume, DataStore dataStore);
    public SnapshotInfo create(SnapshotInfo snapshot, DataStore dataStore);
    public ObjectInDataStoreVO findObject(long objectId, DataObjectType type,
            long dataStoreId, DataStoreRole role);
    public boolean update(DataStream vo, Event event) throws NoTransitionException;
}
