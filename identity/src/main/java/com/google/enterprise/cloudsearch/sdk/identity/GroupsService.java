/*
 * Copyright © 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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
package com.google.enterprise.cloudsearch.sdk.identity;

import com.google.api.services.cloudidentity.v1beta1.model.Group;
import com.google.api.services.cloudidentity.v1beta1.model.Membership;
import com.google.api.services.cloudidentity.v1beta1.model.Operation;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Service;
import java.io.IOException;

/** Wrapper for making Groups API Calls */
interface GroupsService extends Service {
  ListenableFuture<Operation> createGroup(Group group) throws IOException;

  ListenableFuture<Group> getGroup(String groupId) throws IOException;

  ListenableFuture<Operation> deleteGroup(String groupId) throws IOException;

  ListenableFuture<Operation> createMembership(String groupId, Membership member)
      throws IOException;

  ListenableFuture<Membership> getMembership(String memberId) throws IOException;

  ListenableFuture<Operation> deleteMembership(String memberId) throws IOException;

  Iterable<Group> listGroups(String groupNamespace) throws IOException;

  Iterable<Membership> listMembers(String groupId) throws IOException;
}