public class PointSimulator {
    public static double total;
    public static double pointsPerClick = 1;
    public int critChance;
    private int critPrice;
    private int pointsPrice;
    private boolean cloneBought;
    private double clone;
    private int clonePrice;
    private boolean million;
    private boolean starting;
    private boolean gettingThere;
    private boolean lucky;
    private boolean ruler;
    private boolean noLife;
    private int pointsLevel;

    public PointSimulator() {
        pointsPerClick = 1;
        critChance = 1;
        critPrice = 1;
        pointsPrice = 1;
        cloneBought = false;
        clone = 0;
        clonePrice = 100;
        million = false;
        starting = false;
        gettingThere = false;
        lucky = false;
        ruler = false;
        noLife = false;
        pointsLevel = 1;
    }

    public String getCmd(String cmd) {
        if (cmd.equals("")) {
            return printPoints();
        }
        if (cmd.equals("/cmds")) {
            return helpcmds();
        }
        if (cmd.equals("/shop")) {
            return shop();
        }
        if (cmd.equals("/achievements")) {
            return achievement();
        }
        if (cmd.equals("/end")) {
            return "ENDGAME";
        }
        if (cmd.equals("UPGRADE1")) {
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
        if (cmd.equals("UPGRADE2")) {
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
        if (cmd.equals("/totalpoints")) {
            return (double) Math.round(total * 100)/100 + " total points!";
        }
        if (total >= 10 && !starting) {
            starting = true;
            return "Achievement Earned!: Starting out!";
        }
        if (total >= 100000 && !gettingThere) {
            gettingThere = true;
            return "Achievement Earned!: Getting there";
        }
        if (total >= 1000000000 && !million) {
            million = true;
            return "Achievement Earned!: MILLIONAIRE!!!";
        }
        if (critChance == 100 && !lucky) {
            lucky = true;
            return "Achievement Earned!: Lucky Man";
        }
        if (pointsLevel == 100 && !noLife) {
            noLife = true;
            return "Achievement Earned!: No life!";
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
    public String achievement() {
        return "\n\nACHIEVEMENTS: \nStarting out: get 10 points -- " + starting + "\nGetting there: get 100,000 points -- " + gettingThere + "\nMILLIONAIRE!!!: get 1,000,000 points -- " + million + "\nLucky Man: get 100% critical chance -- " + lucky + "\nNo Life!: get point level 100 -- " + noLife;
    }
}
