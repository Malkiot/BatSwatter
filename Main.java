/****************************************************************
 * Thanks to Chris, Artificial, and Mookyman for their advice.  *
 *                                                              *
 * Additional thanks to Artificial for his Lodestone API        *
 *                                                              *
 *TODO: Antipattern and include LawRunes in Profit Calc         *
 ***************************************************************/

import Resources.Variables;
import org.powerbot.script.*;
import org.powerbot.script.rt6.*;
import org.powerbot.script.rt6.ClientContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Script.Manifest(name = "Bat Swatter", description = "Grabs Z Wine", properties = "client=6; topic=0;")

public class Main extends PollingScript<ClientContext> implements PaintListener {

    int wing_price;
    int wing_count_1;
    int wing_count_2;
    int wing_count;

    private List<Tasks.Task> taskList = new ArrayList<Tasks.Task>();

    //Detect Location, LvL, Inventory. Launch GUI
    @Override
    public void start() {

        startTime = System.currentTimeMillis();

        System.out.println("Script Started!");

        //Create Task List
        taskList.addAll(Arrays.asList(
                        new Tasks.Bank(ctx),
                        new Tasks.EnterTomb(ctx),
                        new Tasks.GoDownStairs1(ctx),
                        new Tasks.GoDownStairs2(ctx),
                        new Tasks.PathToBank(ctx),
                        new Tasks.PathToChamber(ctx),
                        new Tasks.PathToTomb(ctx),
                        new Tasks.Swatter(ctx),
                        new Tasks.SwatCollector(ctx)
                        )
        );

        wing_price = GeItem.price(Variables.batwing_id);

    }

    @Override
    public void poll() {

        //System.out.println("I am in the Dungeon:" + Variables.catacomb_proper.contains(ctx.players.local()));
        //System.out.println("I am not in the Chamber:" + !Variables.swatting_chamber.contains(ctx.players.local()));
        //System.out.println("1"+(ctx.players.local().animation() == -1));        //!(ctx.players.local().animation() == -1)
        //System.out.println("2"+ (ctx.backpack.select().count() == 28));        //&& ctx.backpack.select().count() == 28
        //System.out.println("3"+Resources.Variables.bank.contains(ctx.players.local()));        //&& !Resources.Variables.bank.contains(ctx.players.local());
        /*if(!(ctx.backpack.select().count() == 28)
                && Variables.swatting_chamber.contains(ctx.players.local())
                && ctx.groundItems.select().id(Variables.batwing_id).isEmpty()) {
        System.out.println("I want to Kill"); }*/

        wing_count_1 = ctx.backpack.id(Variables.batwing_id).select().count();

        for (Tasks.Task task : taskList) {
            if (task.condition()) {
                task.run();
            }
        }

        wing_count_2 = ctx.backpack.id(Variables.batwing_id).select().count();

        if(wing_count_2 > wing_count_1){
            wing_count = wing_count + (wing_count_2 - wing_count_1);
        }

    }


    //Paint Variables
    int hours;
    int minutes;
    int seconds;

    long startTime;
    long endTime;
    long totalTime;

    int profit;
    int hourly_profit;
    int wing_count_hourly;

    public void repaint(Graphics g) {

        //Timer
        endTime   = System.currentTimeMillis();
        totalTime = ((endTime - startTime)/1000);
        hours = (int) Math.floor(totalTime / 3600);
        minutes = (int) Math.floor((totalTime - hours*3600)/60);
        seconds = (int) Math.floor((totalTime - minutes*60));

        profit = wing_count*wing_price;
        hourly_profit = (int) Math.floor(profit/totalTime*3600);
        wing_count_hourly = (int) Math.round(wing_count*3600/totalTime);

        g.setColor(new Color(0, 0, 0, 146));
        g.fillRect(5, 5, 115, 60);
        g.setColor(Color.GREEN);
        g.drawString("Runtime: " +String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":"
                + String.format("%02d", seconds), 8, 20);
        g.drawString("Grabbed: " + wing_count + " (" + wing_count_hourly + ")", 8, 60);
        g.drawString("Profit: " + profit + " (" + hourly_profit + ")", 8, 40);
        g.drawRect(5, 5, 115, 60);

    }

    @Override
    public void stop()
    {
        System.out.println("Script Stopped!");
    }

}
