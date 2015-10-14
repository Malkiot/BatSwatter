package Tasks;

import Resources.Variables;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

public class EnterTomb extends Task<ClientContext> {

    public EnterTomb(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() { return

            !(ctx.backpack.select().count() == 28)
            && Variables.catacomb_entrance.contains(ctx.players.local())
            && !Variables.catacomb_lobby.contains(ctx.players.local())
            && !Variables.catacomb_lower_level.contains((ctx.players.local()))
            && !Variables.bank.contains(ctx.players.local())
            && !Variables.catacomb_proper.contains(ctx.players.local());

    }

    @Override
    public void run() {

        //System.out.println("Going in Tomb");

        GameObject catacomb_entrance = ctx.objects.select().id(Variables.catacomb_entrance_id).nearest().poll();
        catacomb_entrance.interact("Enter");

    }
}
