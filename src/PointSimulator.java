/**
 * The PointSimulator class is the reciever of commands from the PointSimulator runner, it handles all logic in the program
 * like
 */
public class PointSimulator {
    public static double total;
    public static double pointsPerClick = 1;
    public static int critChance;
    public static boolean hiredWorker = false;
    private int critPrice;
    private int pointsPrice;
    private boolean million;
    private boolean starting;
    private boolean gettingThere;
    private boolean lucky;
    private boolean noLife;
    private int pointsLevel;
    private int workerPrice;

    /**
     * Constructor for the PointSimulator class. This creates a new instance of a PointSimulator
     *
     * WorkerPrice is the price to hire a worker
     * pointsPerClick is the points the user gets everytime they hit enter
     * critChance is the user's chance to get double points
     * critPrice is the upgrade price for critChance
     * pointsPrice is the upgrade price of pointsPerClick
     * million, starting, getingThere, lucky, noLife are all booleans to check if the user has the achievement or not
     * pointsLevel is to keep track of the user's pointsPerClick level
     */
    public PointSimulator() {
        workerPrice = 1;
        pointsPerClick = 1;
        critChance = 1;
        critPrice = 1;
        pointsPrice = 1;
        million = false;
        starting = false;
        gettingThere = false;
        lucky = false;
        noLife = false;
        pointsLevel = 1;
    }

    /**
     * getCmd method for the PointSimulator class. This method will take parameter String cmd which represents the users command, then it will return the corresponding string to the user input.
     *
     * @return returns the appropiate string depending on cmd
     */
    public String getCmd(String cmd) {
        if (cmd.equals("")) {
            return printPoints();
        }
        if (cmd.equals("/cmds")) {
            return "\n\nALL COMMANDS: \n/totalpoints -> view your total points\n/shop -> opens shop \n/end -> ends game! \n\n";
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
        if (cmd.equals("1")) {
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
        if (cmd.equals("2")) {
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
        if (cmd.equals ("3") && !hiredWorker) {
            hiredWorker = true;
        }
        if (cmd.equals ("3") && hiredWorker) {
            int speed = 1;
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

    /**
     * printPoints method will check if the user crits or not, and then prints out how many points the user gets
     *
     * @return returns a string that has "+ (amount of points)" and also notifies the user if they crit or not
     */
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

    /**
     * shop method will check if the user hired a worker or not and then return a string that represents the shop, this string changes depending on the variable previously stated
     *
     * @return returns a String containing total points and all upgrades purchasable
     */
    public String shop() {
        if (hiredWorker == false) {
            return "\n\nSHOP: \nTOTAL POINTS: " + total  + " points! \n\nCritical Chance " + critChance + "% -- enter 1 to buy: " + critPrice + " points \nPoints per click " + pointsPerClick + " points -- enter 2 to buy: " + pointsPrice + " points \nHire a worker!: Hire someone to earn points while afk -- enter 3 to buy: 1000 points";
        }
        else {
            return "\n\nSHOP: \nTOTAL POINTS: " + total  + " points! \n\nCritical Chance " + critChance + "% -- enter 1 to buy: " + critPrice + " points \nPoints per click " + pointsPerClick + " points -- enter 2 to buy: " + pointsPrice + " points";
        }
    }
    public String achievement() {
        return "\n\nACHIEVEMENTS: \nStarting out: get 10 points -- " + starting + "\nGetting there: get 100,000 points -- " + gettingThere + "\nMILLIONAIRE!!!: get 1,000,000 points -- " + million + "\nLucky Man: get 100% critical chance -- " + lucky + "\nNo Life!: get point level 100 -- " + noLife;
    }
}
