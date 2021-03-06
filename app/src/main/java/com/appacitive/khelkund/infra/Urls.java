package com.appacitive.khelkund.infra;

import java.util.HashMap;

/**
 * Created by sathley on 3/24/2015.
 */
public class Urls {

    private static String baseUrl = "http://www.khelkund.com/ipl/Service/";

    public static class PlayerUrls
    {
        public static String getAllPlayersUrl() {
            return baseUrl + "PlayerService.svc/Players";
        }

        public static String getPlayerDetailsUrl(String playerId) {
            return baseUrl + "PlayerService.svc/PlayerDetails/" + playerId + "/allrounder";
        }
    }

    public static class MatchUrls
    {
        public static String getScoreboardUrl(String matchId, String userId) {
            return String.format("http://www.khelkund.com/test/service/MatchService.svc/MatchScorecard/%s/%s", matchId, userId);
        }
    }

    public static class PrivateLeagueUrls
    {
        public static String getJoinPrivateLeaguesUrl()
        {
            return baseUrl + "PrivateLeagueService.svc/JoinPrivateLeague";
        }

        public static String getPrivateLeaguesUrl(String userId)
        {
            return baseUrl + "PrivateLeagueService.svc/PrivateLeagues/" + userId;
        }

        public static String getCreatePrivateLeaguesUrl()
        {
            return baseUrl + "PrivateLeagueService.svc/CreatePrivateLeague";
        }

        public static String getLeavePrivateLeaguesUrl()
        {
            return baseUrl + "PrivateLeagueService.svc/LeavePrivateLeague";
        }
    }

    public static class Pick5Urls
    {
        public static String getAllMatchesUrl()
        {
            return baseUrl + "PickThemFiveService.svc/GetMatches";
        }

        public static String getMatchesDetailsUrl(String userId, String matchId)
        {
            return baseUrl + String.format("PickThemFiveService.svc/GetPickThemTeam/%s/%s", matchId, userId);
        }

        public static String getSaveTeamUrl()
        {
            return baseUrl + "PickThemFiveService.svc/SavePickThemTeam";
        }
    }

    public static class TeamUrls
    {
        public static String getMyTeamUrl(String userId)
        {
            return baseUrl + "UserTeamService.svc/UserTeam/" + userId;
        }

        public static String getAllTeamsCountUrl()
        {
            return baseUrl + "UserTeamService.svc/Count";
        }

        public static String saveTeamUrl()
        {
            return baseUrl + "UserTeamService.svc/SaveTeam";
        }
    }

    public static class AppacitiveUrls
    {
        public static String getRegisterDeviceUrl()
        {
            return "https://apis.appacitive.com/v1.0/connection/user_device";
        }

        public static String getAllPlayersUrl()
        {
            return "https://apis.appacitive.com/v1.0/connection/series_player/series/88663391933170156/find?returnedge=false?pnum=1&psize=300&orderBy=price&isAsc=false";
        }

        public static HashMap<String, String> getHeaders()
        {
            return new HashMap<String, String>(){{
                put("Appacitive-Environment", "live");
                put("Appacitive-Apikey", "+HfTOp2nF8TnkyZVBblkTBLm6Cz6zIfKYdXBhV6Aag4=");
            }};
        }
    }

    public static class UserUrls
    {
        public static String getLoginUrl()
        {
            return baseUrl + "Loginservice.svc/login";
        }

        public static String getReferralCodeUrl()
        {
            return baseUrl + "LoginService.svc/EnterReferralCode";
        }

        public static String getFacebookLoginUrl()
        {
            return baseUrl + "Loginservice.svc/registerfacebook";
        }

        public static String getTwitterLoginUrl()
        {
            return baseUrl + "Loginservice.svc/registertwitter";
        }

        public static String getSignupUrl()
        {
            return baseUrl + "Loginservice.svc/register";
        }

        public static String getUserUrl(String userId) {
            return baseUrl + "LoginService.svc/LoggedIn/" + userId;
        }
    }

    public static class LeaderboardUrls {

        public static String getLeaderboardUrl(String userId)
        {
            return baseUrl + "privateleagueservice.svc/leaderboard/" + userId;
        }
    }
}
