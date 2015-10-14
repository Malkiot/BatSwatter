package Tasks;

import Resources.Variables;
import org.powerbot.script.Interactive;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

public class GoDownStairs1 extends Task<ClientContext> {

    public GoDownStairs1(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() { return

            !(ctx.backpack.select().count() == 28)
            && !Variables.catacomb_entrance.contains(ctx.players.local())
            && Variables.catacomb_lobby.contains(ctx.players.local())
            && !Variables.catacomb_lower_level.contains((ctx.players.local()))
            && !Variables.bank.contains(ctx.players.local())
            && !Variables.catacomb_proper.contains(ctx.players.local());

    }

    @Override
    public void run() {

        //System.out.println("Going down Stair 1");

        GameObject stairs_1 = ctx.objects.select().id(Variables.stairs_1_id).nearest().poll();

        if (stairs_1.inViewport()) {

            stairs_1.interact("Climb down");

        } else {

            ctx.movement.step(stairs_1);
            ctx.camera.turnTo(stairs_1);

        }
    }
}
