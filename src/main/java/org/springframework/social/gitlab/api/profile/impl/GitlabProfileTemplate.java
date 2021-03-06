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
package org.springframework.social.gitlab.api.profile.impl;

import java.net.URI;
import org.springframework.social.gitlab.api.GitlabApiBinding;
import org.springframework.social.gitlab.api.core.impl.AbstractGitlabOperations;
import org.springframework.social.gitlab.api.profile.GitlabProfile;
import org.springframework.social.gitlab.api.profile.GitlabProfileOperations;

/**
 *
 * @author p.hoeffling
 */
public class GitlabProfileTemplate extends AbstractGitlabOperations implements GitlabProfileOperations {

    public GitlabProfileTemplate(GitlabApiBinding gitlabApiBinding) {
        super(gitlabApiBinding);
    }

    @Override
    public GitlabProfile getProfile() {
        URI uri = gitlabApiBinding.uriBuilder().api().pathSegment("user").build().toUri();
        return gitlabApiBinding.restOperations().getForObject(uri, GitlabProfile.class);
    }

}
