package Tasks;

import Resources.Variables;
import org.powerbot.script.Interactive;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

public class GoDownStairs2 extends Task<ClientContext> {

    public GoDownStairs2(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() { return

            !(ctx.backpack.select().count() == 28)
            && Variables.catacomb_lower_level.contains((ctx.players.local()));

    }

    @Override
    public void run() {

        //System.out.println("Going down Stair 2");

        GameObject stairs_2 = ctx.objects.select().id(Variables.stairs_2_id).nearest().poll();
        if (stairs_2.inViewport()) {

            stairs_2.interact("Climb down");

        } else {

            ctx.movement.step(stairs_2);
            ctx.camera.turnTo(stairs_2);

        }
    }
}
