package Resources;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;

public class Variables {

    //IDs
    public static int bat_id = 7922;
    public static int batwing_id = 25549;
    public static int bank_chest_id = 79036;
    public static int catacomb_entrance_id = 48797;
    public static int stairs_1_id = 48680;
    public static int stairs_2_id = 48688;

    //Bounds
    public static int[] bat_bounds = {-108, -976, -72, 120, -864, 132} ;

    //Catacomb Entrance
    private static Tile tile1 = new Tile(3242, 3196, 0);
    private static Tile tile2 = new Tile(3246, 3201, 0);
    public static Area catacomb_entrance = new Area(tile1, tile2);

    //Catacomb Lobby
    private static Tile tile3 = new Tile(3879, 5526, 1);
    private static Tile tile4 = new Tile(3875, 5529, 1);
    public static Area catacomb_lobby = new Area(tile3, tile4);

    //Catacomb Lower Level
    private static Tile tile5 = new Tile(3870, 5526, 0);
    private static Tile tile6 = new Tile(3863, 5522, 0);
    public static Area catacomb_lower_level = new Area(tile5, tile6);

    //Catacomb Proper
    private static Tile tile7 = new Tile(3970, 5566, 0);
    private static Tile tile8 = new Tile(4030, 5489, 0);
    public static Area catacomb_proper = new Area(tile7, tile8);

    //Swatting Chamber
    private static Tile tile9 = new Tile(4011, 5521, 0);
    private static Tile tile10 = new Tile(4030, 5005, 0);
    public static Area swatting_chamber = new Area(tile9, tile10);

    //Bank
    private static Tile tile11 = new Tile(3218, 3253, 0);
    private static Tile tile12 = new Tile(3209, 3258, 0);
    public static Area bank = new Area(tile11, tile12);

    public static Tile[] path_to_tomb_tiles = {

            new Tile(3212, 3258, 0), // Lumbridge Bank Chest
            new Tile(3220, 3249, 0),
            new Tile(3223, 3241, 0),
            new Tile(3229, 3233, 0),
            new Tile(3236, 3224, 0),
            new Tile(3236, 3218, 0),
            new Tile(3236, 3208, 0),
            new Tile(3293, 3201, 0),
            new Tile(3245, 3198, 0), // Catacomb Entrance
    };

    public static Tile[] path_to_swatting_chamber_tiles = {

            new Tile(3972, 5562, 0), // Catacomb Stairs
            new Tile(3972, 5553, 0),
            new Tile(3987, 5553, 0),
            new Tile(3989, 5544, 0),
            new Tile(4000, 5544, 0),
            new Tile(4010, 5544, 0),
            new Tile(4023, 5541, 0),
            new Tile(4024, 5529, 0),
            new Tile(4024, 5515, 0), // Swatting Chamber
    };

}
