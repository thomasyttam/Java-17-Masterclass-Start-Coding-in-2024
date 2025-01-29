package dev.lpa;

interface Player {}
record BaseballPlayer(String name, String position) implements Player{}
record FootballPlayer(String name, String position) implements Player{}

public class Main {

    public static void main(String[] args) {

        BaseballTeam phillies1 = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros1 = new BaseballTeam("Huston Astros");
        scoreResult(phillies1, 3, astros1, 5);

        SportsTeam phillies2 = new SportsTeam("Philadelphia Phillies");
        SportsTeam astros2 = new SportsTeam("Huston Astros");
        scoreResult(phillies2, 3, astros2, 5);

//        Team phillies = new Team("Philadelphia Phillies");
//        Team astros = new Team("Huston Astros");
        Team<BaseballPlayer> phillies = new Team("Philadelphia Phillies");
        Team<BaseballPlayer> astros = new Team("Huston Astros");
        scoreResult(phillies, 3, astros, 5);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        var guthrie = new BaseballPlayer("D Guthrie", "Centre Fielder");
        phillies.addTeamMember(guthrie);
        phillies.listTeamMembers();

        SportsTeam afc1 = new SportsTeam("Adelaide Crows");
        Team<FootballPlayer> afc = new Team<>("Adelaide Crows");
        var tex = new FootballPlayer("Tex Walker", "Centre half forward");
        afc.addTeamMember(tex);
//        var guthrie = new BaseballPlayer("D Guthrie", "Centre Fielder");
//        afc.addTeamMember(guthrie);
        var rory = new FootballPlayer("Rory Laird", "Midfield");
        afc.addTeamMember(rory);
        afc.listTeamMembers();

        Team<String> adelaide = new Team<>("Adelaide Storm");
        adelaide.addTeamMember("N Roberts");
        adelaide.listTeamMembers();

        var canberra = new Team<String>("Canberra Heat");
        canberra.addTeamMember("B Black");
        canberra.listTeamMembers();
        scoreResult(canberra, 0 , adelaide, 1);

//        Team<int> melbourneVB = new Team<>("Melbourne Vipers");
        Team<Integer> melbourneVB = new Team<>("Melbourne Vipers");
    }

    public static void scoreResult(SportsTeam team1, int t1_score,
                                   SportsTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(BaseballTeam team1, int t1_score,
                                   BaseballTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(Team team1, int t1_score,
                                   Team team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
