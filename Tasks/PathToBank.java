package Tasks;

import Resources.Lodestone;
import Resources.Variables;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.TilePath;

public class PathToBank extends Task<ClientContext> {

    final TilePath path_to_bank = ctx.movement.newTilePath(Resources.Variables.path_to_tomb_tiles).reverse();

    public PathToBank(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() { return

            (ctx.players.local().animation() == -1)
            && ctx.backpack.select().count() == 28
            && !Resources.Variables.bank.contains(ctx.players.local());

    }


    @Override
    public void run() {

        System.out.println("proceeding to bank");

        if (Variables.swatting_chamber.contains(ctx.players.local()) &&
                ctx.players.local().animation() == -1) {

            Lodestone.LUMBRIDGE.teleport(ctx);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else {

            if(ctx.players.local().animation() == -1) {

                path_to_bank.randomize(2, 2).traverse();

            }

        }

    }
}
