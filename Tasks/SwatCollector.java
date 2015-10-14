package Tasks;

import Resources.Variables;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GroundItem;
import org.powerbot.script.rt6.Player;

public class SwatCollector extends Task<ClientContext> {

    public SwatCollector (ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() { return

            !(ctx.backpack.select().count() == 28)
            && Variables.swatting_chamber.contains(ctx.players.local())
            && !ctx.groundItems.select().id(Variables.batwing_id).isEmpty();
    }

    @Override
    public void run() {

        System.out.println("I'm a horder.");

        GroundItem batwing = ctx.groundItems.select().id(Variables.batwing_id).nearest().poll();
        //batwing.interact("Take");

        if (batwing.inViewport()) {

            System.out.println("I see a wing.");

            batwing.interact(false, "Take","Batwing");

        } else {

            ctx.movement.step(batwing);
            ctx.camera.turnTo(batwing);

        }

        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
