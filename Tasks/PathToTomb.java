package Tasks;

import Resources.Variables;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.TilePath;

public class PathToTomb extends Task<ClientContext> {

    final TilePath path_to_tomb = ctx.movement.newTilePath(Resources.Variables.path_to_tomb_tiles);

    public PathToTomb (ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() { return

            !(ctx.backpack.select().count() == 28)
            && !Variables.catacomb_entrance.contains(ctx.players.local())
            && !Variables.catacomb_lobby.contains(ctx.players.local())
            && !Variables.catacomb_lower_level.contains((ctx.players.local()))
            && !Variables.catacomb_proper.contains(ctx.players.local());

    }

    @Override
    public void run() {

        System.out.println("proceeding to tomb");


            path_to_tomb.randomize(1, 1).traverse();



    }
}
