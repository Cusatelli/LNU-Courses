# 2DV609-Habbit-tracker

## Table of Contents
- [Important to remember when working with Git](#important-to-remember-when-working-with-git)
- [Quick Set-up Guide](#quick-set-up-guide-to-intellij--github)
- [Working with branches](#working-with-branches)
- [Resources](#resources)

## Important to remember when working with Git
1. Always "Pull" from the master branch before starting your workday.

2. Always "Add" -> "Commit" -> "Push" to the respective branch before the end of your workday.
<br>When Committing be as specific as possible and make multiple commits of your work for 
<br>better tracking later if any unforeseen problems arise. <b>Preferably</b> at least one message for each file added.

3. Always check the git repository before making major changes to files other people work on and check with them if they have pushed their progress. (This is to avoid merge-conflicts).

4. Only work in your designated files/branch unless agreed otherwise.

5. Update in Slack and Trello when you are starting or finishing a task.
   <br><b>Link to Trello</b>: https://trello.com

## Quick Set-up guide to IntelliJ & Github
* Download and Install IntelliJ: https://www.jetbrains.com/idea/download/#section=mac
1. Download the educational version. It's free when using your LNU account.
2. Accept invitation to Github Repository from Ali.
3. Connect IntelliJ to the Github repository: https://www.jetbrains.com/help/idea/github.html# 
4. File -> New -> Project from Version Control.
5. Select Github/your username.
````
    if your github doesnt show up try:
    Copy-Paste either SSH or HTTPS link:
          SSH: git@github.com:username/Repository.git
          or
          HTTPS: https://github.com/username/Repository.git
````
6. Then select: "2DV609-Habbit-tracker".
7. Change your directory and/or click "Clone".
* Now you should have the latest version of the Github repo inside your IntelliJ project.

## Working with branches:
* Once inside your IntelliJ project:
1. Create an empty directory called "test".
2. Right click on the directory and select "Git" -> "+ Add".
3. Then go to the top right corner of the screen where it says "git: :arrow_lower_left: :white_check_mark:" (icons look slightly different). and click on the :white_check_mark: checkmark which stands for "commit".
4. If any additional files need to be added for this commit , add those files now before you write your commit message.
5. Then type in your commit message. For example: "Created Test Directory."
6. Click "Commit".
7. Then right click on your project directory (top folder in hierarchy).
8. Select "Git" -> "Repository" -> ":arrow_upper_right: Push..." .
9. Wait until the push is complete and navigate to: https://github.com/username/Repository
10. Merge your commit to the approriate branch. For example T1.
* Now you have made your first commit using IntelliJ & Github branches.

## Resources
* Version & Source Control
<br>[Trello](https://trello.com)

* Getting Started: 
<br>[IntelliJ Guide](https://www.jetbrains.com/help/idea/getting-started.html)
<br>[IntelliJ & Github Guide](https://www.jetbrains.com/help/idea/github.html#)
<br>[ReactJs Guide](https://reactjs.org/docs/getting-started.html)

