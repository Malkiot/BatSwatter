package Tasks;

import Resources.Variables;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.TilePath;

public class PathToChamber extends Task<ClientContext> {

    final TilePath path_to_swatting_chamber = ctx.movement.newTilePath(Resources.Variables.path_to_swatting_chamber_tiles);

    public PathToChamber(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() { return

            !(ctx.backpack.select().count() == 28)
            && Variables.catacomb_proper.contains(ctx.players.local())
            && !Variables.swatting_chamber.contains(ctx.players.local());

    }

    @Override
    public void run() {

        System.out.println("Trying to walk to Chamber");

        if(ctx.players.local().animation() == -1) {

            path_to_swatting_chamber.randomize(1, 1).traverse();

        }

    }
}
