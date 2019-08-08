package de.tum.www1.artemis.plugin.intellij.vcs.bridge;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import de.tum.www1.artemis.plugin.intellij.vcs.ArtemisGitUtil;
import de.tum.www1.artemis.plugin.intellij.vcs.CredentialsService;

public class ArtemisJSBridge implements ArtemisBridge {
    private final Project myProject;

    public ArtemisJSBridge(Project project) {
        this.myProject = project;
    }

    @Override
    public void clone(String repository, String exerciseName) {
        ArtemisGitUtil.Companion.clone(myProject, repository, exerciseName);
    }

    @Override
    public void login(String username, String password) {
        ServiceManager.getService(CredentialsService.class).storeGitCredentials(username, password);
    }
}