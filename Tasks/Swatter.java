package Tasks;

import Resources.Variables;
import org.powerbot.bot.rt6.client.Actor;
import org.powerbot.script.Filter;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Interactive;
import org.powerbot.script.rt6.Npc;

public class Swatter extends Task<ClientContext> {

    /*private final Filter<Npc> bat_filter = new Filter<Npc>() {
        @Override
        public boolean accept(Npc bat) {
            return (ctx.npcs.select().id(Variables.bat_id);
        }
    };*/

    public static final Filter<Npc> FILTER = new Filter<Npc>() {

        @Override
        public boolean accept(Npc n) {
            if ((n.healthPercent()) > 0) {
                    return true; } else {
            return false; }
        }

    };

    public Swatter (ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() { return

            !(ctx.backpack.select().count() == 28)
            && Variables.swatting_chamber.contains(ctx.players.local())
            && ctx.groundItems.select().id(Variables.batwing_id).isEmpty();
    }

    @Override
    public void run() {

        System.out.println("I want to kill.");

        //Npc bat = ctx.npcs.select().id(Variables.bat_id).each(Interactive.doSetBounds(Variables.bat_bounds)).nearest().poll();
        Npc bat = ctx.npcs.select().id(Variables.bat_id).nearest().poll();

        if (bat.inViewport()) {

            bat.interact("Attack");
            System.out.println("I See a bat.");
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else {

            ctx.movement.step(bat);
            ctx.camera.turnTo(bat);

        }

        //bat.hover();
        //bat.click("Attack");

    }
}
