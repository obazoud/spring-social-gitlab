/*
 * Copyright 2015 p.hoeffling.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.gitlab.api.user.impl;

import java.net.URI;
import java.util.List;
import org.springframework.social.gitlab.api.GitlabApiBinding;
import org.springframework.social.gitlab.api.core.impl.AbstractGitlabOperations;
import org.springframework.social.gitlab.api.user.UserKey;
import org.springframework.social.gitlab.api.user.GitlabSSHKeyList;
import org.springframework.social.gitlab.api.user.GitlabUser;
import org.springframework.social.gitlab.api.user.GitlabUserOperations;

public class GitlabUserTemplate extends AbstractGitlabOperations implements GitlabUserOperations {

    public GitlabUserTemplate(GitlabApiBinding gitlabApiBinding) {
        super(gitlabApiBinding);
    }

    
    @Override
    public GitlabUser getCurrentUser() {
        URI uri = gitlabApiBinding.uriBuilder().api().pathSegment("user").build().toUri();
        return gitlabApiBinding.restOperations().getForObject(uri, GitlabUser.class);
    }

    @Override
    public GitlabUser getUser(long userId) {
        URI uri = gitlabApiBinding.uriBuilder().api().pathSegment("users", "{userId}").buildAndExpand(userId).toUri();
        return gitlabApiBinding.restOperations().getForObject(uri, GitlabUser.class);
    }

    @Override
    public List<UserKey> getCurrentUsersSSHKeys() {
        URI uri = gitlabApiBinding.uriBuilder().api().pathSegment("user", "keys").build().toUri();
        return gitlabApiBinding.restOperations().getForObject(uri, GitlabSSHKeyList.class);
    }

    @Override
    public UserKey getCurrentUsersSSHKey(long keyId) {
        URI uri = gitlabApiBinding.uriBuilder().api().pathSegment("user", "keys", "{keyId}").buildAndExpand(keyId).toUri();
        return gitlabApiBinding.restOperations().getForObject(uri, UserKey.class);
    }

    
}
