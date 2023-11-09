public class PointSimulator {
    private double total;
    private double pointsPerClick = 1;
    private int critChance = 1;
    private int critPrice = 1;
    private int pointsPrice = 1;
    private boolean cloneBought = false;
    private double clone = 0;
    private int clonePrice = 100;
    private boolean million = true;
    private boolean starting = true;
    private boolean gettingThere = true;
    private boolean critMaster = true;
    private boolean ruler = true;
    private boolean god = true;
    private int pointsLevel = 1;

    public PointSimulator() {}

    public String getCmd(String cmd) {
        if (cmd.equals("")) {
            return printPoints();
        }
        else if (cmd.equals("/cmds")) {
            return helpcmds();
        }
        else if (cmd.equals("/shop")) {
            return shop();
        }
        else if (cmd.equals("/end")) {
            return "ENDGAME";
        }
        else if (cmd.equals("UPGRADE1")) {
            if (total >= critPrice) {
                total -= critPrice;
                critChance ++;
                critPrice *= 2;
                return "Upgraded critical Chance! Your crit chance is now: " + critChance + "%";
            }
            else {
                return "UR BROKE!";
            }
        }
        else if (cmd.equals("UPGRADE2")) {
            if (total >= pointsPrice) {
                total -= pointsPrice;
                pointsPrice *= 2;
                pointsLevel ++;
                pointsPerClick *= 1.5;
                pointsPerClick = (double) Math.round(pointsPerClick * 100)/100;
                return "Upgraded points gained! You get " + pointsPerClick + " points per click!";
            }
            else {
                return "UR BROKE!";
            }
        }
        else if (cmd.equals("/totalpoints")) {
            return (double) Math.round(total * 100)/100 + " total points!";
        }
        else {
            return "Not a valid command!";
        }
    }


    public String printPoints() {
        double points = pointsPerClick;
        if ((int) (Math.random() * 100 + 1) <= critChance ) {
            points *= 2;
            total += points;
            return "CRITICAL! + " + points + " points!";
        }
        else {
            total += points;
            return "+ " + points + " points!";
        }
    }

    public String helpcmds() {
        return "\n\nALL COMMANDS: \n/totalpoints -> view your total points\n/shop -> opens shop \n/end -> ends game! \n\n";
    }

    public String shop() {
        return "\n\nSHOP: \nTOTAL POINTS: " + total  + " points! \n\nCritical Chance " + critChance + "% -- UPGRADE1: " + critPrice + " points \nPoints per click " + pointsPerClick + " points -- UPGRADE2: " + pointsPrice + " points \nCloning Machine: Clone yourself to make more points! -- " + clonePrice;
    }
}
