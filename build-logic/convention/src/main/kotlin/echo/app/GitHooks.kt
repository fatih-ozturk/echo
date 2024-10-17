package echo.app

import echo.app.utils.GitHooksTask
import org.gradle.api.Project

internal fun Project.registerPrePushTask() {
    tasks.register("installGitHooks", GitHooksTask::class.java) {
        group = "git-hooks"
        val projectDirectory = rootProject.layout.projectDirectory
        hookSource.set(projectDirectory.file("scripts/pre-commit.sh"))
        hookOutput.set(projectDirectory.file(".git/hooks/pre-commit"))
    }
}
