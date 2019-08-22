toggleAnalytics = function( ) {
    $(document).ready(function () {
            getContent();
            function getContent() {
                $('#analytics').load("/analytics");
            }
        })
    $(document).ready(function () {
        $('#gitlab').hide();
        $('#mattermost').hide();
        $('#sonar').hide();
        $('#rundeck').hide();
        $('#jenkins').hide();
        $('#jira').hide();
        $('#confluence').hide();
        $('#noService').hide();
        $('#analytics').show();
    });
};
toggleConfluence = function( ) {
    $(document).ready(function () {
            getContent();
            function getContent() {
                $('#confluence').load("/confluence");
            }
        })
    $(document).ready(function () {
        $('#gitlab').hide();
        $('#mattermost').hide();
        $('#sonar').hide();
        $('#rundeck').hide();
        $('#jenkins').hide();
        $('#jira').hide();
        $('#confluence').show();
        $('#noService').hide();
        $('#analytics').hide();
    });
};
toggleGitlab = function( ) {
    $(document).ready(function () {
            getContent();
            function getContent() {
                $('#gitlab').load("/project");
            }
        })
    $(document).ready(function () {
        $('#gitlab').show();
        $('#mattermost').hide();
        $('#sonar').hide();
        $('#rundeck').hide();
        $('#jenkins').hide();
        $('#jira').hide();
        $('#confluence').hide();
        $('#noService').hide();
        $('#analytics').hide();
    });
};
toggleJenkins = function( ) {
    $(document).ready(function () {
            getContent();
            function getContent() {
                $('#jenkins').load("/jenkins");
            }
        })
    $(document).ready(function () {
        $('#gitlab').hide();
        $('#mattermost').hide();
        $('#sonar').hide();
        $('#rundeck').hide();
        $('#jenkins').show();
        $('#jira').hide();
        $('#confluence').hide();
        $('#noService').hide();
        $('#analytics').hide();
    });
};
toggleJira = function( ) {
    $(document).ready(function () {
            getContent();
            function getContent() {
                $('#jira').load("/jira");
            }
        })
    $(document).ready(function () {
        $('#gitlab').hide();
        $('#mattermost').hide();
        $('#sonar').hide();
        $('#rundeck').hide();
        $('#jenkins').hide();
        $('#jira').show();
        $('#confluence').hide();
        $('#noService').hide();
        $('#analytics').hide();
    });
};
toggleMattermost = function( ) {
    $(document).ready(function () {
            getContent();
            function getContent() {
                $('#mattermost').load("/MattermostUser");
            }
        })
    $(document).ready(function () {
        $('#gitlab').hide();
        $('#mattermost').show();
        $('#sonar').hide();
        $('#rundeck').hide();
        $('#jenkins').hide();
        $('#jira').hide();
        $('#confluence').hide();
        $('#noService').hide();
        $('#analytics').hide();
    });
};
toggleNoService = function( ) {
    $(document).ready(function () {
            getContent();
            function getContent() {
                $('#noService').load("/noService");
            }
        })
    $(document).ready(function () {
        $('#gitlab').hide();
        $('#mattermost').hide();
        $('#sonar').hide();
        $('#rundeck').hide();
        $('#jenkins').hide();
        $('#jira').hide();
        $('#confluence').hide();
        $('#noService').show();
        $('#analytics').hide();
    });
};
toggleRundeck = function( ) {
    $(document).ready(function () {
            getContent();
            function getContent() {
                $('#rundeck').load("/rundeck");
            }
        })
    $(document).ready(function () {
        $('#gitlab').hide();
        $('#mattermost').hide();
        $('#sonar').hide();
        $('#rundeck').show();
        $('#jenkins').hide();
        $('#jira').hide();
        $('#confluence').hide();
        $('#noService').hide();
        $('#analytics').hide();
    });
};
toggleSonar = function( ) {
    $(document).ready(function () {
            getContent();
            function getContent() {
                $('#sonar').load("/sonar");
            }
        })
    $(document).ready(function () {
        $('#gitlab').hide();
        $('#mattermost').hide();
        $('#sonar').show();
        $('#rundeck').hide();
        $('#jenkins').hide();
        $('#jira').hide();
        $('#confluence').hide();
        $('#noService').hide();
        $('#analytics').hide();
    });
};
