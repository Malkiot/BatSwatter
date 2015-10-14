package Tasks;

import Resources.Variables;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Interactive;

public class Bank extends Task<ClientContext> {

    public Bank(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() { return

           ctx.backpack.select().count() == 28
        && !Variables.catacomb_entrance.contains(ctx.players.local())
        && !Variables.catacomb_lobby.contains(ctx.players.local())
        && !Variables.catacomb_lower_level.contains((ctx.players.local()))
        && Variables.bank.contains(ctx.players.local())
        && !Variables.catacomb_proper.contains(ctx.players.local());
    }


    @Override
    public void run() {

        GameObject bank_chest = ctx.objects.select().id(Variables.bank_chest_id).nearest().poll();

        if (bank_chest.inViewport()) {

            if(!ctx.bank.opened()) {

                bank_chest.interact("Use");

            } else {

                if(ctx.backpack.select().count() == 28) {

                    ctx.bank.depositInventory();

                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(ctx.backpack.select().count() < 28) {

                    ctx.bank.close();

                }
            }

        } else {

            ctx.movement.step(bank_chest);
            ctx.camera.turnTo(bank_chest);

        }

    }
}
